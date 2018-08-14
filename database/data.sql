-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Beth', 'beth', 'librarian', 'AA123456', 'abcde');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Mason', 'mason', 'member', 'BB123456', 'xyz');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Oprah', 'oprah', 'member', 'CC123456', 'harpo');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Erik', 'erik', 'librarian', 'DD123456', 'erik');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Steve', 'steve', 'member', 'EE123456', 'steve');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Bella', 'bella', 'librarian', 'bella');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Kyle', 'kyle', 'member', 'FF123456', 'kyle');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('Andrew', 'andrew', 'member', 'GG123456', 'andrew');

INSERT INTO tool_type (tool_name, tool_description) VALUES ('HAMMER', 'This is a hammer');
INSERT INTO tool_type (tool_name, tool_description) VALUES ('SAW', 'This is a saw');
INSERT INTO tool_type (tool_name, tool_description) VALUES ('DRILL', 'This is a drill');

INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (2);
INSERT INTO tool (tool_type_id) VALUES (2);
INSERT INTO tool (tool_type_id) VALUES (3);
INSERT INTO tool (tool_type_id) VALUES (3);
INSERT INTO tool (tool_type_id) VALUES (3);
INSERT INTO tool (tool_type_id) VALUES (3);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (2);
INSERT INTO tool (tool_type_id) VALUES (1);

INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (3, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (4, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (1, 1);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (2, 1);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (3, 1);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (4, 2);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (5, 2);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (6, 2);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (7, 2);

COMMIT;