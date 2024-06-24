-- CHUN QUERY
-- [Basic SELECT]
-- 4 8
-- 4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 한다. 그 대상자들의
-- 학번이 다음과 같을 때 대상자들을 찾는 적절한 SQL 구문을 작성하시오.
SELECT STUDENT_NAME FROM TB_STUDENT WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');
-- 8. 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는
-- 과목들은 어떤 과목인지 과목번호를 조회해보시오.
SELECT CLASS_NO FROM TB_CLASS WHERE PREATTENDING_CLASS_NO IS NOT NULL;
-- [Additional SELECT - 함수]
-- 2 6 10 14
-- 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의
-- 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자. (* 이때 올바르게 작성한 SQL
-- 문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)
SELECT PROFESSOR_NAME, PROFESSOR_SSN FROM TB_PROFESSOR WHERE LENGTH(PROFESSOR_NAME) != 3;
-- 6. 2020 년 크리스마스는 무슨 요일인가?
SELECT TO_CHAR(TO_DATE('2020-12-25'), 'day') "크리스마스 요일" FROM DUAL;
-- 10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이
-- 출력되도록 하시오.
SELECT DEPARTMENT_NO "학과번호", COUNT(DEPARTMENT_NO) "학생수(명)" FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1 ASC;
-- 14. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 한다. 어떤 SQL
-- 문장을 사용하면 가능하겠는가?
SELECT STUDENT_NAME "동일이름", COUNT(STUDENT_NAME) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME) >= 2
ORDER BY 1 ASC;
-- [Additional SELECT -Option]
-- 3 7 11 15
-- 3. 주소지가 강원도나 경기도인 학생들 중 1900 년대 학번을 가진 학생들의 이름과 학번,
-- 주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번",
-- "거주지 주소" 가 출력되도록 한다.
SELECT STUDENT_NAME "학생이름", STUDENT_NO "학번", STUDENT_ADDRESS "거주지 주소", TO_CHAR(ENTRANCE_DATE, 'YYYY') FROM TB_STUDENT
WHERE TO_CHAR(ENTRANCE_DATE, 'YYYY') LIKE '19%'
AND (STUDENT_ADDRESS LIKE '%강원%' OR STUDENT_ADDRESS LIKE '%경기도%');
-- 7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT
ON TB_CLASS.DEPARTMENT_NO = TB_DEPARTMENT.DEPARTMENT_NO;
-- 11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기
-- 위한 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL 문을
-- 작성하시오. 단, 출력헤더는 ‚학과이름, 학생이름, 지도교수이름으로
-- 출력되도록 한다.
SELECT DEPARTMENT_NAME "학과이름", STUDENT_NAME "학생이름", PROFESSOR_NAME "지도교수이름"
FROM TB_STUDENT
JOIN TB_PROFESSOR
ON TB_STUDENT.COACH_PROFESSOR_NO = TB_PROFESSOR.PROFESSOR_NO
JOIN TB_DEPARTMENT
ON TB_STUDENT.DEPARTMENT_NO = TB_DEPARTMENT.DEPARTMENT_NO
WHERE STUDENT_NO = 'A313047';
-- 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과
-- 이름, 평점을 출력하는 SQL 문을 작성하시오.
SELECT S.STUDENT_NO "학번" ,S.STUDENT_NAME "이름", D.DEPARTMENT_NAME "학과 이름", AVG(G.POINT) 평점
FROM TB_STUDENT S
JOIN TB_DEPARTMENT D
ON S.DEPARTMENT_NO = D.DEPARTMENT_NO
JOIN TB_GRADE G
ON S.STUDENT_NO = G.STUDENT_NO AND S.ABSENCE_YN = 'N'
GROUP BY S.STUDENT_NO, S.STUDENT_NAME, D.DEPARTMENT_NAME
HAVING AVG(G.POINT) >= 4.0
ORDER BY 2 ASC;
-- [DDL]
-- 1 5 9 13
-- 1. 계열 정보를 저장한 카테고리 테이블을 만들려고 한다. 다음과 같은 테이블을
-- 작성하시오.
CREATE TABLE TB_CATEGORY
(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);
-- 2. 과목 구분을 저장한 테이블을 만들려고 핚다. 다음과 같은 테이블을 작성하시오.
CREATE TABLE TB_CLASS_TYPE
(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);
-- 3. TB_CATAGORY 테이블의 NAME 컬럼에 PRIMARY KEY 를 생성하시오.
-- (KEY 이름을 생성하지 않아도 무방함. 만일 KEY 이를 지정하고자 한다면 이름은 본인이
-- 알아서 적당한 이름을 사용한다.)
ALTER TABLE TB_CATEGORY
ADD CONSTRAINTS PK_CATEGORY PRIMARY KEY(NAME);
-- 4. TB_CLASS_TYPE 테이블의 NAME 컬럼에 NULL 값이 들어가지 않도록 속성을 변경하시오.
ALTER TABLE TB_CLASS_TYPE
DROP COLUMN NAME;
ALTER TABLE TB_CLASS_TYPE
ADD NAME VARCHAR2(10) NOT NULL;
DESC TB_CLASS_TYPE;
-- 5. 두 테이블에서 컬럼 명이 NO 인 것은 기존 타입을 유지하면서 크기는 10 으로, 컬럼명이
-- NAME 인 것은 마찬가지로 기존 타입을 유지하면서 크기 20 으로 변경하시오.
ALTER TABLE TB_CLASS_TYPE
MODIFY NO VARCHAR2(10);
ALTER TABLE TB_CATEGORY
MODIFY NAME VARCHAR2(20);
ALTER TABLE TB_CLASS_TYPE
MODIFY NAME VARCHAR2(20);
DESC TB_CATEGORY;
DESC TB_CLASS_TYPE;
-- 6. 두 테이블의 NO 컬럼과 NAME 컬럼의 이름을 각 각 TB_ 를 제외한 테이블 이름이 앞에
-- 붙은 형태로 변경한다.
-- (ex. CATEGORY_NAME)
ALTER TABLE TB_CATEGORY
RENAME COLUMN NAME TO CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NO TO CLASS_TYPE_NO;
ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NAME TO CLASS_TYPE_NAME;
DESC TB_CATEGORY;
DESC TB_CLASS_TYPE;
-- 7. TB_CATAGORY 테이블과 TB_CLASS_TYPE 테이블의 PRIMARY KEY 이름을 다음과 같이
-- 변경하시오.
-- Primary Key 의 이름은 ‚PK_ + 컬럼이름으로 지정하시오. (ex. PK_CATEGORY_NAME )
ALTER TABLE TB_CATEGORY
RENAME CONSTRAINTS PK_CATEGORY TO PK_CATEGORY_NAME;
SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TB_CATEGORY';
ALTER TABLE TB_CLASS_TYPE
RENAME CONSTRAINTS SYS_C007318 TO PK_CLASS_TYPE_NO;
SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TB_CLASS_TYPE';
-- 8. 다음과 같은 INSERT 문을 수행한다.
INSERT INTO TB_CATEGORY VALUES ('공학','Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학','Y');
INSERT INTO TB_CATEGORY VALUES ('의학','Y');
INSERT INTO TB_CATEGORY VALUES ('예체능','Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회','Y');
COMMIT;
-- 9.TB_DEPARTMENT 의 CATEGORY 컬럼이 TB_CATEGORY 테이블의 CATEGORY_NAME 컬럼을 부모
-- 값으로 참조하도록 FOREIGN KEY 를 지정하시오. 이 때 KEY 이름은
-- FK_테이블이름_컬럼이름으로 지정한다. (ex. FK_DEPARTMENT_CATEGORY )
ALTER TABLE TB_DEPARTMENT
ADD CONSTRAINT FK_DEPARTMENT_CATEGORY FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY(CATEGORY_NAME);
-- 10. 춘 기술대학교 학생들의 정보만이 포함되어 있는 학생일반정보 VIEW 를 만들고자 한다.
-- 아래 내용을 참고하여 적절한 SQL 문을 작성하시오.
CREATE VIEW VW_학생일반정보
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS FROM TB_STUDENT;
-- 11. 춘 기술대학교는 1 년에 두 번씩 학과별로 학생과 지도교수가 지도 면담을 진행핚다.
-- 이를 위해 사용할 학생이름, 학과이름, 담당교수이름 으로 구성되어 있는 VIEW 를 만드시오.
-- 이때 지도 교수가 없는 학생이 있을 수 있음을 고려하시오 (단, 이 VIEW 는 단순 SELECT
-- 만을 할 경우 학과별로 정렬되어 화면에 보여지게 만드시오.)
SELECT * FROM VW_학생일반정보;
CREATE VIEW VW_지도면담
AS
SELECT TB_STUDENT.STUDENT_NAME "학생이름", TB_DEPARTMENT.DEPARTMENT_NAME "학과이름", TB_PROFESSOR.PROFESSOR_NAME "지도교수이름"
FROM TB_STUDENT
JOIN TB_DEPARTMENT
ON TB_STUDENT.DEPARTMENT_NO = TB_DEPARTMENT.DEPARTMENT_NO
LEFT JOIN TB_PROFESSOR
ON TB_STUDENT.COACH_PROFESSOR_NO = TB_PROFESSOR.PROFESSOR_NO
ORDER BY 1 ASC;
-- 12. 모든 학과의 학과별 학생 수를 확인할 수 있도록 적절한 VIEW 를 작성해 보자.
CREATE VIEW VW_학과별학생수
AS
SELECT DEPARTMENT_NAME, COUNT(DEPARTMENT_NAME) "STUDENT_COUNT"
FROM TB_STUDENT
JOIN TB_DEPARTMENT
ON TB_DEPARTMENT.DEPARTMENT_NO = TB_STUDENT.DEPARTMENT_NO
GROUP BY DEPARTMENT_NAME;
SELECT * FROM VW_학과별학생수;
-- 13. 위에서 생성한 학생일반정보 View 를 통해서 학번이 A213046 인 학생의 이름을 본인
-- 이름으로 변경하는 SQL 문을 작성하시오.
SELECT * FROM VW_학생일반정보 WHERE STUDENT_NO = 'A213046'; -- 서가은
UPDATE VW_학생일반정보 SET STUDENT_NAME='조승효' WHERE STUDENT_NO = 'A213046';
-- 14. 13 번에서와 같이 VIEW 를 통해서 데이터가 변경될 수 있는 상황을 막으려면 VIEW 를
-- 어떻게 생성해야 하는지 작성하시오.
DROP VIEW VW_학생일반정보;
CREATE VIEW VW_학생일반정보
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS FROM TB_STUDENT
WITH READ ONLY;
UPDATE VW_학생일반정보 SET STUDENT_NAME='조승효' WHERE STUDENT_NO = 'A213046'; -- 업데이트가 막힌다
-- [DML]
-- 2 6
-- 2. 춘 기술대학교 학생들의 정보가 포함되어 있는 학생일반정보 테이블을 만들고자 한다.
-- 아래 내용을 참고하여 적절한 SQL 문을 작성하시오. (서브쿼리를 이용하시오)
CREATE TABLE TB_학생일반정보
AS
SELECT STUDENT_NO "학번",  STUDENT_NAME "학생이름", STUDENT_ADDRESS "주소"
FROM TB_STUDENT;
SELECT * FROM TB_학생일반정보;
-- 6. 주민등록번호 보호법에 따라 학생정보 테이블에서 주민번호 뒷자리를 저장하지 않기로
-- 결정하였다. 이 내용을 반영한 적절한 SQL 문장을 작성하시오.
-- (예. 830530-2124663 ==> 830530 )
CREATE TABLE TB_주민번호보호학생
AS
SELECT * FROM TB_STUDENT;
SELECT * FROM TB_주민번호보호학생;
UPDATE TB_주민번호보호학생 SET STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);
SELECT * FROM TB_주민번호보호학생;