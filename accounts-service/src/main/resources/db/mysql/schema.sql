CREATE TABLE IF NOT EXISTS account (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  version INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  schedule VARCHAR(8) NOT NULL,
  created_date TIMESTAMP,
  updated_date TIMESTAMP,
  INDEX(schedule)
) engine=InnoDB;