select m.manufacturer_id, c.company_name as manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
from manufacturer_inventory m
join master_drug_table d on m.drug_id = d.drug_id
join company c on m.manufacturer_id = c.company_id;