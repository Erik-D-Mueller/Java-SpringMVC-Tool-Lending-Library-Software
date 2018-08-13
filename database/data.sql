-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Beth', 'beth', 'librarian', 'abcde');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Mason', 'mason', 'member', 'xyz');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Oprah', 'oprah', 'member', 'harpo');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Erik', 'erik', 'librarian', 'erik');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Steve', 'steve', 'member', 'steve');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Bella', 'bella', 'librarian', 'bella');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Kyle', 'kyle', 'member', 'kyle');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('Andrew', 'andrew', 'member', 'andrew');

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

INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (3, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days')
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (4, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days')

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (1, 2);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (2, 2);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (3, 2);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (4, 3);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (5, 3);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (6, 3);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (7, 3);

COMMIT;