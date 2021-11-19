# AGRI-SALE

Agri-sale seeks to provide healthy- living enthusiasts with a means to access  farm-fresh produce  that is locally grown, near you, and have it delivered to the comfort of your home.

## Author
- [Dennis Muthiora](https://github.com/wdmuthiora)
- [Ronald Kibet](https://github.com/ronah289)
- [Christopher Khajira](https://github.com/Ckhajira)
- [Edwin Muriithi](https://github.com/edwinmuriithi)
- [Adams Echwa](https://github.com/Adams4259)


## Setup/Installation Requirements
* Fork this repo
* Clone this repo
* Open terminal
* Navigate to appropriate directory using the cd command
* type in the command git clone and paste the url of clone and then press enter
## Setup Requirements for Database

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

* 
## In order to run locally
* Go to DB.class in main/java folder and make necessary changes
* Go to DatabaseRule in test/java folder and make necessary changes

## Technologies Used
* Java
* JavaScript
* Heroku
* CSS
* HBS
* HTML, CSS, Bootstrap


### License
*This project is licensed under the terms of the MIT license.*
Copyright (c) 2021 **Ronald Kibet**

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
