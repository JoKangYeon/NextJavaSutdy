DECLARE
vs_emp_name employees.emp_name%TYPE;
vs_dep_name departments.department_name%TYPE;
BEGIN
SELECT a.emp_name, b.department_name
INTO vs_emp_name, vs_dep_name
FROM employees a,
departments b
WHERE a.department_id = b.department_id
AND a.employee_id = 100;
DBMS_OUTPUT.PUT_LINE( vs_emp_name || ' - ' || vs_dep_name);
END;



-- 변수 생성 및 사용
DECLARE
	test NUMBER;

BEGIN
	test := 100;
	-- test - 100;

	DBMS_OUTPUT.PUT_LINE('test의 값 = ' || test);
	-- System.out.println("test의 값 = " + test);
END;

-- 연산자
DECLARE
	e NUMBER := 0;
	m NUMBER := 0.00000001;
	c NUMBER := 299792458;

BEGIN
	e := m * c * c;
	e := ROUND(e);
	DBMS_OUTPUT.PUT_LINE(e);
END;

-- 운동에너지 = 무게 * 속도 * 속도 * 0.5
-- k2 소총의 운동에너지 
-- 탄자 무게 4g (단위 1000g), 탄속이 960M/s

DECLARE
	a NUMBER := 0.004;
	b NUMBER := 960;
	c NUMBER := 0.5;
	s NUMBER := 0;
BEGIN
	s := a * b * b * c;
	s := ROUND(s);
	DBMS_OUTPUT.PUT_LINE(s);
END;


-- 특정인물의 연봉 인상 결과 
DECLARE
	vs_emp_id employees.employee_id%TYPE;
	vs_emp_name employees.emp_name%TYPE;
	vs_salary employees.salary%TYPE;
BEGIN
	SELECT employee_id, emp_name, salary
	INTO vs_emp_id, vs_emp_name, vs_salary
	FROM EMPLOYEES e 
	WHERE e.employee_id = 100;

	DBMS_OUTPUT.PUT_LINE	( vs_emp_name || '연봉 인상 전');
	DBMS_OUTPUT.PUT_LINE	( vs_emp_name || ' - ' || vs_salary);
	vs_salary := vs_salary * 1.1;
	
	DBMS_OUTPUT.PUT_LINE	( vs_emp_name || '연봉 인상 후' );
	DBMS_OUTPUT.PUT_LINE	( vs_emp_name || ' - ' || vs_salary);
	
	UPDATE EMPLOYEES
	SET salary = vs_salary
	WHERE employee_id = vs_emp_id;
	COMMIT;
END;
	
-- 방금 인상한 아저씨의 연봉을 조회 

DECLARE
	test NUMBER := :a;
BEGIN

	IF test > 1000 THEN
		DBMS_OUTPUT.PUT_LINE('test는 1000보다 크다');
	ELSE
		DBMS_OUTPUT.PUT_LINE('test는 1000보다 작다');
	END IF;	

END;


--입력한 값이 짝수인지 아닌지 판별하기


DECLARE
	test NUMBER;
BEGIN
	test := 2;
	
	IF MOD(test, 2) = 0 THEN
		DBMS_OUTPUT.PUT_LINE('test는 짝수다');
	ELSE 
		DBMS_OUTPUT.PUT_LINE('test는 홀수다');
	END IF;	

END;



-- FOR문;
-- 1부터 10까지 숫자 출력 


DECLARE
	test NUMBER;
BEGIN
	FOR i IN 1..10
	LOOP
		DBMS_OUTPUT.PUT_LINE(i);
	END LOOP;
END;
	


-- WHILE
-- 1부터 10까지 숫자 출력 


DECLARE
	i NUMBER := 0;
	seq_size NUMBER := 10;
BEGIN
	WHILE i < seq_size
	LOOP
		DBMS_OUTPUT.PUT_LINE(i);
		i := i + 1;
	END LOOP;
END;

-- 1부터 10까지 홀수 찾기

DECLARE
	test NUMBER;
BEGIN
	FOR i IN 1..10
	LOOP
		IF MOD(i, 2) = 1 THEN
		DBMS_OUTPUT.PUT_LINE(i ||'홀수');
		END IF;
	END LOOP;
END;
		
		
-- 50이하 소수 찾기

DECLARE
	n NUMBER;
	k NUMBER := 2;
	t NUMBER := 0;
BEGIN
	FOR i IN 2..50
	LOOP
		k := 2;
		t := 0;
		WHILE k < i
		LOOP
				IF MOD(i, k) = 0 THEN
					t := 1;
				END IF;
				k := k + 1;
			END LOOP;
		IF t = 0 THEN
				DBMS_OUTPUT.PUT_LINE(i || ' 소수');
			END IF;
		END LOOP;
END;
		








