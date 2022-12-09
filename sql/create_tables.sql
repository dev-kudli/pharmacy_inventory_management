drop table user;
create table user(
user_id INT primary key auto_increment,
username VARCHAR(50) not null,
password VARCHAR(50) not null,
role VARCHAR(20) not null
);

drop table distributor_order;
create table distributor_order(
order_id INT primary key auto_increment,
distributor_id INT not null,
manufacturer_id INT not null,
order_date DATE not null
);

drop table distributor_order_item;
create table distributor_order_item(
order_item_id INT primary key auto_increment,
order_id INT not null,
item_id INT not null,
quantity INT not null
);

drop table pharmacy_order;
create table pharmacy_order(
order_id INT primary key auto_increment,
pharmacy_id INT not null,
distributor_id INT not null,
order_date DATE
);

drop table pharmacy_order_item;
create table pharmacy_order_item(
order_item_id INT primary key auto_increment,
order_id INT not null,
item_id INT not null,
quantity INT not null
);

drop table company;
create table company(
company_id INT primary key auto_increment,
company_name VARCHAR(100) not null,
company_type VARCHAR(20) not null,
registered_date Date
);

create table master_drug_table(
drug_id INT primary key auto_increment,
drug_name VARCHAR(100) not null
);

drop table manufacturer_inventory;
create table manufacturer_inventory(
manufacturer_id INT,
drug_id INT,
quantity BIGINT not null,
cost_price BIGINT,
selling_price BIGINT,
primary key(manufacturer_id, drug_id),
foreign key (drug_id) references master_drug_table(drug_id),
foreign key (manufacturer_id) references company(company_id)
);

