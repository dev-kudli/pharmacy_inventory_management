#1.View Manufacturer Inventory
SELECT m.manufacturer_id, c.company_name AS manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
FROM manufacturer_inventory m
JOIN master_drug_table d ON m.drug_id = d.drug_id
JOIN company c ON m.manufacturer_id = c.company_id;

#2.View All Orders of a Manufacturer
SELECT po.order_id, po.pharmacy_id, c.company_name AS pharmacy_name, po.order_date, po.order_status
FROM pharmacy_order po
JOIN company c ON c.company_id=po.pharmacy_id
WHERE po.manufacturer_id=1;

#3.View All Orders of a Pharmacy
SELECT poi.item_id, md.drug_name, poi.quantity,  po.order_id, po.manufacturer_id, c.company_name AS manufacturer_name, po.order_date, po.order_status
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.pharmacy_id=1;

#4.View Pharmacy Inventory
SELECT p.pharmacy_id, c.company_name, p.drug_id, p.quantity, p.cost_price, p.selling_price
FROM pharmacy_inventory p
JOIN master_drug_table m ON m.drug_id = p.drug_id
JOIN company c ON p.pharmacy_id = c.company_id
WHERE pharmacy_id=1;

#5.Fetch an Order
SELECT poi.item_id, md.drug_name, poi.quantity,  po.order_id, po.manufacturer_id, c.company_name as manufacturer_name, po.order_date, po.order_status
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.order_id=1;

#5.View Manufacturer Stock
SELECT mi.drug_id, mi.quantity, md.drug_name
FROM manufacturer_inventory mi
JOIN master_drug_table md ON md.drug_id=mi.drug_id
WHERE manufacturer_id=1;
