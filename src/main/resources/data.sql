INSERT INTO author(id, name) values (UUID_TO_BIN(UUID()), 'Janusz'),
(UUID_TO_BIN(UUID()), 'Kazimierz'),
(UUID_TO_BIN(UUID()), 'Aleksandra');
INSERT INTO users(id, email,password,username)
    value (UUID_TO_BIN(UUID()),'M@M','MMM', 'Janusz');