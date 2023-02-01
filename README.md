https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html

CREATE TABLE users
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
enabled INT NOT NULL
);

CREATE TABLE authorities
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(45) NOT NULL,
authority VARCHAR(45) NOT NULL
);

INSERT INTO users VALUES(NULL, 'bushan', '12345', '1');
INSERT INTO authorities VALUES(NULL, 'bushan', 'write');