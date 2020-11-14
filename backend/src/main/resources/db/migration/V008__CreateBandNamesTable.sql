DROP SEQUENCE IF EXISTS band_name_adjectives_id_seq;
CREATE TABLE band_name_adjectives (
    id INT NOT NULL PRIMARY KEY,
    value STRING NOT NULL
);
CREATE SEQUENCE band_name_adjectives_id_seq
    START 1
    INCREMENT 1
    OWNED BY band_name_adjectives.id;

DROP SEQUENCE IF EXISTS band_name_nouns_id_seq;
CREATE TABLE band_name_nouns (
    id INT NOT NULL PRIMARY KEY,
    value STRING NOT NULL
);
CREATE SEQUENCE band_name_nouns_id_seq
    START 1
    INCREMENT 1
    OWNED BY band_name_nouns.id;
