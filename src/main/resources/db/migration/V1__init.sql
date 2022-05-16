CREATE TABLE IF NOT EXISTS producto (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  stock INT,
  PRIMARY KEY (id)
  );
CREATE TABLE IF NOT EXISTS cliente (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  apellido VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );
CREATE TABLE IF NOT EXISTS proveedor (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  ciudad VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );