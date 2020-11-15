DROP SEQUENCE IF EXISTS questions_id_seq;

CREATE TABLE questions (
    id INT NOT NULL PRIMARY KEY,
    question STRING NOT NULL,
    answer_string STRING NOT NULL,
    correct_answer_index INT NOT NULL,
    image_name STRING,
    uid UUID DEFAULT gen_random_uuid()
);

CREATE SEQUENCE questions_id_seq
    START 100
    INCREMENT 1
    OWNED BY questions.id;
