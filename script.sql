use `mydb`;

insert into ages (age) values (21);
insert into ages (age) values (22);
insert into ages (age) values (23);
insert into ages (age) values (24);
insert into ages (age) values (25);
insert into ages (age) values (26);
insert into ages (age) values (27);
insert into ages (age) values (28);
insert into ages (age) values (29);
insert into ages (age) values (30);
insert into ages (age) values (31);
insert into ages (age) values (32);
insert into ages (age) values (33);
insert into ages (age) values (34);
insert into ages (age) values (35);
insert into ages (age) values (36);
insert into ages (age) values (37);
insert into ages (age) values (38);
insert into ages (age) values (39);
insert into ages (age) values (40);
insert into ages (age) values (41);
insert into ages (age) values (42);
insert into ages (age) values (43);
insert into ages (age) values (44);
insert into ages (age) values (45);
SELECT * FROM ages;


insert into countries (country) values ('Belarus');
insert into countries (country) values ('Russia');
insert into countries (country) values ('USA');
insert into countries (country) values ('Japan');
insert into countries (country) values ('China');
insert into countries (country) values ('Korea');
insert into countries (country) values ('Singapore');
insert into countries (country) values ('Vietnam');
insert into countries (country) values ('India');

INSERT INTO phonestores (name, StoreAdress_id, StoresSquare_id) VALUES ('Nemiga', 6, 6);
INSERT INTO phonestores (name, StoreAdress_id, StoresSquare_id) VALUES ('MTS', 7, 7);
INSERT INTO phonestores (name, StoreAdress_id, StoresSquare_id) VALUES ('Svyznoi', 8, 8);
INSERT INTO phonestores (name, StoreAdress_id, StoresSquare_id) VALUES ('Bilain', 9, 9);

INSERT INTO clients (name, surname, Ages_id) VALUES ('Goblin', 'Green', 16);
INSERT INTO clients (name, surname, Ages_id) VALUES ('Piter', 'Parker', 19);

UPDATE clients SET surname = 'Morozov', Ages_id = 16 WHERE id = 3;
UPDATE phonestores SET name = 'MTC Inc' WHERE id = 7;
UPDATE techniques SET Prices_id = 8 WHERE id = 2;
UPDATE workers SET WorkerPosition_id = 2 WHERE id = 3;
UPDATE orders SET date = '2021-08-31' WHERE (`id` = '1');
UPDATE orders SET date = '2021-12-30' WHERE (`id` = '2');
UPDATE orders SET date = '2022-03-08' WHERE (`id` = '3');
UPDATE orders SET date = '2022-05-05' WHERE (`id` = '4');
    
DELETE FROM orders WHERE date <= '2022-01-01';
DELETE FROM techniques WHERE Countries_id = 1;
DELETE FROM countries WHERE id = 1;

ALTER TABLE clients ADD email varchar(225);
ALTER TABLE clients ADD fatherName varchar(45);

UPDATE clients SET `email` = 'pbel@gmail.com', `fatherName` = 'pam' WHERE (`id` = '1');
UPDATE clients SET `email` = 'iviv@gmail.com', `fatherName` = 'vim' WHERE (`id` = '2');
UPDATE clients SET `email` = 'petmor@mail.ru', `fatherName` = 'sam' WHERE (`id` = '3');
UPDATE clients SET `email` = 'smiralex@gmail.com', `fatherName` = 'rom' WHERE (`id` = '4');
UPDATE clients SET `email` = 'panda228@gmail.com', `fatherName` = 'cat' WHERE (`id` = '5');
UPDATE clients SET `email` = 'silavpravde@mail.ua', `fatherName` = 'dog' WHERE (`id` = '6');
UPDATE clients SET `email` = 'scala@gmail.com', `fatherName` = 'zod' WHERE (`id` = '7');

ALTER TABLE clients DROP COLUMN fatherName;

SELECT clients.name, clients.surname, ages.age from clients
INNER JOIN ages on clients.Ages_id = ages.id;

SELECT phonestores.name, storeadress.adress, storessquare.square FROM phonestores
INNER JOIN storeadress ON phonestores.StoreAdress_id = storeadress.id
INNER JOIN storessquare ON phonestores.StoresSquare_id = storessquare.id;

SELECT clients.name, orders.price FROM orders
LEFT JOIN clients ON clients.id = orders.Clients_id;

SELECT clients.name, orders.price FROM orders
RIGHT JOIN clients ON clients.id = orders.Clients_id;

SELECT * FROM techniques;

SELECT techniques.name AS Techniques_Name, phonestores.name AS Store_Name, prices.price, models.model, countries.country, years.year FROM techniques
JOIN models ON models.id = techniques.Models_id
JOIN prices ON prices.id = techniques.Prices_id
JOIN years ON years.id = techniques.Years_id
JOIN countries ON countries.id = techniques.Countries_id
JOIN phonestores ON phonestores.id = techniques.PhoneStores_id;

SELECT avg(orders.price) from orders;

SELECT workerposition.position, group_concat(workers.name) from workerposition
inner join workers
on workerposition.id = workers.WorkerPosition_id
group by(workerposition.position);

SELECT workers.name, AVG(workersexperience.experience)
from workers
inner join workersexperience on workersexperience.id = workers.WorkersExperience_id
group by(workers.name)
having AVG(workersexperience.experience) > 5;

SELECT clients.name, orders.price from clients
inner join orders on clients.id = orders.Clients_id
group by(clients.name)
having price > 200;

SELECT phonestores.name, max(storessquare.square) from phonestores
inner join storessquare;

select * FROM clients;