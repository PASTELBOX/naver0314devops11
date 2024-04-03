--��������
--ename�� 'A'�� 'S'�� �����ϴ� ����� ENAME,SAL,COMM ��ȸ
SELECT ENAME,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';

--COMM�� NULL�� �ƴ� ����� ��ȸ
SELECT COMM FROM EMP WHERE COMM IS NOT NULL;

--MGR�� 7698,7566,7782�� ��� ��ȸ (IN���)
SELECT MGR FROM EMP WHERE MGR IN (7698,7566,7728);

--SAL�� 2500���� 3000���� ��ȸ (AND����)
SELECT SAL FROM EMP WHERE SAL>=2500 AND SAL<=3000;

--SAL�� 2500���� 3000���� ��ȸ (BETWEEN ���)
SELECT SAL FROM EMP WHERE SAL BETWEEN 2500 AND 3000;

--JOB�� �ߺ�ó���ؼ� �ѹ����� ����Ͻÿ�
SELECT DISTINCT JOB FROM EMP;

--�������� ����
--ALLEN�� ������ ���� ������ ���� ������� ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'ALLEN');

--SCOTT�� MGR�� ���� ���� ���� ����� ������ ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE MGR = (SELECT MGR FROM EMP WHERE ENAME = 'SCOTT');

--�����Լ�, �����Լ� ����
SELECT ABS(-5),ABS(5) FROM DUAL; --ABS :  ���밪
SELECT CEIL(3.0),CEIL(3.1),CEIL(3.9) FROM DUAL; --CEIL : ������ �ø�
SELECT FLOOR(3.0),FLOOR(3.1),FLOOR(3.9) FROM DUAL; --FLOOR : ������ ����
SELECT MOD(7,3),MOD(9,5) FROM DUAL; --MOD : ������
SELECT POWER(2,3),POWER(3,4) FROM DUAL; --POWER : ������
SELECT ROUND(23.456,2),ROUND(8923,-1) FROM DUAL; --ROUND : �ݿø�

--�����Լ�
SELECT CONCAT('HAPPY','DAY') FROM DUAL;
SELECT 'HAPPY'||'DAY' FROM DUAL; --���� ����� ����
SELECT INITCAP('HAPPY'),INITCAP('hello') FROM DUAL; --ù���ڸ� �빮�ڷ�
SELECT LOWER('heLLOdAy'),UPPER('heLLOdAy') FROM DUAL;
SELECT LOWER(ename),INITCAP(ename) FROM EMP;
SELECT LPAD(SAL,10,'*') FROM EMP; --�������� * ä���
SELECT RPAD(SAL,10,'*') FROM EMP; --���������� * ä���
SELECT SUBSTR('happy day',2,3) FROM DUAL; --2���ε������� ���� (ù���� �ε����� 1) : app
SELECT SUBSTR('happy day',-5,3) FROM DUAL; --�ڿ��� 5��°���� 3���� (ù���ڴ� �ε����� 1) : y d
SELECT ENAME,LENGTH(ENAME) ���ڼ� FROM EMP; --LENGTH : ����, ���ڼ�
SELECT REPLACE('Good Day','o','*') FROM DUAL; --o�� *�� �����ؼ� ���
SELECT INSTR('happy','a') FROM DUAL; --happy�� a�� ��ġ : 2
SELECT INSTR('happy','x') FROM DUAL; --x�� ���� ��� 0
SELECT INSTR('have a nice day','nice') FROM DUAL; --8��°�� nice�� ����
SELECT TRIM('     hello       ') FROM DUAL; --�յ� ���� ������ ���

--��Ÿ�Լ�
--NVL�� NULL�ϰ�� ��ü������ ���
SELECT NVL(COMM,1000) FROM DUAL; --NULL�� ��� 1000���� ���
--DECODE : ���� ���� �ٸ����� ����� ��
SELECT ENAME �����,DEPTNO �μ��ڵ�,
DECODE(DEPTNO,10,'ȫ����',20,'������',30,'�λ��') �μ��� FROM EMP;

--JOIN : PPT 43������
--INNER JOIN (��������), EQUI JOIN

--��� 1
SELECT
    EMP.EMPNO,EMP.ENAME,EMP.JOB,DEPT.DNAME,DEPT.LOC
FROM EMP,DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO;

--��� 2, �����̺� ���������� �ִ� �÷��� ��쿡�� �տ� ���̺���� ���̰� �������� ��������
SELECT
    EMPNO,ENAME,JOB,DNAME,LOC
FROM EMP,DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO;

--��� 3 : ���̺���� �ʹ� �� ��쿡�� ��Ī�� ����� �� �ִ�
SELECT
    E.EMPNO,ENAME,JOB,DNAME,LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO;


