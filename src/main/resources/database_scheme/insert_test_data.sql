INSERT INTO quickcash.client_key (login, password)
VALUES
('test', '123'),
('test2', '321');

INSERT INTO quickcash.client_personal_data(first_name, last_name, pesel, id_card, country, voivodeship, city, street, building_number, flat_number, client_key_id)
VALUES
('Jan', 'Nowak', '990031113123', 'APR00000', 'Poland', 'Mazowieckie', 'Warszawa', 'Ujazdowska', '22', '2', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test')),
('Adam', 'Kowalski', '90011144321', 'APR11111', 'Poland', 'Dolnośląskie', 'Wrocław', 'Sokola', '12', '3', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test2'));

INSERT INTO quickcash.client_contact_details(country_cd, voivodeship_cd, city_cd, street_cd, building_number_cd, flat_number_cd, client_key_id)
VALUES
('Poland', 'Mazowieckie', 'Warszawa', 'Ujazdowska', '22', '2', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test')),
('Poland', 'Dolnośląskie', 'Wrocław', 'Sokola', '12', '3', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test2'));

INSERT INTO quickcash.client_account_balance (account_balance, account_number, client_key_id)
VALUES
(2000, '32112', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test')),
(1000, '22222', (SELECT client_key_id FROM  quickcash.client_key WHERE login='test2'));

INSERT INTO quickcash.employees_key (login, password)
VALUES
  ('employee1', '111'),
  ('employee2', '222');

INSERT INTO quickcash.employees_data (first_name, last_name, employee_position, employee_key_id)
VALUES
('Marek', 'Nowacki', 'Key Account Manager', (SELECT employee_key_id FROM  quickcash.employees_key WHERE login='employee1')),
('Darek', 'Darkowski', 'CEO', (SELECT employee_key_id FROM  quickcash.employees_key WHERE login='employee2'));