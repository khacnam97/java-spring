
CREATE TABLE employee (
    employee_id INT NOT NULL,
    employee_name VARCHAR (100) NOT NULL,
    employee_address VARCHAR (256) NOT NULL
);
INSERT INTO employee (employee_id, employee_name, employee_address) VALUES
  (1, 'Nguyen Van A', 'Ha Noi'),
  (2, 'Tran Van B', 'Bac Giang'),
  (3, 'Nguyen Thi C', 'Hai Duong');