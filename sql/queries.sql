#1.View Manufacturer Inventory
select m.manufacturer_id, c.company_name as manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
from manufacturer_inventory m
join master_drug_table d on m.drug_id = d.drug_id
join company c on m.manufacturer_id = c.company_id;

#2.View All Orders of a Manufacturer
SELECT po.order_id, po.pharmacy_id, c.company_name as pharmacy_name, po.order_date, po.order_status
FROM pharmacy_order po
join company c on c.company_id=po.pharmacy_id
WHERE po.manufacturer_id=1;

#3.View All Orders of a Pharmacy
SELECT poi.item_id, md.drug_name, poi.quantity,  po.order_id, po.manufacturer_id, c.company_name as manufacturer_name, po.order_date, po.order_status
FROM pharmacy_order po
join company c on c.company_id=po.manufacturer_id
join pharmacy_order_item poi on poi.order_id = po.order_id
join master_drug_table md on md.drug_id=poi.item_id
WHERE po.pharmacy_id=1;

#4.View Pharmacy Inventory
select p.pharmacy_id, c.company_name, p.drug_id, p.quantity, p.cost_price, p.selling_price
from pharmacy_inventory p
join master_drug_table m on m.drug_id = p.drug_id
join company c on p.pharmacy_id = c.company_id
where pharmacy_id=1;

SELECT poi.item_id, md.drug_name, poi.quantity,  po.order_id, po.manufacturer_id, c.company_name as manufacturer_name, po.order_date, po.order_status
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.order_id=1;

select * from pharmacy_order po join pharmacy_order_item poi where po.order_id = poi.order_id;