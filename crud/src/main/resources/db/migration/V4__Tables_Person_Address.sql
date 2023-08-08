DROP TABLE person;
DROP TABLE adress;

CREATE TABLE IF NOT EXISTS address(
  id SERIAL PRIMARY KEY,
  street varchar(50) NOT NULL,
  number varchar(14) NOT NULL,
  created_at timestamp(6) NOT NULL,
  updated_at timestamp(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS person(
  id SERIAL PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  cpf VARCHAR(80) NOT NULL,
  address_id BIGINT UNIQUE,
  created_at timestamp(6) NOT NULL,
  updated_at timestamp(6) NOT NULL,
  FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE SET NULL
);
