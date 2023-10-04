
-- where에 들어가는 서브쿼리 예제
-- 평균급여보다 많이 받는 사람들 

SELECT*
FROM employees e
WHERE e. salary >
(
SELECT AVG(b.salary)
FROM EMPLOYEES b
);


--부서 번호가 100인 사원들 조회

SELECT a.employee_id
, a.emp_name
, a.department_id
, b.department_name
FROM employees a, 
(
SELECT *
FROM departments
WHERE department_id = 100) b
WHERE a.department_id = b.department_id;


--SELECT에 들어가는 서브쿼리 예제
--부서 테이블 가져오기

SELECT a.employee_id
, a.emp_name
, a.department_id
, (SELECT dd.department_name
FROM departments dd
WHERE dd.department_id = a.department_id) AS dept_name
FROM employees a
WHERE a.salary >= 3000;


-- 카테고리명에 'R'이 포함된 제품군의
-- 접근경로별 판매실적 환율 1340
-- 서브쿼리 사용

SELECT c.channel_id, c.channel_desc, COUNT(s.cust_id), ROUND((sum(s.amount_sold) * 1340 / 1000000 )) AS "실적금액 (단위 : 백만원)"
FROM SALES s, channels c, PRODUCTS p 
WHERE s.channel_id = c.channel_id
AND s.prod_id = p.prod_id
AND p.PROD_SUBCATEGORY_ID IN
(
SELECT p2.prod_subcategory_id
FROM products p2
WHERE p2.PROD_SUBCATEGORY_desc LIKE '%R%'
GROUP BY p2.prod_subcategory_id
)
GROUP BY c.channel_id, c.channel_desc
;

-- SALES 매출액 평균
SELECT AVG(s.amount_sold)
FROM sales s;

-- 매출액 평균보다 판매 가격이 높은 제품들 (제품군 아님)

SELECT p.prod_name, s.amount_sold
FROM sales s, products p
WHERE s.prod_id = p.prod_id
AND s.amount_sold > 
(
SELECT AVG(s2.amount_sold)
FROM sales s2
);



-- 매출액 평균보다 판매 가격이 높은 제품들 (제품군 아님)
-- 갯수, 평균판매가

SELECT p.prod_id, p.prod_name, COUNT(s.cust_id), AVG(s.amount_sold)
FROM sales s, products p
WHERE p.prod_id = s.prod_id
AND s.amount_sold > 
(
SELECT AVG(s2.amount_sold)
FROM sales s2
)
GROUP BY p.prod_id, p.prod_name
ORDER BY AVG(s.amount_sold) DESC;


-- 제품이름에 's'가 포함된 제품들의 최대 매출액 보다 낮은
-- 판매가 제품들의 수량, 최소, 최대, 합계 평균매출액

SELECT 
p.prod_id, 
p.prod_name AS "판매자", 
COUNT(s.cust_id) AS "수량",
min(s.amount_sold) AS "최소매출액",
max(s.AMOUNT_SOLD) AS "최대 매출액",
sum(s.AMOUNT_SOLD) AS "총 매출액",
avg(s.AMOUNT_SOLD) AS "평균 매출액"
FROM sales s, products p
WHERE p.prod_id = s.prod_id
AND s.amount_sold <
(
SELECT max(s2.amount_sold)
FROM products p2, sales s2
WHERE p2.prod_name LIKE '%s%'
AND p2.prod_id = s2.prod_id
)
GROUP BY p.prod_name, p.prod_id
ORDER BY "총 매출액" DESC;


-- 기존문제에 서브쿼리 적용
-- 매출액 평균보다 높게 판매된 제품군의
-- 접근 경로별 판매실적 환율 1352



SELECT c.channel_id, c.channel_desc, COUNT(s.cust_id), TO_CHAR( (sum(s.amount_sold) * 1340 / 1000000 ), '999,999' ) AS "실적금액 (단위 : 백만원)"
FROM channels c, sales s, products p
WHERE p.prod_id = s.prod_id
AND c.channel_id = s.channel_id
AND s.amount_sold >
(
	SELECT AVG(s2.amount_sold)
	FROM sales s2
)
GROUP BY c.channel_id, c.channel_desc;



-- 기획부 하위 부서들에 있는 사원들 평균급여 보다 많이 받는 사원들
-- FROM에다 서브쿼리


SELECT e.employee_id, e.emp_name, d.department_name
FROM employees e, departments d,
(	
	SELECT AVG(e2.salary) AS "avsalary"
	FROM departments d2, EMPLOYEES e2
	WHERE d2.parent_id = 90
	AND d2.department_id = e2.DEPARTMENT_ID  
) so
WHERE e.department_id = d.department_id
AND so."avsalary" < e.salary;

































