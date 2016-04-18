-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the toollib database
-- *************************************************************************************************

BEGIN;

CREATE TABLE tool_category (
    tool_category_id integer primary key,
    name varchar(64) not null
);

CREATE TABLE tool (
    tool_id integer primary key,
    tool_category_id integer not null references tool_category(tool_category_id),
    name varchar(64) not null,
    description text,
    loan_period_in_days integer not null
);

CREATE SEQUENCE seq_tool_id;

CREATE TABLE tool_inventory (
    tool_inventory_id integer primary key,
    tool_id integer not null references tool(tool_id)
);

CREATE SEQUENCE seq_tool_inventory_id;

COMMIT;