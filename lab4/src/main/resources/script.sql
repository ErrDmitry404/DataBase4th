CREATE DATABASE IF NOT EXISTS dmytro_lab3;

USE dmytro_lab3;

# ================================= DROP TABLES =================================

DROP TABLE IF EXISTS computers;
DROP TABLE IF EXISTS it_company;
DROP TABLE IF EXISTS server;
DROP TABLE IF EXISTS monitors;
DROP TABLE IF EXISTS workers;
DROP TABLE IF EXISTS ir_phones;

# ================================= CREATE NEW TABLES =================================

CREATE TABLE monitors
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    monitors_resolution VARCHAR(100) NOT NULL,
    model               VARCHAR(45)  NOT NULL
);

CREATE TABLE server
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    online_now  VARCHAR(45) NOT NULL,
    monitors_id INT
);

CREATE TABLE ir_phones
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    phone_types VARCHAR(45)  NOT NULL,
    phone_model VARCHAR(100) NOT NULL
);

CREATE TABLE workers
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    full_name    VARCHAR(45) NOT NULL,
    amount       INT         NOT NULL,
    ir_phones_id INT
);

CREATE TABLE it_company
(
    id                    INT PRIMARY KEY AUTO_INCREMENT,
    company_configuration VARCHAR(45) NOT NULL,
    type_of_devices       VARCHAR(45) NOT NULL,
    server_id             INT,
    workers_id            INT
);

CREATE TABLE computers
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    amount       INT         NOT NULL,
    manufacturer VARCHAR(45) NOT NULL,
    monitors_id  INT
);

# ================================= ADD FOREIGN KEYS =================================

ALTER TABLE server
    ADD CONSTRAINT fk_server_monitors1
        FOREIGN KEY (monitors_id)
            REFERENCES monitors (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION;

ALTER TABLE workers
    ADD CONSTRAINT fk_workers_ir_phones1
        FOREIGN KEY (ir_phones_id)
            REFERENCES ir_phones (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION;

ALTER TABLE it_company
    ADD CONSTRAINT fk_it_company_server
        FOREIGN KEY (server_id)
            REFERENCES server (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION,

    ADD CONSTRAINT fk_it_company_workers1
        FOREIGN KEY (workers_id)
            REFERENCES workers (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION;

ALTER TABLE computers
    ADD CONSTRAINT fk_computers_monitors1
        FOREIGN KEY (monitors_id)
            REFERENCES monitors (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION;

# ================================= FILL THE TABLES =================================

INSERT INTO monitors (monitors_resolution, model)
VALUES ('Test1', 'Test1'),
       ('Test2', 'Test2'),
       ('Test3', 'Test3'),
       ('Test4', 'Test4'),
       ('Test5', 'Test5'),
       ('Test6', 'Test6'),
       ('Test7', 'Test7'),
       ('Test8', 'Test8'),
       ('Test9', 'Test9'),
       ('Test10', 'Test10');

INSERT INTO server (online_now, monitors_id)
VALUES ('Test1', 1),
       ('Test2', 2),
       ('Test3', 3),
       ('Test4', 4),
       ('Test5', 5),
       ('Test6', 6),
       ('Test7', 7),
       ('Test8', 8),
       ('Test9', 9),
       ('Test10', 10);

INSERT INTO ir_phones (phone_types, phone_model)
VALUES ('Test1', 'Test1'),
       ('Test2', 'Test2'),
       ('Test3', 'Test3'),
       ('Test4', 'Test4'),
       ('Test5', 'Test5'),
       ('Test6', 'Test6'),
       ('Test7', 'Test7'),
       ('Test8', 'Test8'),
       ('Test9', 'Test9'),
       ('Test10', 'Test10');

INSERT INTO workers (full_name, amount, ir_phones_id)
VALUES ('Test1', 23, 1),
       ('Test2', 2, 2),
       ('Test3', 3, 3),
       ('Test4', 5, 4),
       ('Test5', 13, 5),
       ('Test6', 15, 6),
       ('Test7', 20, 7),
       ('Test8', 21, 8),
       ('Test9', 14, 9);

INSERT INTO it_company (company_configuration, type_of_devices, server_id, workers_id)
VALUES ('Test1', 'Test1', 1, 1),
       ('Test1', 'Test1', 2, 2),
       ('Test1', 'Test1', 3, 3),
       ('Test1', 'Test1', 4, 1),
       ('Test1', 'Test1', 1, 4),
       ('Test1', 'Test1', 2, 3),
       ('Test1', 'Test1', 4, 5),
       ('Test1', 'Test1', 7, 6),
       ('Test1', 'Test1', 8, 7);

INSERT INTO computers (amount, manufacturer, monitors_id)
VALUES (4, 'Test1', 1),
       (4, 'Test1', 2),
       (4, 'Test1', 3),
       (4, 'Test1', 4),
       (4, 'Test1', 5),
       (4, 'Test1', 6),
       (4, 'Test1', 7),
       (4, 'Test1', 8),
       (4, 'Test1', 9);


# ================================= CREATE INDEXES =================================

CREATE INDEX workers ON workers (full_name);

CREATE INDEX ir_phones ON ir_phones (phone_model);
