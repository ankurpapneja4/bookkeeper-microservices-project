CREATE TABLE IF NOT EXISTS account (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    schedule VARCHAR(8) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX(schedule)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS journal_register (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 0,
    cr_ac_id BIGINT NOT NULL,
    dr_ac_id BIGINT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    transaction_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    transaction_type varchar(16) NOT NULL,
    reference_id BIGINT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dr_ac_id) REFERENCES account(id),
    FOREIGN KEY (cr_ac_id) REFERENCES account(id)
) engine=InnoDB;
