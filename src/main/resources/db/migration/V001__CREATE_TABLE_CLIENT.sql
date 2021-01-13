CREATE TABLE IF NOT EXISTS client (
	id bigserial NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(100) NOT NULL,
	CONSTRAINT pk_client PRIMARY KEY (id)
);