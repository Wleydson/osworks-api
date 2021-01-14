CREATE TABLE IF NOT EXISTS order_service (
	id bigserial NOT NULL,
	client_id bigserial NOT NULL,
	description varchar(255) NOT NULL,
	value numeric(10,2) NOT NULL,
	status varchar(20) NOT NULL,
	date_Initial timestamp NOT NULL,
	date_end timestamp,
	CONSTRAINT pk_order_service PRIMARY KEY (id),
	CONSTRAINT fk_order_service_client_id FOREIGN KEY (client_id) REFERENCES client (id)
);