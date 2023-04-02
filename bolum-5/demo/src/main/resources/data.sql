INSERT INTO course (id, name, is_deleted) VALUES (10001, 'jpa in 50 steps', false);
INSERT INTO course (id, name, is_deleted) VALUES (10002, 'Spring in 50 steps', false);
INSERT INTO course (id, name, is_deleted) VALUES (10003, 'Spring boot in 50 steps', false);

INSERT INTO passport (id, number) VALUES (40001, 'E123423');
INSERT INTO passport (id, number) VALUES (40002, 'RT45645');
INSERT INTO passport (id, number) VALUES (40003, 'YUTY768');

INSERT INTO student (id, name, passport_id) VALUES (20001, 'Ranga', 40001);
INSERT INTO student (id, name, passport_id) VALUES (20002, 'Adam', 40002);
INSERT INTO student (id, name, passport_id) VALUES (20003, 'Jane', 40003);

INSERT INTO review (id, rating, description, course_id) VALUES (50001, '5', 'Great Course', 10001);
INSERT INTO review (id, rating, description, course_id) VALUES (50002, '4', 'Wonderful Course', 10001);
INSERT INTO review (id, rating, description, course_id) VALUES (50003, '5', 'Awesome Course', 10003);

INSERT INTO student_course(student_id, course_id) VALUES (20001, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20002, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20003, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20001, 10003);
