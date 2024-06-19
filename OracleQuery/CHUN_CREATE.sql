SHOW USER;

CREATE TABLE TB_DEPARTMENT
(
    DEPARTMENT_NO VARCHAR2(10) PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR2(20) NOT NULL,
    CATEGORY VARCHAR2(20),
    OPEN_YN CHAR(1),
    CAPACITY NUMBER
);

COMMENT ON COLUMN TB_DEPARTMENT.DEPARTMENT_NO IS '학과 번호';
COMMENT ON COLUMN TB_DEPARTMENT.DEPARTMENT_NAME IS '학과 이름';
COMMENT ON COLUMN TB_DEPARTMENT.CATEGORY IS '계열';
COMMENT ON COLUMN TB_DEPARTMENT.OPEN_YN IS '개설 여부';
COMMENT ON COLUMN TB_DEPARTMENT.CAPACITY IS '정원';

CREATE TABLE TB_STUDENT
(
    STUDENT_NO VARCHAR2(10) PRIMARY KEY,
    DEPARTMENT_NO VARCHAR2(10) REFERENCES TB_DEPARTMENT(DEPARTMENT_NO) NOT NULL,
    STUDENT_NAME VARCHAR2(30) NOT NULL,
    STUDENT_SSN VARCHAR2(14),
    STUDENT_ADDRESS VARCHAR2(100),
    ENTRANCE_DATE DATE,
    ABSENCE_YN CHAR(1),
    COACH_PROFESSOR_NO VARCHAR2(10) REFERENCES TB_PROFESSOR(PROFESSOR_NO)
);

CREATE TABLE TB_CLASS
(
    CLASS_NO VARCHAR2(10) PRIMARY KEY,
    DEPARTMENT_NO VARCHAR2(10) REFERENCES TB_DEPARTMENT(DEPARTMENT_NO) NOT NULL,
    PREATTENDING_CLASS_NO VARCHAR2(10),
    CLASS_NAME VARCHAR2(30) NOT NULL,
    CLASS_TYPE VARCHAR2(10) NULL
);

CREATE TABLE TB_CLASS_PROFESSOR
(
    CLASS_NO VARCHAR2(10) REFERENCES TB_CLASS(CLASS_NO),
    PROFESSOR_NO VARCHAR2(10) REFERENCES TB_PROFESSOR(PROFESSOR_NO),
    
    CONSTRAINT PK_CLASS_PROFESSOR PRIMARY KEY(CLASS_NO, PROFESSOR_NO)
);

CREATE TABLE TB_PROFESSOR
(
    PROFESSOR_NO VARCHAR2(10) PRIMARY KEY,
    PROFESSOR_NAME VARCHAR2(30) NOT NULL,
    PROFESSOR_SSN VARCHAR2(14),
    PROFESSOR_ADDRESS VARCHAR2(100),
    DEPARTMENT_NO VARCHAR2(10) REFERENCES TB_DEPARTMENT(DEPARTMENT_NO)
);

CREATE TABLE TB_GRADE
(
    TERM_NO VARCHAR2(10) PRIMARY KEY,
    CLASS_NO VARCHAR2(10) REFERENCES TB_CLASS(CLASS_NO) NOT NULL,
    STUDENT_NO VARCHAR2(10) REFERENCES TB_STUDENT(STUDENT_NO) NOT NULL,
    POINT NUMBER(3,2)
);