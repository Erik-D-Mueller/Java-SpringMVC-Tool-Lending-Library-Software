-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
  user_name varchar(32) NOT NULL,
  password varchar(32) NOT NULL,
  salt varchar(255) NOT NULL,
  CONSTRAINT pk_app_user_username PRIMARY KEY (user_name)
);

COMMIT;