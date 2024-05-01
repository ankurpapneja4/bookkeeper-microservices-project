-- Purchase Service
CREATE TABLE IF NOT EXISTS purchase_invoice (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    seller_invoice_id VARCHAR(32),
    invoice_date DATE DEFAULT (CURRENT_DATE),
    account_id BIGINT NOT NULL, -- NO FOREIGN KEY REFERENCE
    bill_amount DECIMAL(10,2),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS purchase_invoice_line (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    product_id BIGINT NOT NULL, -- NO FOREIGN KEY REFERENCE
    qty DECIMAL(6,2),
    amount DECIMAL(6,2),
    invoice_id BIGINT NOT NULL,
    FOREIGN KEY(invoice_id) REFERENCES purchase_invoice(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;