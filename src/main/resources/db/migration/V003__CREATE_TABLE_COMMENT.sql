CREATE TABLE IF NOT EXISTS comment (
	id bigserial NOT NULL,
	order_service_id bigserial NOT NULL,
	title varchar(255) NOT NULL,
	description text NOT NULL,
	date timestamp NOT NULL,
	CONSTRAINT pk_comment PRIMARY KEY (id),
	CONSTRAINT fk_comment_order_service_id FOREIGN KEY (order_service_id) REFERENCES order_service (id)
);