CREATE TABLE client
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    age        INT NULL,
    birth_date date NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE privilege
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_privilege PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE roles_privileges
(
    privilege_id BIGINT NOT NULL,
    role_id      BIGINT NOT NULL
);

CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    username   VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    phone      VARCHAR(255) NULL,
    status     INT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

ALTER TABLE roles_privileges
    ADD CONSTRAINT fk_rolpri_on_privilege_entity FOREIGN KEY (privilege_id) REFERENCES privilege (id);

ALTER TABLE roles_privileges
    ADD CONSTRAINT fk_rolpri_on_role_entity FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role_entity FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user_entity FOREIGN KEY (user_id) REFERENCES user (id);