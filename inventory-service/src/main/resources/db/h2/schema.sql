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