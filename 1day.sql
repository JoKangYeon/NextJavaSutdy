CREATE TABLE ex2_1(
    c1 varchar2(10),
    c2 number(10)
);

INSERT INTO ex2_1 (c1, c2) VALUES ('aaa', 10);
INSERT INTO ex2_1 (c1, c2) VALUES ('rggfregfg', '10');
INSERT INTO ex2_1 (c1, c2) VALUES ('rggfregfg', 'rgfjnhrthberg');

SELECT *
FROM ex2_1;


CREATE TABLE ex2_5
(
    co1 DATE,
    co2 NUMBER
);

INSERT INTO ex2_5 VALUES(sysdate, 20);

INSERT INTO ex2_5 VALUES(sysdate, '30');
INSERT INTO ex2_5 VALUES(sysdate, 'etrhteshergfadf');

SELECT *
FROM ex2_5;



CREATE TABLE member
(
    user_id VARCHAR2(100), --사용자 아이디 
    password VARCHAR2(100),-- 비밀번호 
    user_name VARCHAR2(100),-- 사용자 이름 
    email VARCHAR2(100), -- 이메일
    create_date DATE -- 생성날짜 
);


INSERT INTO member
(
user_id,
password,
user_name,
email,
create_date
)
VALUES
(
 'kangyeon',
 'q1w2e3r4!',
 '조강연',
 'test@naver.com',
 sysdate
);

SELECT *
FROM member;

SELECT user_name
FROM member;


SELECT user_id, password
FROM member
WHERE user_id = 'kangyeon'
AND password = 'q1w2e3r4!';


INSERT INTO member
(
user_id,
password,
user_name,
email,
create_date
)
VALUES
(
 'kangyeon2',
 'q1w2e3r4!',
 '조강연2',
 'test@naver.com',
 sysdate
);

INSERT INTO member
(
user_id,
password,
user_name,
email,
create_date
)
VALUES
(
 'kangyeon3',
 'q1w2e3r4!',
 '조강연3',
 'test@naver.com',
 sysdate
);


SELECT user_id, password
FROM member
WHERE user_id = 'kangyeon3'
AND password = 'q1w2e3r4!';

DROP TABLE member;
commit;

CREATE TABLE member
(
    user_id VARCHAR2(100) PRIMARY KEY, --사용자 아이디 
    password VARCHAR2(100) NOT NULL,-- 비밀번호 
    user_name VARCHAR2(100) NOT NULL, -- 사용자 이름 
    email VARCHAR2(100) UNIQUE, -- 이메일
    create_date DATE -- 생성날짜 
);  