-- db schema
# CREATE SCHEMA test;

CREATE TABLE urls (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  long_url LONGTEXT,
  short_url VARCHAR(2048),
  customer_number int NOT NULL,
  expiration_date DATE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
