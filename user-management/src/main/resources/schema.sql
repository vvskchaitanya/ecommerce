CREATE TABLE users (
    id INT AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    user_role VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);