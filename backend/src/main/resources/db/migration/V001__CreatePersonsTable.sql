DROP SEQUENCE IF EXISTS persons_id_seq;

CREATE TABLE persons (
    id INT NOT NULL PRIMARY KEY,
    first_name STRING,
    last_name STRING,
    band_role STRING NOT NULL,
    band STRING,
    image_name STRING,
    image_thumb_name STRING,
    uid UUID DEFAULT gen_random_uuid()
);

CREATE SEQUENCE persons_id_seq
    START 100
    INCREMENT 1
    OWNED BY persons.id;
