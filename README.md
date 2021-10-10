# loyalty_card_system
Supermarket Loyalty Card System

Spring boot REST API calculate operation of reward and redeem points based on purchase amount.
API uses Spring security for authentication,Thymeleaf for Login page only, other URL's renders data in  JSON format.

User have an option to login and use below Http requests:

GET http://localhost:8080/purchases/user  
  Displays current logged user- cashier 

GET http://localhost:8080/customers
  List of customers in supermarket who had purchases

POST http://localhost:8080/customers/createCustomer
  Created customer will be in relation with purchase

POST http://localhost:8080/purchases/createPurchase -> user has to be authenticated to perform action
  When purchase is created reward points are calculated both for purchase and current customer.

GET http://localhost:8080/purchases
  List of all purchases in supermarket

POST http://localhost:8080/redeemLastPurchase -> user has to be authenticated to perform action
  Operation to redeem reward points from last purchase and from customer

GET http://localhost:8080/customers/getTotalPointsBalance
  Returns total balance points for current customer

  



