CREATE TABLE audittrail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  account_id BIGINT NOT NULL,
  sale_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (account_id) REFERENCES account(id),
  FOREIGN KEY (sale_id) REFERENCES sale(id)
);