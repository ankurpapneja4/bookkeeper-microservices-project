CREATE TABLE IF NOT EXISTS account (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    schedule VARCHAR(8) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX(schedule)
);

CREATE TABLE IF NOT EXISTS journal_register (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    cr_ac_id BIGINT NOT NULL,
    dr_ac_id BIGINT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    transaction_date DATE NOT NULL DEFAULT CURRENT_DATE,
    transaction_type varchar(8) NOT NULL,
    reference_id BIGINT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dr_ac_id) REFERENCES account(id),
    FOREIGN KEY (cr_ac_id) REFERENCES account(id)
);

-- Inventory Service
CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    hsn_code VARCHAR(6) NOT NULL,
    sale_account_id BIGINT NOT NULL,     -- NO FOREIGN KEY REFERENCE
    purchase_account_id BIGINT NOT NULL, -- NO FOREIGN KEY REFERENCE
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS inventory (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    product_id BIGINT NOT NULL,
    total_purchase_qty DECIMAL(10,2),
    total_purchase_amt DECIMAL(10,2),
    average_price DECIMAL(6,2),
    FOREIGN KEY(product_id) REFERENCES product(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Purchase Service
CREATE TABLE IF NOT EXISTS purchase_invoice (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    seller_invoice_id VARCHAR(32),
    invoice_date DATE DEFAULT CURRENT_DATE,
    account_id BIGINT NOT NULL, -- NO FOREIGN KEY REFERENCE
    bill_amount DECIMAL(10,2),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS purchase_invoice_line (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    product_id BIGINT NOT NULL, -- NO FOREIGN KEY REFERENCE
    qty DECIMAL(6,2),
    amount DECIMAL(6,2),
    invoice_id BIGINT NOT NULL,
    FOREIGN KEY(invoice_id) REFERENCES purchase_invoice(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tax Service 
CREATE TABLE IF NOT EXISTS tax_rules (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL,
    hsn_code VARCHAR(6) NOT NULL UNIQUE,
    hsn_description VARCHAR(255),
    tax_percent SMALLINT,
    INDEX(hsn_code)
);

CREATE TABLE IF NOT EXISTS tax_register (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    invoice_id BIGINT NOT NULL,  -- NO FOREIGN KEY REFERENCE
    tax_amount DECIMAL(8,2) DEFAULT 0,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);
