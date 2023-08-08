CREATE TABLE IF NOT EXISTS adress (
  id SERIAL PRIMARY KEY,
  street varchar(50) NOT NULL,
  number varchar(14) NOT NULL,
  created_at timestamp(6) NOT NULL,
  updated_at timestamp(6) NOT NULL
);