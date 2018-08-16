-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('BETH', 'beth', 'LIBRARIAN', 'AA123456', 'abcde');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('MASON', 'mason', 'MEMBER', 'BB123456', 'xyz');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('OPRAH', 'oprah', 'MEMBER', 'CC123456', 'harpo');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('ERIK', 'erik', 'LIBRARIAN', 'DD123456', 'erik');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('STEVE', 'steve', 'MEMBER', 'EE123456', 'steve');
INSERT INTO app_user (user_name, password, role, salt) VALUES ('BELLA', 'bella', 'LIBRARIAN', 'bella');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('KYLE', 'kyle', 'MEMBER', 'FF123456', 'kyle');
INSERT INTO app_user (user_name, password, role, drivers_license, salt) VALUES ('ANDREW', 'andrew', 'MEMBER', 'GG123456', 'andrew');

INSERT INTO tool_type (tool_name, tool_description) VALUES ('HAMMER', '16 oz Fiber Glass Claw Hammer Heavy Duty Construction Shock Resistant Rubberized Non Slip Handle');
INSERT INTO tool_type (tool_name, tool_description) VALUES ('SAW', 'Stanley 20-045 15-Inch Fat Max Hand Saw');
INSERT INTO tool_type (tool_name, tool_description) VALUES ('DRILL', 'BLACK+DECKER LDX120C 20V MAX Lithium Ion Drill/Driver');

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
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);
INSERT INTO tool (tool_type_id) VALUES (1);


INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (2, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (3, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (5, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (7, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (8, NOW() - INTERVAL '15 days', NOW() - INTERVAL '11 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (8, NOW() - INTERVAL '10 days', NOW() - INTERVAL '3 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (2, NOW() - INTERVAL '10 days', NOW() - INTERVAL '3 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (3, NOW() - INTERVAL '10 days', NOW() - INTERVAL '3 days');
INSERT INTO reservation (app_user_id, from_date, to_date) VALUES (5, NOW() - INTERVAL '10 days', NOW() - INTERVAL '3 days');

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (1, 1);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (4, 1);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (6, 1);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (2, 2);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (3, 3);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (5, 3);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (8, 4);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (9, 4);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (11, 4);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (1, 5);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (2, 5);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (3, 5);
INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (4, 5);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (5, 6);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (6, 7);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (7, 8);

INSERT INTO tool_reservation (tool_id, reservation_id) VALUES (8, 9);

COMMIT;