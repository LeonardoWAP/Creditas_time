CREATE TABLE purchase(
	id SERIAL PRIMARY KEY,
	customer_id Int NOT NULL,
	nfe varchar (255),
	price DECIMAL(12,2) NOT NULL,
	created_at date NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE purchase_book(
    purchase_id Int NOT NULL,
    book_id Int NOT NULL,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    PRIMARY KEY (purchase_id,book_id)
);