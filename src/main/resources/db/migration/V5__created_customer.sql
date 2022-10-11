CREATE TABLE customers (
id int8 PRIMARY KEY,
name varchar(250),
birthDate varchar(250),
email varchar(250),
driverLicense varchar(250),
address varchar(250),
phoneNumber varchar(250),
created_at timestamp not null,
update_at timestamp not null
);