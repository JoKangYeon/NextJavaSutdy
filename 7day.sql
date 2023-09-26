-- 부서명 상위 부서명

SELECT e.department_name, d.department_name
FROM departments d, departments e
WHERE d.department_id = e.parent_id;

-- 상위 부서들의 하위부서 갯수

SELECT d.department_name, d.department_id, COUNT(d.department_id)
FROM departments d, departments e
WHERE d.department_id  = e.parent_id
GROUP BY d.department_id, d.department_name;

--상위 부서들의 편균연봉 환율 1340

SELECT d2.department_id, d2.department_name, (ROUND(AVG(e.salary*1340) / 10000) || '만원') AS "연봉"
FROM departments d1, departments d2, employees e
WHERE  d1.parent_id = d2.department_id
AND d2.department_id = e.department_id 
GROUP BY d2.department_id, d2.department_name;

--부서명 salary가 3000 7000 사이의 사원들의
--부서명, 평균연봉 환율 1340

SELECT d.department_id, d.department_name, (ROUND(AVG(E.SALARY *1340) / 10000) || '만원') AS "연봉"
FROM DEPARTMENTS d , EMPLOYEES e 
WHERE d.department_id = e.department_id
AND E.SALARY  BETWEEN 3000 AND 7000
GROUP BY d.department_name, d.department_id
ORDER BY d.department_id ASC;

--상관 이름에 't'가 포함되는 사원들의
-- 사원명, 부서명, 평균연봉 환율 1340

SELECT e1.EMPLOYEE_ID, e1.EMP_NAME, e2.EMP_NAME, d.DEPARTMENT_ID, d.DEPARTMENT_NAME, (ROUND(AVG(e1.salary * 1340) / 1000000)) AS "연봉 (단위:백만원)"
FROM DEPARTMENTS d, EMPLOYEES e1, EMPLOYEES e2 
WHERE e1.MANAGER_ID = e2.EMPLOYEE_ID 
AND e1.DEPARTMENT_ID = d.DEPARTMENT_ID
AND e2.EMP_NAME LIKE '%t%'
GROUP BY e1.EMPLOYEE_ID, e1.EMP_NAME, e2.EMP_NAME, d.DEPARTMENT_ID, d.DEPARTMENT_NAME
ORDER BY e1.EMPLOYEE_ID ASC;


--접근경로별 판매수량 판매실적 환율 1340
-- TO_CHAR 사용하여 '999,999'형식으로 금액표기

SELECT s.channel_id, c.channel_desc, COUNT(s.cust_id), TO_CHAR( (sum(s.amount_sold) * 1340 / 1000000 ), '999,999,999,999' ) AS "실적금액 (단위 : 백만원)"
FROM SALES s, channels c
WHERE s.channel_id = c.channel_id
GROUP BY s.channel_id, c.channel_desc;

-- Recordable CDs 제품군의
-- 접근경로별 판매실적 환율 1340


SELECT s.channel_id, c.channel_desc, COUNT(s.cust_id), ROUND((sum(s.amount_sold) * 1340 / 1000000 )) AS "실적금액 (단위 : 백만원)"
FROM SALES s, channels c, PRODUCTS p 
WHERE s.channel_id = c.channel_id
AND s.prod_id = p.prod_id
AND p.PROD_SUBCATEGORY_ID = 2055
GROUP BY s.channel_id, c.channel_desc;




















