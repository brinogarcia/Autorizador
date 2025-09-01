CREATE DATABASE IF NOT EXISTS authorizer;
USE authorizer;
CREATE TABLE Account(  
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    created_at VARCHAR(255),
    owner VARCHAR(255),
    status VARCHAR(100),
    amount DECIMAL(10, 2)
) COMMENT '';

CREATE TABLE Transaction(  
    id int NOT NULL PRIMARY KEY,
    uuid VARCHAR(255),
    type VARCHAR(255),
    value DECIMAL(10, 2),
    currency VARCHAR(100),
    status VARCHAR(255),
    transaction_id VARCHAR(255)
) COMMENT '';