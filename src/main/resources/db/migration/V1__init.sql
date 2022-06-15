CREATE TABLE IF NOT EXISTS categoria(
  id SERIAL,
  descripcion VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );
CREATE TABLE IF NOT EXISTS proveedor(
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  ciudad VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );
CREATE TABLE IF NOT EXISTS producto(
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  stock INT,
  PRIMARY KEY (id),
  proveedor_id INT NOT NULL,
  categoria_id INT NOT NULL,
  FOREIGN KEY (proveedor_id) REFERENCES proveedor (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria (id)
  );
