CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username VARCHAR (50) NOT NULL,
    password VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);
