-- db schema
# CREATE SCHEMA test;

CREATE TABLE urls (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  long_url varchar(2048),
  short_url varchar(2048),
  customer_number int NOT NULL,
  expiration_date TIMESTAMP
)
ENGINE=InnoDB DEFAULT CHARSET=UTF8;
