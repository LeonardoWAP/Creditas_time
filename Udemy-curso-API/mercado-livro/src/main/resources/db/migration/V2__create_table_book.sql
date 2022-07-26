CREATE TABLE book(
	id SERIAL PRIMARY KEY,
	name varchar(255) NOT NULL,
	price decimal (10,2) not null unique,
	status varchar(255) not null,
	customer_id int not null,
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);