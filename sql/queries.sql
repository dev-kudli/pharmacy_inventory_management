# MANUFACTURER

# View All Orders of a Manufacturer
SELECT po.order_id, po.pharmacy_id, c.company_name AS pharmacy_name, po.order_date, po.order_status, COUNT(poi.item_id) AS total_items
FROM pharmacy_order po
JOIN company c ON c.company_id=po.pharmacy_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
WHERE po.manufacturer_id=1
GROUP BY po.order_id, po.order_date, po.order_status;

# View Manufacturer Stock
SELECT mi.drug_id, mi.quantity, md.drug_name
FROM manufacturer_inventory mi
JOIN master_drug_table md ON md.drug_id=mi.drug_id
WHERE manufacturer_id=1;

# Fetch Order Items for Manufacturer
SELECT poi.item_id, md.drug_name, poi.quantity
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.order_id=1;

# PHARMACY
# View Manufacturer Inventory
SELECT m.manufacturer_id, c.company_name AS manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
FROM manufacturer_inventory m
JOIN master_drug_table d ON m.drug_id = d.drug_id
JOIN company c ON m.manufacturer_id = c.company_id;

# View All Orders of a Pharmacy
SELECT po.order_id, po.order_date, po.manufacturer_id, c.company_name AS manufacturer_name, po.order_status, COUNT(poi.item_id) AS total_items, SUM(poi.cost_price*poi.quantity) AS total_price
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.pharmacy_id=1
GROUP BY po.order_id, po.order_date, po.order_status;

# View Pharmacy Inventory
SELECT p.inventory_id, p.drug_id, m.drug_name, p.quantity, p.cost_price, p.selling_price
FROM pharmacy_inventory p
JOIN master_drug_table m ON m.drug_id = p.drug_id
JOIN company c ON p.pharmacy_id = c.company_id
WHERE pharmacy_id=1;

# Fetch Order Items for Pharmacy
SELECT poi.item_id, md.drug_name, poi.quantity, poi.cost_price
FROM pharmacy_order po
JOIN company c ON c.company_id=po.manufacturer_id
JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
JOIN master_drug_table md ON md.drug_id=poi.item_id
WHERE po.order_id=1;

# View Pharmacy Stores
SELECT store_id, store_name, store_address, store_zip, store_city
FROM pharmacy_store
WHERE pharmacy_id=1;

# Delete Store
DELETE FROM pharmacy_store WHERE store_id=1;

# DISTRIBUTOR
# View All Shipments Of Distributor
SELECT s.shipment_id, p.order_id, p.order_status, s.distributor_id, c1.company_name AS distributor_name, s.transporter_id, c2.company_name AS transporter_name, p.order_date
FROM shipment s
JOIN pharmacy_order p ON p.order_id=s.order_id
JOIN company c1 ON s.distributor_id=c1.company_id
JOIN company c2 ON s.transporter_id=c2.company_id
WHERE c1.company_id=1;

# Assign Transporter
UPDATE shipment
SET transporter_id=1
WHERE shipment_id=1;

#8.View Transporter Vehicles
SELECT tv.transporter_id, c.company_name AS transporter_name, tv.vehicle_count
FROM transport_vehicle tv
JOIN company c ON tv.transporter_id=c.company_id;

UPDATE company SET company_owner=test WHERE company_id=1;