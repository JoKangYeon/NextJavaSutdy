
-- 연봉 높은게 먼저 
SELECT *
FROM employees e
WHERE e.salary BETWEEN 2000 AND 5000
ORDER BY e.employee_id DESC;


-- -- 연봉 낮은게 먼저

SELECT *
FROM employees e
WHERE e.salary BETWEEN 2000 AND 5000
ORDER BY e.salary ASC;

-- 실습용 테이블 
CREATE TABLE ex3_2(
    emp_id number,
    emp_name varchar2(100)
);

INSERT INTO ex3_2 (emp_id, emp_name)
SELECT employee_id, emp_name
FROM employees
WHERE salary > 4000;

DROP TABLE ex3_2;

-- 방금 만든 테이블 ex3_2 에서 salary가 4000과 5000사이에
-- 있는 사원들 조회 

CREATE TABLE ex3_2(
    emp_id number,
    emp_name varchar2(100),
    salary number
);

INSERT INTO ex3_2 (emp_id, emp_name, salary)
SELECT employee_id, emp_name, salary
FROM employees
WHERE salary BETWEEN 4000 AND 5000;

SELECT employee_id, emp_name, salary
FROM employees
WHERE salary BETWEEN 4000 AND 5000;

UPDATE ex3_2
SET salary = salary + 500
WHERE emp_id = 107;

UPDATE ex3_2
SET emp_name = 'jimin',
salary = salary - 500
WHERE emp_id = 107;

UPDATE ex3_2 
SET emp_name = 'test'
WHERE salary BETWEEN 4000 AND 4200;

---ex3_2 emp_id 100에서 110에 있는 사람들
-- 연봉을 500씩  인상 

UPDATE ex3_2 
SET salary = salary + 500
WHERE emp_id BETWEEN 100 AND 110;


---ex3_2 emp_name가 test인 사람들 서중에 
-- 연봉이 4000 이상인 사람들 조회

SELECT *
FROM ex3_2
WHERE emp_name = 'test'
AND salary >= 4000;

--MERGE 
--INSERT를 할 때 이미 있으면 UPDATE
--없으면 그대로 INSERT

--먼저 예제용 테이블 생성
CREATE TABLE ex3_3 (
employee_id number,
bonus_amt number DEFAULT 0
);

--그 예제용에다 데이터 넣기
INSERT INTO ex3_3 (employee_id)
SELECT e.employee_id 
  FROM employees e, sales s
 WHERE e.employee_id = s.employee_id
   AND s.SALES_MONTH BETWEEN '200010' AND '200012'
 GROUP BY e.employee_id;

SELECT *
FROM ex3_3;

SELECT employee_id, manager_id, salary, salary * 0.01
FROM employees
WHERE employee_id IN (
    SELECT employee_id
    FROM ex3_3
);

 SELECT employee_id, manager_id, salary, salary * 0.001
   FROM employees 
  WHERE employee_id NOT IN (  SELECT employee_id
                                FROM ex3_3 )
    AND manager_id = 146; 
    
MERGE INTO ex3_3 d
     USING (SELECT employee_id, salary, manager_id
              FROM employees
             WHERE manager_id = 146) b
        ON (d.employee_id = b.employee_id) --검색조건
 WHEN MATCHED THEN --이미 있으면
      UPDATE SET d.bonus_amt = d.bonus_amt + b.salary * 0.01
 WHEN NOT MATCHED THEN --없으
      INSERT (d.employee_id, d.bonus_amt) VALUES (b.employee_id, b.salary *.001)
       WHERE (b.salary < 8000);

-- 의사컬럼 -> 이미 만들어져 있는 컬럼
SELECT ROWNUM, employee_id, ROWID
FROM employees;

SELECT 1 + 1, 1 -1, 2 * 2, 4 / 2
FROM DUAL;

SELECT employee_id || '====' || emp_name
FROM employees;

-- 다음과 같은 형식을 출력하자
-- NO.사원번호 : emp_name님

SELECT ('NO.' || employee_id || ' : ' || emp_name || '님') AS "사원"
FROM employees;

-- 비교 조건식
SELECT employee_id, emp_name
FROM employees
WHERE employee_id IN (175, 121, 160);

