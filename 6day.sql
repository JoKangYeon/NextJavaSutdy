SELECT emp_name, department_id
FROM employees;

-- 동등조인 가장 기본적인 형태
-- 다른 테이블끼리조인 
SELECT emp_name, e.department_id as "사원테이블", d.department_id as "부서테이블", 
d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- SALES와 PRODUCTS를 합하여
-- 판매된 제품명과 판매된 날짜 출력

SELECT d.prod_name as "판매자 이름", e.sales_date
FROM sales e, products d
WHERE e.prod_id = d.prod_id;

-- SALES와 PRODUCTS를 합하여
-- 판매된 제품명별 판매갯수

SELECT p.prod_name, s.prod_id, COUNT(p.prod_id)
FROM sales s, products p
WHERE p.prod_id = s.prod_id
GROUP BY s.prod_id, p.prod_name;


-- 셀프조인 예제(본인 상관의 이름)
-- 본인끼리 조인
SELECT e.emp_name as "본인 이름", m.emp_name as "상관의 이름"
FROM employees e, employees m
WHERE e.manager_id = m.employee_id;

-- LEFT JOIN
SELECT e.emp_name as "본인 이름", m.emp_name as "상관의 이름"
FROM employees e
LEFT JOIN employees m
ON e.manager_id = m.employee_id
WHERE m.emp_name IS NULL;

--사원명과 그 사원의 직책명 출력
-- employees, jobs 이용

SELECT j.job_title, emp_name
FROM employees e, jobs j
WHERE e.job_id = j.job_id; 

-- 직책별 사원수 

SELECT j.job_title, COUNT(j.job_id)
FROM employees e, jobs j
WHERE e.job_id = j.job_id 
GROUP BY j.job_title;

-- 고객들의 고객명, 나라명

SELECT m.cust_id, m.cust_name, t.country_name
FROM customers m, countries t
WHERE m.country_id = t.country_id;

-- 나라별 고객수

SELECT t.country_id as "국가코드", t.country_name as "국가명", COUNT(m.cust_id) as "손님수"
FROM countries t, customers m
WHERE m.country_id = t.country_id
GROUP BY t.country_name, t.country_id
ORDER BY COUNT(m.cust_id) ASC;

-- 본인이름, 본인 상관의 이름 , 또 그 상관의 이름
-- FROM employees e1, employees e2, employees e3

SELECT e.emp_name as "본인 이름", m.emp_name as "상관의 이름", p.emp_name as "그 상관의 이름"
FROM employees e, employees m, employees p
WHERE e.manager_id = m.employee_id
AND m.manager_id = p.employee_id
; --직속상관이 ceo일 경우 left on 두번사용?


-- 고객별 주문수량, 해당 전화번호 
-- 고객아이디, 고객전화번호, 수량


SELECT c.cust_name, c.cust_id as "고객명", COUNT(s.cust_id) as "수량", c.cust_main_phone_number as "고객번호"
FROM customers c, sales s
WHERE c.cust_id = s.cust_id
GROUP BY c.cust_id, c.cust_main_phone_number, c.cust_name
ORDER BY COUNT(s.cust_id) DESC
;


SELECT c.cust_name, c.cust_id as "고객명", COUNT(s.cust_id) as "수량", c.cust_main_phone_number as "고객번호", cu. country_name
FROM customers c, sales s, countries cu
WHERE c.cust_id = s.cust_id
AND c.country_id = cu.country_id
GROUP BY c.cust_id, c.cust_main_phone_number, c.cust_name, cu. country_name
ORDER BY COUNT(s.cust_id) DESC
;

-- 사원별 총 판매금액
-- 사원명, 사원부서명, 총 판매수량, 총 판매금액

SELECT e.emp_name, COUNT(s.prod_id), d.department_name, ROUND(SUM(s.amount_sold)), d.department_id, e.employee_id
FROM employees e, sales s, departments d
WHERE e.employee_id = s.employee_id
AND e.department_id = d.department_id
GROUP BY e.employee_id, d.department_id, e.emp_name, d.department_name
;










