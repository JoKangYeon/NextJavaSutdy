-- 데이터 갯수 구하기
SELECT COUNT(employee_id)
FROM employees;


-- manager_id가 100인 사람들의 수 
SELECT COUNT(employee_id) as "사원수", AVG(salary) as "급여평균"
FROM employees
WHERE manager_id = 100;

--급여평균 
SELECT COUNT(employee_id) as "사원수", AVG(salary) as "급여평균"
FROM employees;

--최대최소
SELECT COUNT(employee_id) as "사원수", 
MIN(salary) as "최소",
MAX(salary) as "최대"
FROM employees;


--합계 
SELECT COUNT(employee_id) as "사원수", 
SUM(salary) as "총 지출임금"
FROM employees;

--분산 -- 평균으로부터 얼마나 차이가 나는지 
SELECT COUNT(employee_id) as "사원수", 
ROUND(VARIANCE(salary)) as "임금분산",
ROUND(STDDEV(salary)) as "임금 표준편차"
FROM employees;

-- 부서별 평균 임금
SELECT department_id as "부서",
COUNT(employee_id) as "부서별 사원수",  
ROUND(AVG(salary)) as "급여평균"
FROM employees
GROUP BY department_id
ORDER BY "부서별 사원수" ASC
;

-- 부서별 평균 임금
SELECT salary, 
COUNT(employee_id) as "임금별 사원수"  
FROM employees
GROUP BY salary 
ORDER BY "임금별 사원수" ASC;



SELECT manager_id, 
COUNT(employee_id) as "매니저별 사원수"
FROM employees
GROUP BY manager_id
ORDER BY "매니저별 사원수" ASC;


--- 부서별 임금 최대, 최소
SELECT department_id as "부서별",
MIN(salary) as "최소",
MAX(salary) as "최대"
FROM employees
GROUP BY department_id
;

-- countries에서 COUNTRY_REGION_ID별 갯수 

SELECT COUNTRY_REGION as "대륙명", COUNTRY_REGION_ID,
COUNT (COUNTRY_REGION_ID) as "대륙별 나라갯수"
FROM countries
GROUP BY COUNTRY_REGION, COUNTRY_REGION_ID
;


-- products에서 제품종류 PROD_CATEGORY_ID품별
-- 제품카테고리ID, 카테고리명, 수량


SELECT 
PROD_CATEGORY_ID as "제품카테고리ID", 
PROD_CATEGORY as "카테고리명", 
PROD_CATEGORY_DESC as "카테고리 설명",
COUNT(PROD_CATEGORY_ID) as "수량"
FROM products
GROUP BY PROD_CATEGORY_ID, PROD_CATEGORY,PROD_CATEGORY_DESC
;

-- -- products에서 제품종류 PROD_CATEGORY_ID별
-- 제품카테고리id, 카테고리명, 수량,
-- 최소금액, 최대금액, 평균금액 prod_list_price 사용하면됨


SELECT 
PROD_CATEGORY_ID as "제품카테고리ID", 
PROD_CATEGORY as "카테고리명", 
COUNT(PROD_CATEGORY_ID) as "수량",
ROUND(MIN(prod_list_price)) as "최소",
ROUND(MAX(prod_list_price)) as "최대",
ROUND(AVG(prod_list_price)) as "평균"
FROM products
GROUP BY PROD_CATEGORY_ID, PROD_CATEGORY
ORDER BY "제품카테고리ID" ASC
;

-- HAVING -> 합한(GROUP BY) 후에 조건걸기
-- WHERE -> 합하기(GROUP BY)  전 조건걸기 


SELECT 
PROD_CATEGORY_ID as "제품카테고리ID", 
PROD_CATEGORY as "카테고리명", 
COUNT(PROD_CATEGORY_ID) as "수량",
ROUND(MIN(prod_list_price)) as "최소",
ROUND(MAX(prod_list_price)) as "최대",
ROUND(AVG(prod_list_price)) as "평균"
FROM products
GROUP BY PROD_CATEGORY_ID, PROD_CATEGORY
HAVING ROUND(AVG(prod_list_price)) >200
ORDER BY "수량" ASC   
;

-- ROLLUP / 활용도가 낮음

-- UNION

CREATE TABLE exp_goods_asia (
       country VARCHAR2(10),
       seq     NUMBER,
       goods   VARCHAR2(80));
       
INSERT INTO exp_goods_asia VALUES ('한국', 1, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('한국', 2, '자동차');
INSERT INTO exp_goods_asia VALUES ('한국', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('한국', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('한국', 5,  'LCD');
INSERT INTO exp_goods_asia VALUES ('한국', 6,  '자동차부품');
INSERT INTO exp_goods_asia VALUES ('한국', 7,  '휴대전화');
INSERT INTO exp_goods_asia VALUES ('한국', 8,  '환식탄화수소');
INSERT INTO exp_goods_asia VALUES ('한국', 9,  '무선송신기 디스플레이 부속품');
INSERT INTO exp_goods_asia VALUES ('한국', 10,  '철 또는 비합금강');

INSERT INTO exp_goods_asia VALUES ('일본', 1, '자동차');
INSERT INTO exp_goods_asia VALUES ('일본', 2, '자동차부품');
INSERT INTO exp_goods_asia VALUES ('일본', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('일본', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('일본', 5, '반도체웨이퍼');
INSERT INTO exp_goods_asia VALUES ('일본', 6, '화물차');
INSERT INTO exp_goods_asia VALUES ('일본', 7, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('일본', 8, '건설기계');
INSERT INTO exp_goods_asia VALUES ('일본', 9, '다이오드, 트랜지스터');
INSERT INTO exp_goods_asia VALUES ('일본', 10, '기계류');

COMMIT;

SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
 ORDER BY seq;

SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본'
 ORDER BY seq;
 
 
SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
UNION 
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본';
 
 --부서별 임금 표준편차
 -- 사람이름에 'v'가 포함된 사람의 임금 표준편차

SELECT 
COUNT(employee_id) as "사원수",
ROUND(AVG(salary)) as "급여평균",
ROUND(STDDEV(salary)) as "급여표준편차", 
department_id as "부서"
FROM employees
WHERE emp_name LIKE '%v%'
GROUP BY department_id
ORDER BY "부서" DESC
;

-- sales에서 판매사원별 매출액 amout_sold 합계
SELECT 
employee_id as "판매사원",
ROUND(SUM(amount_sold)) as "매출액"
FROM sales
GROUP BY employee_id
ORDER BY "매출액" DESC
;

-- SALES에서 월별 (sales_date) 매출액 amount_sold
SELECT SUBSTR(sales_date, 4, 2) as "월",
ROUND(SUM(amount_sold)) 
FROM sales
GROUP BY SUBSTR(sales_date, 4, 2)
ORDER BY "월" ASC
;

SELECT SUBSTR(sales_date, 1, 2) as "년도",
ROUND(SUM(amount_sold)) 
FROM sales
GROUP BY SUBSTR(sales_date, 1, 2)
ORDER BY "년도" ASC
;

-- SALES에서 짝수월별 (sales_date) 매출액 amount_sold

SELECT SUBSTR(sales_date, 4, 2) as "월",
ROUND(SUM(amount_sold)) 
FROM sales
WHERE MOD(SUBSTR(sales_date, 4, 2), 2) = 0
GROUP BY SUBSTR(sales_date, 4, 2)   
ORDER BY "월" ASC
;









