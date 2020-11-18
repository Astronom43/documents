CREATE SEQUENCE m_data_sq MINVALUE 500 OWNED BY NONE;

CREATE TABLE respondent
(
    id         BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    full_name  VARCHAR(255),
    phone_cod  VARCHAR,
    phone_nom  VARCHAR,
    e_mail     VARCHAR,
    post_index VARCHAR,
    region     VARCHAR,
    district   VARCHAR,
    town       VARCHAR,
    street     VARCHAR,
    house_nome VARCHAR,
    office     VARCHAR
);

CREATE TABLE type
(
    id        BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    name_type VARCHAR NOT NULL UNIQUE,
    kod_type  VARCHAR NOT NULL UNIQUE
);

CREATE TABLE employee
(
    id          BIGINT  DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    login       VARCHAR NOT NULL,
    password    VARCHAR NOT NULL,
    is_active   BOOLEAN DEFAULT true,
    first_name  VARCHAR NOT NULL,
    middle_name VARCHAR,
    last_name   VARCHAR NOT NULL
);

CREATE TABLE role
(
    id    BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    title VARCHAR NOT NULL UNIQUE,
    code  VARCHAR NOT NULL UNIQUE
);

CREATE TABLE employee_role
(
    id_employee BIGINT REFERENCES employee (id),
    id_role     BIGINT REFERENCES role (id),
    PRIMARY KEY (id_employee, id_role)
);

CREATE TABLE decision
(
    id             BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    date_signature TIMESTAMP,
    date_control   TIMESTAMP,
    date_execution TIMESTAMP
);

CREATE TABLE instruction
(
    id           BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    instruction  VARCHAR,
    data_control TIMESTAMP,
    id_decision  BIGINT REFERENCES decision (id),
    id_employee  BIGINT REFERENCES employee (id)
);

CREATE TABLE report
(
    id             BIGINT    DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    date_signature TIMESTAMP,
    date_execution TIMESTAMP DEFAULT (localtimestamp),
    id_employee    BIGINT REFERENCES employee (id)
);

CREATE TABLE instruction_report
(
    id_instruction BIGINT REFERENCES instruction (id),
    id_report      BIGINT REFERENCES report (id),
    PRIMARY KEY (id_instruction, id_report)
);



CREATE TABLE document
(
    id              BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    nom             INT,
    nom_s           VARCHAR,
    description     VARCHAR(255),
    respondent_from BIGINT REFERENCES respondent (id),
    respondent_to   BIGINT REFERENCES respondent (id),
    subj            VARCHAR(255),
    body            text,
    id_type         BIGINT REFERENCES type (id)
);

CREATE TABLE document_decision(
    id_document BIGINT REFERENCES document(id),
    id_decision BIGINT REFERENCES decision(id),
    PRIMARY KEY (id_decision,id_document)
);
CREATE TABLE document_report(
    id_document BIGINT REFERENCES document(id),
    id_report BIGINT REFERENCES report(id),
    PRIMARY KEY (id_document,id_report)
);


CREATE TABLE file
(
    id          BIGINT DEFAULT (nextval('m_data_sq')) PRIMARY KEY,
    title       VARCHAR,
    url         VARCHAR,
    id_document BIGINT REFERENCES document (id)
);