SELECT employee_id, emp_name
FROM employees
WHERE employee_id NOT IN (175, 121, 160);

-- employees에서 manager_id 100 124 145인 사람들

SELECT manager_id, employee_id, emp_name
FROM employees
WHERE manager_id IN (100, 124, 145);

-- employees에서 manager_id 100 124 145가 아니고
-- 연봉 salary이 2000 3000 4000이 아닌 사람들

SELECT manager_id, employee_id, emp_name, salary
FROM employees
WHERE manager_id NOT IN (100, 124, 145)
AND salary NOT IN (2000, 3000, 4000)
ORDER BY salary ASC;


SELECT manager_id, employee_id, emp_name, salary
FROM employees
WHERE salary = ALL(2500);

-- 예제용 테이블 
CREATE TABLE ex3_5
(
    names VARCHAR2(50)
);

INSERT INTO ex3_5(names) VALUES('홍길동');
INSERT INTO ex3_5(names) VALUES('홍길동2');
INSERT INTO ex3_5(names) VALUES('홍길');
INSERT INTO ex3_5(names) VALUES('홍길동3');
INSERT INTO ex3_5(names) VALUES('길용');
INSERT INTO ex3_5(names) VALUES('길용용');
INSERT INTO ex3_5(names) VALUES('길용길길');
INSERT INTO ex3_5(names) VALUES('길용길갈');
INSERT INTO ex3_5(names) VALUES('길홍길트라');
INSERT INTO ex3_5(names) VALUES('길홍길트라이');
-- %가 앞에 있으면 글자를 포함, 뒤에있으면 글자로 시작, _뒤에있으면 한글자포함 

SELECT *
FROM ex3_5
WHERE names LIKE '%길_';

COMMIT;
ROLLBACK;

-- 앞에 뭐가 있건 '동'으로만 끝나는 사람 조회 

SELECT *
FROM ex3_5
WHERE names LIKE '%동';

-- 반드시 3글자이며 '길'을 포함하는 사람들 조회

SELECT *
FROM ex3_5
WHERE names LIKE '%길__'
OR names LIKE '%_길_'
OR names LIKE '%__길';

AND 

-- 반드시 3글자이며 양끝에 각각 '홍', '동'

SELECT *
FROM ex3_5
WHERE names LIKE '홍_동';

-- 반드시 4글자이면서 뒤에 아무거나 와도 무방 
-- | 홍 | 길 |   |   | ~~~~~~~
SELECT *
FROM ex3_5
WHERE names LIKE '홍길__%';

-- CASE 

SELECT employee_id, salary,
    CASE 
        WHEN salary <= 5000 THEN 'C등급'
        WHEN salary > 5000 AND salary <= 15000 THEN 'B등급'
        ELSE 'A등급'
    END AS salary_grade
FROM employees급;

-- 3000미만 - D등급
-- 5000미만 - C등급
-- 8000미만 - B등급
-- 12000미만 - A등급
-- 그 외 이상 - S등
    
SELECT employee_id, salary,
    CASE 
        WHEN salary < 3000 THEN 'D등급'
        WHEN salary >= 3000 AND salary < 5000 THEN 'C등급'
        WHEN salary >= 5000 AND salary < 8000 THEN 'B등급'
        WHEN salary >= 8000 AND salary < 12000 THEN 'A등급'
        ELSE 'S등급'
    END AS salary_grade
FROM employees
ORDER BY salary DESC;

--함수 실습

--절댓값 구하기

SELECT (ABS(-10)) AS "절댓값-10", (ABS(10)) AS "절댓값10"
FROM DUAL;

--"절댓값-10" , "절댓값10"

SELECT ABS(-10) AS "절댓값-10", ABS(10) AS "절댓값10"
FROM DUAL;

SELECT CEIL(10.1), FLOOR(10.7), CEIL(10.8)
FROM DUAL;

-- ROUND(원본데이터, 원하는 반올림구간)
SELECT ROUND(10.123123, 5) AS "R1", ROUND(10.7)  AS "R2"
FROM DUAL;

-- employees에서 연봉을 10% 인상시킬 결과를 반올림

SELECT salary AS "연봉", ROUND(salary * 1.1, 3) AS "인상분"
FROM employees;


