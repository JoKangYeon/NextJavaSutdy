SELECT e.employee_id, e.emp_name, e.department_id
FROM employees e;

SELECT *
FROM departments d;

SELECT e.employee_id, e.emp_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND d.department_id = 80;


DROP TABLE EX2_9;
commit;

CREATE TABLE ex2_9
(
    user_name varchar2(10),
    gender varchar2(10),
    CONSTRAINT check1 CHECK ( gender IN ('MALE', 'FEMALE')),

    grade varchar2(10),
    CONSTRAINT check2 CHECK ( grade IN ('DIA', 'GOLD', 'PLAT'))
);

INSERT INTO ex2_9(user_name, gender, grade)
VALUES('jimin', 'MALE', 'GOLD');



INSERT INTO ex2_9(user_name, gender)
VALUES('jimin', 'rs');

DROP TABLE ex2_9
commit;

CREATE TABLE ex2_10(
    col_number number(10),
    user_name varchar2(10),
    create_date date DEFAULT SYSDATE
);

INSERT INTO ex2_10(col_number, user_name, create_date)
VALUES(1, 'jimin', '2023-09-19');

INSERT INTO ex2_10(col_number, user_name)
VALUES(1, 'jimin');


ALTER TABLE ex2_10 RENAME COLUMN col_number TO autoPK;

INSERT INTO ex2_10(user_name)
VALUES('jiminasdsadaxacasd');

ALTER TABLE ex2_10 MODIFY user_name varchar2(10);




CREATE OR REPLACE VIEW emp_dept_v1 AS
SELECT e.employee_id, e.emp_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND d.department_id = 80;


SELECT *
FROM emp_dept_v1;

CREATE UNIQUE INDEX ex2_10_ix01
ON ex2_10 (autoPK);

SELECT *
FROM ex2_10;


CREATE SEQUENCE my_sq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
NOCYCLE;

DELETE
FROM ex2_10;


INSERT INTO ex2_10(autoPK, user_name)
VALUES(MY_SQ.nextval, 'jimin');

-- ex2_10에서 autoPK가 3이상인 것들만 출력

SELECT *
FROM ex2_10
WHERE autoPK >= 3;

-- ex2_10에서 autoPK가 1인것만 출력 

SELECT *
FROM ex2_10
WHERE autoPK = 1;

-- ex2_10에서 autoPK가 1이상 10이하 출력 

SELECT *
FROM ex2_10
WHERE autoPK >= 1
AND autoPK <= 10;

CREATE TABLE ORDERS
(
    ORDER_ID NUMBER(12) PRIMARY KEY,
    ORDER_DATE DATE,
    ORDER_MODE VARCHAR2(8),
    CUSTOMER_ID NUMBER(6,0),
    ORDER_STATUS NUMBER(2,0),
    ORDER_TOTAL NUMBER(8,2) DEFAULT 0,
    SALES_REP_ID NUMBER(6,0),
    PROMOTION_ID NUMBER(6,0)
);

CREATE TABLE ORDER_ITEMS
(
    ORDER_ID NUMBER(12) PRIMARY KEY,
    LINE_ITEM_ID NUMBER(3),
    PRODUCT_ID NUMBER(3),
    UNIT_PRICE NUMBER(8,2) DEFAULT 0,
    QUANTITY NUMBER(8) DEFAULT 0
);

CREATE TABLE PROMOTIONS
(
    PROMO_ID NUMBER(6) PRIMARY KEY,
    PROMO_NAME VARCHAR2(20)
);


SELECT manager_id, employee_id, emp_name, salary
FROM EMPLOYEES
WHERE manager_id = 124
AND salary >= 2000 
AND salary <= 3000;


SELECT manager_id, emp_name, commission_pct
FROM EMPLOYEES
WHERE commission_pct IS NULL;

--BETWEEN 연산자

SELECT manager_id, employee_id, emp_name, salary
FROM employees
WHERE manager_id = 149
AND salary BETWEEN 3000 AND 50000;


SELECT manager_id, employee_id, emp_name, salary
FROM employees
WHERE manager_id = 149
AND commission_pct IS NULL
AND salary BETWEEN 3000 AND 50000;







