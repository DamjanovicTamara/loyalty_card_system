insert into user(id, username,password,enabled,role_id) values (1, 'user','$2a$12$qO/8DJAejBL75z7WYHSXaOuXJroWAQrkWsLXn31tliWHVikkCvth2',true,1);
insert into user(id, username,password,enabled,role_id) values (2, 'user1','$2a$12$qO/8DJAejBL75z7WYHSXaOuXJroWAQrkWsLXn31tliWHVikkCvth2',true,1);
insert into user(id, username,password,enabled,role_id) values (3, 'user2','$2a$12$qO/8DJAejBL75z7WYHSXaOuXJroWAQrkWsLXn31tliWHVikkCvth2',true,1);
insert into user(id, username,password,enabled,role_id) values (4, 'admin','$2a$12$IrSO5H5v3N52lYfrqDLI.OdumB5rJM0D5yTWzXxoEZdPGvkXEgj62',true,2);

insert into role(id,name) values (1,'USER');
insert into role(id,name) values (2,'ADMIN');

insert into cashier(cashier_id, username) values (1000, 'user');
insert into cashier(cashier_id, username) values (1001, 'admin');
insert into cashier(cashier_id, username) values (1002, 'user1');
insert into cashier(cashier_id, username) values (1003, 'user2');
commit;
insert into customer(customer_id, name, surname,mobile_number,id_number,total_points) values(1,'test1Customer','test1Surname',99889990,123458,0);
insert into customer(customer_id, name, surname,mobile_number,id_number,total_points) values(2,'test2Customer','test2Surname',99889800,123459,20);
insert into customer(customer_id, name, surname,mobile_number,id_number,total_points) values(3,'test3Customer','test3Surname',98888800,123333,500);
insert into customer(customer_id, name, surname,mobile_number,id_number,total_points) values(4,'test4Customer','test4Surname',98009900,123455,100);