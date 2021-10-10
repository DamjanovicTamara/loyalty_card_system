package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.configuration.SecurityUtils;
import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.domain.Cashier;
import com.example.loyaltycardsystem.domain.User;
import com.example.loyaltycardsystem.service.AuditUserService;
import com.example.loyaltycardsystem.service.CashierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
@SessionAttributes("loggedCashier")
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    CashierService cashierService;

    @Autowired
    AuditUserService auditUserService;

    @GetMapping(value="/user")
    public ResponseEntity<User> getLoggedInUser(){
        com.example.loyaltycardsystem.domain.User userDetails = SecurityUtils.getCurrentUserDetails();
        return ResponseEntity.ok(userDetails);
    }

    @RequestMapping("/")
    public String index() {
        return "login.html";
    }

    // Login form
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }


    @RequestMapping("/welcome")
    public String greeting(Model model) {
        Cashier cashier = cashierService.findLoggedCashier();// uses SpringContext Authentication object
        Long cashierId = cashier.getCashierId();
        model.addAttribute("cashier",cashierId ); // to bind obj cashier to thymeleaf
        model.addAttribute("cashierObject",new Cashier(cashier.getCashierId(),cashier.getUsername()));//to use logged in user in post methods

        AuditUser auditUser = new AuditUser();
        auditUser.setCashier(cashier);
        auditUser.setLoggedTime(LocalDateTime.now());
        auditUserService.saveAuditUser(auditUser);
        return "welcome.html" ;
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST) // we have logoutHandler in SecurityConfiguration
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
