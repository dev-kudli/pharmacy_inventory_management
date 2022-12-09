insert into master_drug_table(drug_name) values('Crocin');
insert into master_drug_table(drug_name) values('Paracetamol');
insert into master_drug_table(drug_name) values('Cetrizon');

insert into company(company_name, company_type, registered_date) values("Abbot Laboratories", "manufacturer", "1980-02-13");
insert into company(company_name, company_type, registered_date) values("Johnson and Johnson", "manufacturer", "1985-04-13");
insert into company(company_name, company_type, registered_date) values("Cardinal Health", "distributor", "1990-05-23");
insert into company(company_name, company_type, registered_date) values("King World Medicines Group", "distributor", "2000-12-25");
insert into company(company_name, company_type, registered_date) values("CVS Pharmacy", "pharmacy", "1982-06-04");
insert into company(company_name, company_type, registered_date) values("MedPlus", "pharmacy", "1970-02-16");

insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(1, 1, 10, 3, 4);
insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(2, 1, 10, 4, 4.5);

insert into pharmacy_order(pharmacy_id, manufacturer_id, order_date, order_status) values(1, 1, "2021-02-16", "pending");
insert into pharmacy_order(pharmacy_id, manufacturer_id, order_date, order_status) values(1, 2, "2021-02-16", "pending");

insert into pharmacy_order_item(order_item_id, order_id, item_id, quantity) values(1, 1, 1, 5);
insert into pharmacy_order_item(order_item_id, order_id, item_id, quantity) values(2, 1, 1, 5);
insert into pharmacy_order_item(order_item_id, order_id, item_id, quantity) values(3, 1, 1, 6);
insert into pharmacy_order_item(order_item_id, order_id, item_id, quantity) values(4, 2, 1, 1);

insert into pharmacy_inventory(pharmacy_id, drug_id, quantity, cost_price, selling_price) values(1, 1, 5, 10, 12);