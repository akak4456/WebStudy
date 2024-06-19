-- 4일차 오라클 조인
-- 1. JOIN
--  - 두 개 이상의 테이블에서 연관성을 가지고 있는 데이터들을 따로 분류하여 새로운 가상의 테이블을 만듬
--  -> 여러 테이블의 레코드를 조합하여 하나의 레코드로 만듬
-- ANSI 표준 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPARTMENT.DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID;
-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

-- ANSI 표준 구문
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, J.JOB_NAME
FROM EMPLOYEE E
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE;
-- 조인하는 컬럼 같을 때 USING 구문
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J
USING(JOB_CODE);
-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- @실습문제1
-- 부서명과 지역명을 출력하세요.
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION
ON LOCATION_ID = LOCAL_CODE;

-- @실습문제2
-- 사원명과 직급명을 출력하세요!
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID;
-- @실습문제3
-- 지역명과 국가명을 출력하세요
SELECT LOCAL_NAME, NATIONAL_NAME
FROM LOCATION L
JOIN NATIONAL N
ON L.NATIONAL_CODE = N.NATIONAL_CODE;

-- @JOIN 종합실습
--1. 주민번호가 1970년대 생이면서 성별이 여자이고, 
-- 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
SELECT EMPLOYEE.EMP_NAME "사원명", EMPLOYEE.EMP_NO "주민번호",DEPARTMENT.DEPT_TITLE "부서명", JOB.JOB_NAME "직급명" FROM EMPLOYEE
JOIN DEPARTMENT
ON EMPLOYEE.DEPT_CODE = DEPARTMENT.DEPT_ID
JOIN JOB
ON EMPLOYEE.JOB_CODE = JOB.JOB_CODE
AND EMPLOYEE.EMP_NO LIKE '7_____-2%' AND SUBSTR(EMPLOYEE.EMP_NAME,1,1) = '전';
--2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
SELECT E.EMP_ID "사번", E.EMP_NAME "사원명", D.DEPT_TITLE "부서명"
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
AND E.EMP_NAME LIKE '%형%';
--3. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
SELECT E.EMP_NAME "사원명", J.JOB_NAME "직급명", D.DEPT_ID "부서코드", D.DEPT_TITLE "부서명"
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
AND D.DEPT_TITLE LIKE '해외영업%'
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE;
--4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
SELECT E.EMP_NAME "사원명", E.BONUS "보너스포인트", D.DEPT_TITLE "부서명", L.LOCAL_NAME "근무지역명"
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID AND E.BONUS IS NOT NULL
JOIN LOCATION L
ON D.LOCATION_ID = L.LOCAL_CODE;
--5. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
SELECT E.EMP_NAME "사원명", J.JOB_NAME "직급명",D.DEPT_TITLE "부서명", L.LOCAL_NAME "근무지역명"
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID AND D.DEPT_ID = 'D2'
JOIN LOCATION L
ON D.LOCATION_ID = L.LOCAL_CODE
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE;
--6. 급여등급테이블의 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 조인할 것)
-- 데이터 없음!
SELECT E.EMP_NAME "사원명", J.JOB_NAME "직급명", E.SALARY "급여", E.SALARY * 12 "연봉"
FROM EMPLOYEE E
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE
JOIN SAL_GRADE S
ON E.SAL_LEVEL = S.SAL_LEVEL AND E.SALARY > S.MAX_SAL;
--7. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
SELECT E.EMP_NAME "사원명", D.DEPT_TITLE "부서명", L.LOCAL_NAME "지역명", N.NATIONAL_NAME "국가명"
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L
ON D.LOCATION_ID = L.LOCAL_CODE
JOIN NATIONAL N
ON L.NATIONAL_CODE = N.NATIONAL_CODE AND N.NATIONAL_CODE IN ('KO', 'JP');
--8. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 
--단, join과 IN 사용할 것
SELECT E.EMP_NAME "사원명", J.JOB_NAME "직급명", E.SALARY "급여"
FROM EMPLOYEE E
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE
AND J.JOB_CODE IN ('J4', 'J7');

--9. 재직중인 직원과 퇴사한 직원의 수를 조회하시오. (JOIN아님)
SELECT DECODE(ENT_YN, 'Y', '퇴사', 'N', '재직'), COUNT(*)
FROM EMPLOYEE
GROUP BY ENT_YN;
