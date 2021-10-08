
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  surname VARCHAR(250) NOT NULL,
  mobile_number INT NOT NULL,
  id_number INT NOT NULL,
  total_points DOUBLE
);
DROP TABLE IF EXISTS cashier;

CREATE TABLE cashier (
  cashier_id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS purchase;

CREATE TABLE purchase (
  purchase_id INT AUTO_INCREMENT  PRIMARY KEY,
  amount DOUBLE NOT NULL,
  points DOUBLE,
  redeem VARCHAR(20),
  redeem_amount INT,
  saved_on TIMESTAMP,
  cashier_id INT NOT NULL,
    FOREIGN KEY (cashier_id) REFERENCES cashier(cashier_id),
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

DROP TABLE IF EXISTS user;

CREATE TABLE user(
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
enabled BOOLEAN,
role_id INT NOT NULL
);

DROP TABLE IF EXISTS role;

CREATE TABLE role(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL
);

