DROP SEQUENCE IF EXISTS reference_data_id_seq;
CREATE TABLE reference_data (
    id INT NOT NULL PRIMARY KEY,
    ref_type STRING NOT NULL,
    ref_value STRING NOT NULL
);
CREATE SEQUENCE reference_data_id_seq
    START 100
    INCREMENT 1
    OWNED BY reference_data.id;
