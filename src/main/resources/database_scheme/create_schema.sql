
CREATE TABLE client_key (client_key_id SERIAL PRIMARY KEY, login VARCHAR(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, password VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL) ENGINE = InnoDB;

CREATE TABLE client_personal_data (client_pd_id SERIAL PRIMARY KEY, first_name  VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, last_name  VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             pesel VARCHAR(11) NOT NULL, id_card VARCHAR(9) NOT NULL, country VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             voivodeship VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, city VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, street VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             building_number VARCHAR(10) NOT NULL, flat_number VARCHAR(10) NOT NULL, client_key_id  BIGINT UNSIGNED NOT NULL,  FOREIGN KEY (client_key_id) REFERENCES client_key(client_key_id)) ENGINE = InnoDB;

CREATE TABLE client_contact_details (client_cd_id SERIAL PRIMARY KEY, country_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, voivodeship_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                               city_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, street_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, building_number_cd VARCHAR(10) NOT NULL,
                                               flat_number_cd VARCHAR(30) NOT NULL, client_key_id  BIGINT UNSIGNED NOT NULL, FOREIGN KEY (client_key_id) REFERENCES client_key(client_key_id)) ENGINE = InnoDB;

CREATE TABLE client_account_balance (client_ab_id SERIAL PRIMARY KEY, account_balance  DECIMAL(13,2) NOT NULL, account_number VARCHAR(30) NOT NULL, client_key_id BIGINT UNSIGNED NOT NULL, FOREIGN KEY (client_key_id) REFERENCES client_key(client_key_id)) ENGINE = InnoDB;

CREATE TABLE employees_key (employee_key_id SERIAL PRIMARY KEY, login VARCHAR(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, password VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL) ENGINE = InnoDB;

CREATE TABLE employees_data (employee_data_id SERIAL PRIMARY KEY, first_name VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, last_name VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                       employee_position VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, employee_key_id BIGINT UNSIGNED NOT NULL, FOREIGN KEY (employee_key_id) REFERENCES employees_key(employee_key_id)) ENGINE = InnoDB;