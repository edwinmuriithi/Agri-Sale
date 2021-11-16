CREATE DATABASE agri_sale;
\c agri_sale

CREATE TABLE products (
id SERIAL PRIMARY KEY,
name VARCHAR,
category VARCHAR,
price int
);

CREATE TABLE checkout (
id SERIAL PRIMARY KEY,
product_id INT
);

CREATE TABLE feedback (
id SERIAL PRIMARY KEY,
name VARCHAR,
email VARCHAR,
message VARCHAR
);

CREATE DATABASE agri_sale_test WITH TEMPLATE agri_sale;