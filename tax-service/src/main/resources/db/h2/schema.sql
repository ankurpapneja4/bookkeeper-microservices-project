-- Tax Service
CREATE TABLE IF NOT EXISTS tax_rules (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL,
    hsn_code VARCHAR(6) NOT NULL UNIQUE,
    hsn_description VARCHAR(255),
    tax_percent SMALLINT,
    INDEX(hsn_code)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tax_register (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    invoice_id BIGINT NOT NULL,  -- NO FOREIGN KEY REFERENCE
    tax_amount DECIMAL(8,2) DEFAULT 0,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine = InnoDB;
