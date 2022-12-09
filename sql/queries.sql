#1.Fetch Inventory
select m.manufacturer_id, c.company_name as manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
from manufacturer_inventory m
join master_drug_table d on m.drug_id = d.drug_id
join company c on m.manufacturer_id = c.company_id;

#2.View All Orders of a Manufacturer
SELECT po.order_id, po.pharmacy_id, c.company_name as pharmacy_name, po.order_date, po.order_status
FROM pharmacy_order po
join company c on c.company_id=po.pharmacy_id
WHERE po.manufacturer_id=1;

32.View All Orders of a Pharmacy
SELECT po.order_id, po.manufacturer_id, c.company_name as manufacturer_name, po.order_date, po.order_status
FROM pharmacy_order po
join company c on c.company_id=po.manufacturer_id
WHERE po.pharmacy_id=1;