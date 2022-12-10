
USE  pharmacy_inventory_management;

DROP TABLE IF EXISTS distributor_order_item;
DROP TABLE IF EXISTS distributor_order;
DROP TABLE IF EXISTS manufacturer_inventory;
DROP TABLE IF EXISTS pharmacy_order_item;
DROP TABLE IF EXISTS pharmacy_order;
DROP TABLE IF EXISTS pharmacy_inventory;
DROP TABLE IF EXISTS master_drug_table;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS company;

CREATE TABLE master_drug_table(
drug_id INT PRIMARY KEY AUTO_INCREMENT,
drug_name VARCHAR(100) NOT NULL
);

CREATE TABLE person(
username VARCHAR(10) PRIMARY KEY,
person_name VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
person_dob Date,
person_gender CHAR(6),
person_role VARCHAR(20) NOT NULL,
person_address VARCHAR(100),
person_city VARCHAR(20),
person_country VARCHAR(20),
person_state VARCHAR(20)
);

DROP TABLE master_drug_table;
CREATE TABLE master_drug_table(
drug_id INT PRIMARY KEY AUTO_INCREMENT,
drug_name VARCHAR(100) NOT NULL
);

DROP TABLE company;
CREATE TABLE company(
company_id INT PRIMARY KEY AUTO_INCREMENT,
company_name VARCHAR(100) NOT NULL,
company_type VARCHAR(20) NOT NULL,
registered_date DATE,
company_owner VARCHAR(10),
foreign key (company_owner) references person(username)
);

DROP TABLE pharmacy_order;
CREATE TABLE pharmacy_order(
order_id INT PRIMARY KEY AUTO_INCREMENT,
pharmacy_id INT NOT NULL,
manufacturer_id INT NOT NULL,
order_date DATE,
order_status varchar(10)
);

CREATE TABLE distributor_order_item(
order_item_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT NULL
);

CREATE TABLE company(
company_id INT PRIMARY KEY AUTO_INCREMENT,
company_name VARCHAR(100) NOT NULL,
company_type VARCHAR(20) NOT NULL,
registered_date DATE,
company_owner VARCHAR(10),
foreign key (company_owner) references person(username)
);

DROP TABLE pharmacy_inventory;
CREATE TABLE pharmacy_inventory(
inventory_id INT primary key auto_increment,
pharmacy_id INT,
drug_id INT,
quantity BIGINT NOT NULL,
cost_price BIGINT,
selling_price BIGINT,
FOREIGN KEY (drug_id) REFERENCES master_drug_table(drug_id),
FOREIGN KEY (pharmacy_id) REFERENCES company(company_id)
);

CREATE TABLE pharmacy_order_item(
order_item_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT NULL,
foreign key (order_id) references pharmacy_order(order_id)
);

CREATE TABLE manufacturer_inventory(
manufacturer_id INT,
drug_id INT,
quantity BIGINT NOT NULL,
cost_price BIGINT,
selling_price BIGINT,
PRIMARY KEY(manufacturer_id, drug_id),
FOREIGN KEY (drug_id) REFERENCES master_drug_table(drug_id),
FOREIGN KEY (manufacturer_id) REFERENCES company(company_id)
);

CREATE TABLE distributor_order(
order_id INT PRIMARY KEY AUTO_INCREMENT,
distributor_id INT NOT NULL,
manufacturer_id INT NOT NULL,
order_date DATE NOT NULL,
order_status VARCHAR(10),
FOREIGN KEY (distributor_id) REFERENCES company(company_id),
FOREIGN KEY (manufacturer_id) REFERENCES company(company_id)
);