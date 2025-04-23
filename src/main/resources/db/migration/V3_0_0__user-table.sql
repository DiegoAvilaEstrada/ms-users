CREATE TABLE IF NOT EXISTS `user`(
    id INT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(75) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    role_id INTEGER NOT NULL,
    approved TINYINT(1) NOT NULL,
    ts_insert DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);