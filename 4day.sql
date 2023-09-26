-- 소수점 절삭
SELECT TRUNC(3.1234), TRUNC(3.1234, 1), TRUNC(3.1234, 2)
FROM DUAL;


-- 제곱
SELECT POWER(2, 3), POWER(2, 4)
FROM DUAL;


SELECT SQRT(2), SQRT(9)
FROM DUAL;

-- 나머지 연산
SELECT MOD(4, 2), MOD(3, 2), MOD(3.346435, 2.134)
FROM DUAL;

-- employees에서 salary가 3의 배수이면 "3의 배수로", 아니면 "해당없음"으로 출력
-- CASE, MOD
SELECT salary, 
        CASE 
            WHEN MOD(salary, 3) = 0 THEN '3의 배수'
            ELSE '해당없음'
        END AS "3연봉"    
FROM employees;


-- employees에서 salary가 7, 3의 배수이면 "3의 배수로", 아니면 "해당없음"으로 출력

SELECT employee_id, salary,
        CASE 
            WHEN MOD(salary, 3*7) = 0 THEN '21의 배수'
            WHEN MOD(salary, 7) = 0 THEN '7의 배수'
            WHEN MOD(salary, 3) = 0 THEN '3의 배수'            
            ELSE '해당없음'
        END AS "37연봉"    
FROM employees
ORDER BY salary ASC;

-- 문자열 다루기

-- LOWER 소문자로, UPPER 대문자로 
SELECT LOWER('NAVER'), UPPER('NAVER')
FROM DUAL;

-- 문자열 이어 붙이기
--      concat 함수,          || 연산자 
SELECT CONCAT('abc', 'defg'), 'abc' || 'defg'
FROM DUAL;

-- 문자열 추출
SELECT SUBSTR('abcdefg', 1, 4), SUBSTR('abcdefg', 2, 2)
FROM DUAL;
       
       
--   SELECT SUBSTRB('abcdefg', 1, 4), SUBSTRB('abcdefg', 2, 2)
--FROM DUAL;  
   




SELECT LTRIM('fgg   '), RTRIM(' fgg ')
FROM DUAL;  

    
SELECT LPAD(phone_number, 30, 'L')
FROM employees;

SELECT LPAD(phone_number, 30, 'L'), RPAD(phone_number, 30, 'R')
FROM employees;


-- 대체하기 바꾸기
SELECT REPLACE('abcdefghi', 'cd', 'TTTTTT')
FROM DUAL;

-- employees에서 이름 emp_name에 'e'가 포함된 사람들 중에서
-- 그 'e'를 'TTTT'로 대체하기

SELECT REPLACE(emp_name, 'e', 'TTTT')
FROM employees;



SELECT REPLACE(emp_name, 'e', 'TTTT')
FROM employees;
--WHERE emp_name LIKE '%e%';


-- employees에서 phone_number 앞자리 3개를 042로 대체하여 출력
-- UPDATE x


SELECT SUBSTR(phone_number, 1, 3), REPLACE(phone_number, SUBSTR(phone_number, 1, 3), '042') AS "대전"
FROM employees;

-- 문자열 길이 구하기
SELECT LENGTH('12345')
FROM DUAL;

-- employees에서 emp_name이 5개 이상인 사람들 조회
-- 출력형식 | employee_id | emp_name |

SELECT employee_id, emp_name, LENGTH(emp_name) as "이름길이"
FROM employees
WHERE LENGTH(emp_name) >= 15;

--LIKE 사용시 수정 불편 
SELECT employee_id, emp_name, LENGTH(emp_name) as "이름길이"
FROM employees
WHERE emp_name LIKE '_______________%';

-- employees에서 emp_name이 15개 이상인 사람들의 이름을
-- 'TEST'로 대체하여 출력 


SELECT employee_id, REPLACE(emp_name, emp_name, 'TEST'), LENGTH(emp_name) as "이름길이"
FROM employees
WHERE LENGTH(emp_name) >= 15;


----날짜 다루기
SELECT SYSDATE, SYSTIMESTAMP
FROM DUAL;

-- 날짜 차이 계산

SELECT ROUND(TO_DATE('2024-3-27') - SYSDATE)
FROM DUAL;


-- employees에서 hire_date가 7000일 넘은 사람들 조회 


SELECT employee_id, emp_name, hire_date, ROUND(SYSDATE - TO_DATE(hire_date)) as "7000이상"
FROM employees
WHERE ROUND(SYSDATE - hire_date) >= 7000;

--job_history에서 start_date와 end_date 차이가 1000이상인거 조회

SELECT start_date, end_date, ROUND(TO_DATE(end_date) - TO_DATE(start_date)) AS "차이"
FROM job_history
WHERE ROUND(TO_DATE(end_date) - TO_DATE(start_date)) >= 1000
ORDER BY "차이" ASC;


-- 개월수 구하기
SELECT MONTHS_BETWEEN('2024-03-30', SYSDATE)
FROM DUAL;

-- employees에서 hire_date가 300개월이 넘는 사람들 조회 

SELECT employee_id, emp_name, hire_date, ROUND(MONTHS_BETWEEN(SYSDATE, TO_DATE(hire_date))) as "300이상"
FROM employees
WHERE MONTHS_BETWEEN(SYSDATE, TO_DATE(hire_date)) >= 300
ORDER BY "300이상" ASC;

--job_history에서 start_date와 end_date 차이가 3개월 이상 조회 

SELECT start_date, end_date, ROUND(MONTHS_BETWEEN(TO_DATE(end_date), TO_DATE(start_date))) AS "50이상"
FROM job_history
WHERE MONTHS_BETWEEN(TO_DATE(end_date), TO_DATE(start_date)) >= 50
ORDER BY "50이상" ASC;


-- 앞으로의
SELECT ADD_MONTHS(SYSDATE, 1) AS "1개월 뒤", 
ADD_MONTHS(SYSDATE, -1) AS "1개월 전"
FROM DUAL;

-- 수료일로부터 2개월 전의 날짜 ('2024-03-30')
SELECT ADD_MONTHS(TO_DATE('2024-03-30'), -2) as "2전"
FROM DUAL;

-- 날짜 형식 변환
SELECT TO_CHAR(hire_date, 'YYYY-MM-DD')
FROM employees;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:mm:ss')
FROM DUAL;

-- employees에서 hire_date 를 
-- 23-9-2 형식으로 출력 
-- 09-02-2023 형식으로 출력 

SELECT TO_CHAR(hire_date, 'YY-MM-DD')
FROM employees;

SELECT TO_CHAR(hire_date, 'MM-DD-YYYY')
FROM employees;

SELECT TO_NUMBER('10')
FROM DUAL;

-- employees에서 manager_id가 NULL인 것 중에서
-- manager_id를 employee_id로 대체하여 출력

SELECT manager_id, NVL(manager_id, employee_id)
FROM employees
WHERE manager_id IS NOT NULL;

SELECT GREATEST(1, 2, 3), LEAST(1, 2, 3)
FROM DUAL;





