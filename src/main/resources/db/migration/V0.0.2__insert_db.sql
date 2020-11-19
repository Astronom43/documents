insert INTO role(id, title, code)
VALUES (1, 'ADMIN', '1'),
       (2, 'USER', '2');

insert into employee(id, login, password, first_name, middle_name, last_name)
VALUES (3, 'admin', '{noop}1111', 'afn', 'amn', 'aln'),
       (4, 'user', '{noop}1111', 'ufn', 'umn', 'uln');

INSERT INTO employee_role(id_employee, id_role)
VALUES (3, 1),
       (3, 2),
       (4, 2);

INSERT INTO type(id, name_type, kod_type)
VALUES (5,'Входящие документы','1'),
       (6,'Исходящие документы','2');