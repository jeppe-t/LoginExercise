drop table IF EXISTS users;

CREATE TABLE users(
						userid int auto_increment primary key,
						first_name varchar(100),
						last_name varchar(100),
						adress varchar(200),
						phone varchar(45),
						username varchar(200),
						password varchar(200)
                        
					);


INSERT INTO login.users VALUES (1,'Jeppe','T','Highway 102','+4520586363','Jeppe','1234'),
(2,'Hank','Moody','Hollywood Boulevard 5','+555656565446','Hank','12345678'),
(3,'Jacob','Jensen','Grønnevej 10','+452532144','Jacob','0000'),
(4,'Henrik','Hansen','Road 66','+4523236060','Henrik','1111');

