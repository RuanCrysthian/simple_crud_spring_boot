CREATE TABLE IF NOT EXISTS person (
  id SERIAL PRIMARY KEY,
  name varchar(100) NOT NULL,
  cpf varchar(14) NOT NULL,
  created_at timestamp(6) NOT NULL,
  updated_at timestamp(6) NOT NULL
);
