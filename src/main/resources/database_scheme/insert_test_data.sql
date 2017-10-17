INSERT INTO quickcash.clientkey (LOGIN, PASSWORD) VALUES('test', '123');
INSERT INTO quickcash.clientpersonaldata(FIRST_NAME, LAST_NAME, PESEL, ID_CARD, COUNTRY, VOIVODESHIP, CITY, STREET, BUILDING_NUMBER, FLAT_NUMBER, CLIENT_KEY_ID)
VALUES ('Jan', 'Nowak', '90013111111', 'APR00000', 'Poland', 'Mazowieckie', 'Warszawa', 'Ujazdowska', '22', '2', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test'));
INSERT INTO quickcash.clientcontactdetails(COUNTRY_CD, VOIVODESHIP_CD, CITY_CD, STREET_CD, BUILDING_NUMBER_CD, FLAT_NUMBER_CD, CLIENT_KEY_ID)
VALUES('Poland', 'Mazowieckie', 'Warszawa', 'Ujazdowska', '22', '2', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test'));
INSERT INTO quickcash.clientaccountbalance (ACCOUNT_BALANCE, ACCOUNT_NUMBER, CLIENT_KEY_ID) VALUES(2000, '32112', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test'));


INSERT INTO quickcash.clientkey (LOGIN, PASSWORD) VALUES('test2', '321');
INSERT INTO quickcash.clientpersonaldata(FIRST_NAME, LAST_NAME, PESEL, ID_CARD, COUNTRY, VOIVODESHIP, CITY, STREET, BUILDING_NUMBER, FLAT_NUMBER, CLIENT_KEY_ID)
VALUES ('Adam', 'Kowalski', '90011144321', 'APR11111', 'Poland', 'Dolnośląskie', 'Wrocław', 'Sokola', '12', '3', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test2'));
INSERT INTO quickcash.clientcontactdetails(COUNTRY_CD, VOIVODESHIP_CD, CITY_CD, STREET_CD, BUILDING_NUMBER_CD, FLAT_NUMBER_CD, CLIENT_KEY_ID)
VALUES('Poland', 'Dolnośląskie', 'Wrocław', 'Sokola', '12', '3', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test2'));
INSERT INTO quickcash.clientaccountbalance (ACCOUNT_BALANCE, ACCOUNT_NUMBER, CLIENT_KEY_ID) VALUES(1000, '22222', (SELECT CLIENT_KEY_ID FROM  quickcash.clientkey WHERE LOGIN='test2'));

INSERT INTO quickcash.employeeskey (LOGIN, PASSWORD) VALUES('employee1', '111');
INSERT INTO quickcash.employessdata (FIRST_NAME, LAST_NAME, EMPLOYEE_POSITION, EMPLOYEE_KEY_ID) VALUES('Marek', 'Nowacki', 'Key Account Manager', (SELECT EMPLOYEE_KEY_ID FROM  quickcash.employeeskey WHERE LOGIN='employee1'));

INSERT INTO quickcash.employeeskey (LOGIN, PASSWORD) VALUES('employee2', '222');
INSERT INTO quickcash.employessdata (FIRST_NAME, LAST_NAME, EMPLOYEE_POSITION, EMPLOYEE_KEY_ID) VALUES('Darek', 'Darkowski', 'CEO', (SELECT EMPLOYEE_KEY_ID FROM  quickcash.employeeskey WHERE LOGIN='employee2'));