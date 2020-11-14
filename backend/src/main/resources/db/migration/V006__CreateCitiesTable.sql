DROP SEQUENCE IF EXISTS cities_id_seq;

CREATE TABLE cities (
    id INT NOT NULL PRIMARY KEY,
    name STRING NOT NULL,
    state STRING NOT NULL
);

CREATE SEQUENCE cities_id_seq
    START 100
    INCREMENT 1
    OWNED BY cities.id;
