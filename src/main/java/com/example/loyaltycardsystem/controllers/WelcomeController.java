package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.CashierDTO;
import com.example.loyaltycardsystem.domain.Cashier;
import com.example.loyaltycardsystem.service.CashierService;
import com.example.loyaltycardsystem.service.UserService;
import com.example.loyaltycardsystem.service.UserServiceTry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@SessionAttributes("loggedCashier")
public class WelcomeController {

    @Autowired
    CashierService cashierService;

    @Autowired
    UserService userService;

    @ModelAttribute("loggedCashier")
    public Cashier loggedCashier() {
       // Cashier cashier = cashierService.findLoggedCashier();
        return new Cashier();
    }


    @RequestMapping("/")
    public String index() {
        return "login.html";
    }
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }


    @RequestMapping("/welcome")
    public String greeting(Model model, RedirectAttributes attributes, HttpSession httpSession) {
        Cashier cashier = cashierService.findLoggedCashier();
        Long cashierId = cashierService.findLoggedCashier().getCashierId();// uses SpringContext Authentication object
        model.addAttribute("cashier",cashierId ); // to bind obj cashier to thymeleaf
        model.addAttribute("cashierObject",new Cashier(cashier.getCashierId(),cashier.getUsername()));//to use logged in user in post methods
       // attributes.addFlashAttribute("cashierObject",new CashierDTO(cashier.getCashierId(),cashier.getUsername()));

        httpSession.setAttribute("cashierSession",cashier);

        HttpSession session=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("session",cashier);
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
