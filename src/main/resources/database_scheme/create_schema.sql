
CREATE TABLE client_key (clientKeyId SERIAL PRIMARY KEY, login VARCHAR(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, password VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL) ENGINE = InnoDB;

CREATE TABLE client_personal_data (client_pd_id SERIAL PRIMARY KEY, first_name  VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, last_name  VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             pesel VARCHAR(11) NOT NULL, id_card VARCHAR(9) NOT NULL, country VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             voivodeship VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, city VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, street VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                             building_number VARCHAR(10) NOT NULL, flat_number VARCHAR(10), clientKeyId  BIGINT UNSIGNED NOT NULL,  FOREIGN KEY (clientKeyId) REFERENCES client_key(clientKeyId)) ENGINE = InnoDB;

CREATE TABLE client_contact_details (client_cd_id SERIAL PRIMARY KEY, country_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, voivodeship_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                               city_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, street_cd VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, building_number_cd VARCHAR(10) NOT NULL,
                                               flat_number_cd VARCHAR(30), clientKeyId  BIGINT UNSIGNED NOT NULL, FOREIGN KEY (clientKeyId) REFERENCES client_key(clientKeyId)) ENGINE = InnoDB;

CREATE TABLE client_account_balance (client_ab_id SERIAL PRIMARY KEY, account_balance  DECIMAL(13,2) NOT NULL, account_number VARCHAR(30) NOT NULL, clientKeyId BIGINT UNSIGNED NOT NULL, FOREIGN KEY (clientKeyId) REFERENCES client_key(clientKeyId)) ENGINE = InnoDB;

CREATE TABLE client_transactions_history (transaction_id SERIAL PRIMARY KEY, amount DECIMAL(9,2) NOT NULL, client_account_number VARCHAR(30) NOT NULL, second_party_account_number VARCHAR(30), transaction_type VARCHAR(200) NOT NULL, transaction_date DATE NOT NULL, transaction_time TIME NOT NULL, clientKeyId  BIGINT UNSIGNED NOT NULL,
                                          secondPartyKeyId  BIGINT UNSIGNED, second_Party_First_Name VARCHAR(50), second_Party_Last_Name VARCHAR(100), FOREIGN KEY (clientKeyId) REFERENCES client_key(clientKeyId), FOREIGN KEY (secondPartyKeyId) REFERENCES client_key(clientKeyId)) ENGINE = InnoDB;

CREATE TABLE employees_key (employee_key_id SERIAL PRIMARY KEY, login VARCHAR(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, password VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL) ENGINE = InnoDB;

CREATE TABLE employees_data (employee_data_id SERIAL PRIMARY KEY, first_name VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, last_name VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                                       employee_position VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, employee_key_id BIGINT UNSIGNED NOT NULL, FOREIGN KEY (employee_key_id) REFERENCES employees_key(employee_key_id)) ENGINE = InnoDB;

