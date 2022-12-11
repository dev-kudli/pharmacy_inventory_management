DROP TABLE person;
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

CREATE TABLE pharmacy_store(
store_id INT PRIMARY KEY AUTO_INCREMENT,
pharmacy_id INT,
store_name VARCHAR(100) not null,
store_address VARCHAR(100) not null,
store_zip VARCHAR(10) not null,
store_city VARCHAR(25) not null,
foreign key (pharmacy_id) references company(company_id)
);


DROP TABLE pharmacy_order;
CREATE TABLE pharmacy_order(
order_id INT PRIMARY KEY AUTO_INCREMENT,
pharmacy_id INT NOT NULL,
manufacturer_id INT NOT NULL,
order_date DATE,
order_status varchar(10)
);

DROP TABLE pharmacy_order_item;
CREATE TABLE pharmacy_order_item(
order_item_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT NULL,
cost_price DECIMAL,
foreign key (order_id) references pharmacy_order(order_id)
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

DROP TABLE manufacturer_inventory;
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

DROP TABLE shipment;
CREATE TABLE shipment(
shipment_id INT primary key auto_increment,
order_id INT,
distributor_id INT,
transporter_id INT,
foreign key (order_id) references pharmacy_order(order_id),
foreign key (distributor_id) references company(company_id),
foreign key (transporter_id) references company(company_id)
);

drop table transport_vehicle;
create table transport_vehicle(
transporter_id INT primary key,
vehicle_count INT,
foreign key (transporter_id) references company(company_id)
);

