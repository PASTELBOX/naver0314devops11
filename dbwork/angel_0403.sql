--������ ����
--�⺻ 1���� 1�� �����ϴ� �������� �����ϰ� �⺻��ɾ �ָ��
CREATE SEQUENCE SEQ1;

--��ü ������ ��ȸ
SELECT * FROM SEQ;

--���� �������� �߻� : NEXTVAL
SELECT SEQ1.NEXTVAL FROM DUAL; --1�� ������ ���� �߻��Ѵ�

--10���� 5�� �����ϴ� �������� �����غ���, ĳ�ð� �⺻ 20�ε� ���ֺ���
CREATE SEQUENCE SEQ2 START WITH 10 INCREMENT BY 5 NOCACHE;

--SEQ2���� �߻����Ѻ���
SELECT SEQ2.NEXTVAL FROM DUAL;

--1���� 3�� ����, ĳ��0, �ƽ� 100
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 3 NOCACHE MAXVALUE 100;

--SEQ3 ���� �߻����Ѻ���
SELECT SEQ3.NEXTVAL FROM DUAL;

--�������� ����
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;

--���� ���̺��� ����� ������ ����(1���� 1������(����),CACHE 0)
CREATE SEQUENCE SEQ_TEST NOCACHE;

--������ ���̺� ����
CREATE TABLE HELLO (
    IDX NUMBER(3) PRIMARY KEY,
    IRUM VARCHAR2(20),
    AGE NUMBER(3)
);

--���̺� ���� ���� : ALTER TABLE
--IRUM�� ���̸� 20���� 30���� �����غ���
ALTER TABLE HELLO MODIFY IRUM VARCHAR2(30);

--ADDR�̶�� �÷��� �߰��غ���(���ڿ� ���̴� 100)
ALTER TABLE HELLO ADD ADR VARCHAR2(100);

--AGE��� �÷��� �����غ���
ALTER TABLE HELLO DROP COLUMN AGE;

--�÷��� ����(ADDR -> ADDRESS)
ALTER TABLE HELLO RENAME COLUMN ADDR TO ADDRESS;

--�÷� �ΰ� �߰��غ���
ALTER TABLE HELLO ADD BLOOD VARCHAR2(3);
ALTER TABLE HELLO ADD AGE NUMBER(3);

--�����͸� �߰��غ���
INSERT INTO HELLO (IRUM) VALUES ('lee'); --�����߻�,IDX�� PK�̹Ƿ� �ݵ�� ���� �־���Ѵ�

INSERT INTO HELLO (IDX,IRUM) VALUES (SEQ_TEST.NEXTVAL,'lee');
INSERT INTO HELLO (IDX,BLOOD,ADR) VALUES (SEQ_TEST.NEXTVAL,'AB','���� ����');

--�÷��� ������ ���̺��� �÷� ������� ��簪�� ����Ѵ�
INSERT INTO HELLO VALUES(SEQ_TEST.NEXTVAL,'����','���ֵ� �ֿ���','O',23);

--����
--�̸��� '����'�� ����� �������� B������ �����غ���
UPDATE HELLO SET BLOOD='B' WHERE IRUM='����';
--IDX�� 2�� ����� IRUM,AGE�� �����غ���
UPDATE HELLO SET IRUM='��ȣ��',AGE=35 WHERE IDX=4;
--IDX�� 3�� ����� ADDRESS,BLOOD,AGE�� ���� �����ϼ���
UPDATE HELLO SET IRUM='LEE',AGE=45,BLOOD='O',ADR='���� ����' WHERE IDX=3;

--����
DELETE FROM HELLO WHERE IDX=2;
--AGE�� 30�̻��� �����ʹ� ��� ����
DELETE FROM HELLO WHERE AGE>=3;

--���̺��� ����
DROP TABLE HELLO;

SELECT * FROM HELLO;

----------------------------------------------------------
--���ο� ���̺� ����, �̹����� ���� ���������� �߰��ؼ� �����غ���
CREATE TABLE STUDENT (
    NUM NUMBER(3) CONSTRAINT PK_NUM PRIMARY KEY,
    STUNAME VARCHAR2(20) CONSTRAINT NN_NAME NOT NULL,
    SCORE NUMBER(3) CONSTRAINT CK_SCORE CHECK(SCORE>=1 AND SCORE<=100),
    BIRTHDAY DATE 
);

--INSERT�� ������ �߰��� �ϴµ� ���� ������ �߻����Ѻ���
INSERT INTO STUDENT (NUM,STUNAME) VALUES (1,'��̸�');--OK

--ORA-01400: NULL�� ("ANGEL"."STUDENT"."NUM") �ȿ� ������ �� �����ϴ�
INSERT INTO STUDENT(STUNAME,SCORE) VALUES ('�̹���',45);--����

--ORA-00001: ���Ἲ ���� ����(ANGEL.PK_NUM)�� ����˴ϴ�
--NUM�� PK(PK�� NOT NULL+UNIQUE)
INSERT INTO STUDENT (NUM,STUNAME) VALUES (1,'ȫ����');

--ORA-02290: üũ ��������(ANGEL.CK_SCORE)�� ����Ǿ����ϴ�
--SCORE�� ������ 1~100�̾�� �Ѵ�
INSERT INTO STUDENT (NUM,STUNAME,SCORE) VALUES (2,'����ȣ',110);--����

--���� ���� �������ͷ� �߰��غ���
INSERT INTO STUDENT VALUES (3,'�̹���',89,SYSDATE);--��¥�� ���糯¥��
INSERT INTO STUDENT VALUES (4,'�����',77,'2010-12-20');--��¥�� ���糯¥��
COMMIT; --COMMIT�� �ϴ� �ϸ� ROLLBACK�� �ȵȴ�

INSERT INTO STUDENT VALUES (5,'��̳�',56,'2019-05-10');--��¥�� ���糯¥��
INSERT INTO STUDENT VALUES (6,'������',98,SYSDATE);--��¥�� ���糯¥��
INSERT INTO STUDENT VALUES (7,'������',67,'2015-09-12');--��¥�� ���糯¥��
INSERT INTO STUDENT VALUES (8,'��ȣ��',66,'2019-05-03');--��¥�� ���糯¥��
COMMIT;
ROLLBACK;    --������ COMMIT�� ������ DML�۾��� ���� �ѹ�

--NUM�� 5���� �������� �̸��� '�չ̶�',SCORE�� 80���� ����
UPDATE STUDENT SET STUNAME='�չ̶�',SCORE=80 WHERE NUM=5;

--BIRTHDAY�� ���� 5�� ����� ������ �ϰ������� 85�� �����Ͻÿ�
UPDATE STUDENT SET SCORE=85 WHERE TO_CHAR(BIRTHDAY,'MM')=5;
COMMIT;

--NUM�� 7�� ������ ����
DELETE FROM STUDENT WHERE NUM=7;

--�ѹ� �� ������ Ȯ���ϱ�
ROLLBACK;

--�ٽ� ������ ����
DELETE FROM STUDENT WHERE NUM=7;

--COMMIT �ϱ�
COMMIT;

--�ٽ� �ѹ��� ������ Ȯ���ϱ�
ROLLBACK; --�̹� Ŀ�Ե� �����ʹ� ��ҵ��� �ʴ´�

--���ʿ��� �������� ����
ALTER TABLE STUDENT DROP CONSTRAINT CK_SCORE;
ALTER TABLE STUDENT DROP CONSTRAINT NN_NAME;

--���ο� �������� �߰�
ALTER TABLE STUDENT ADD CONSTRAINT UQ_NAME UNIQUE(STUNAME);


--���� �̸��� �����͸� �߰��غ���
--ORA-00001: ���Ἲ ���� ����(ANGEL.UQ_NAME)�� ����˴ϴ�
INSERT INTO STUDENT (NUM,STUNAME) VALUES (10,'��ȣ��');

--������ ������ �������� ���̺��� �������ּ���
DROP SEQUENCE SEQ_TEST;
DROP TABLE STUDENT;

SELECT * FROM STUDENT;
---------------------------------------------------------------

/*
JOIN ������ ���̺� 2�� �����ϱ�
���̺� #1 : 
        FOOD - FOODNUM ����(3)
               FOODNAME ANSWKDUR(20)
               FOODPRICE ����(7)
               FOODSIZE ���ڿ�(20)
               
        BOOKING - BNUM PK ����(3)
                  BMAME ���ڿ�(20) NN
                  BHP ���ڿ�(20) UQ
                  FOODNUM ����(3) - FK(FOOD�� FOODNUM)
                  BOOKINGDAY DATE
                  
        �ܺ�Ű�� ����Ȱ�� BOOKING�� �����Ͱ� �߰��� ���� �߰��� ���� �߰��� FOODNUM�� ������ �� ����
        (���� ��� �Խ����� ��۰��� ��� �ܺ�Ű�� ����Ǿ��ִµ�
        �̶��� ����� �޸� ��� �ش���� ������ �� ���� �Խ��ǵ��� �ִ�)
        -�׷��� ���� FOOD�� �����͸� �����ϸ� �� �޴��� �߰��� ���� �����͵�
        �ڵ����� ������Ű���� �� ��� BOOKING�� �ܺ�Ű�� �����Ҷ� ON DELETE CASCADE�� �ָ� �ȴ�
*/

CREATE TABLE FOOD (
    FOODNUM NUMBER(3) CONSTRAINT PK_FOODNUM PRIMARY KEY,
    FOODNAME VARCHAR2(20),
    FOODPRICE NUMBER(7),
    FOODSIZE VARCHAR2(20)
);

--�޴��� ����غ���
INSERT INTO FOOD VALUES(100,'¥���',9000,'����');
INSERT INTO FOOD VALUES(101,'¥���',11000,'�����');
INSERT INTO FOOD VALUES(200,'������',15000,'����');
INSERT INTO FOOD VALUES(201,'������',20000,'�����');
INSERT INTO FOOD VALUES(300,'ĥ������',15000,'��');
INSERT INTO FOOD VALUES(301,'ĥ������',30000,'��');
INSERT INTO FOOD VALUES(400,'�ع�«��',11000,'����');
COMMIT;
SELECT * FROM FOOD;

--������ �߰�
CREATE SEQUENCE SEQ_FOOD NOCACHE;

--BOOKING ���̺� ����
CREATE TABLE BOOKING (
    BNUM NUMBER(3) CONSTRAINT PK_BNUM PRIMARY KEY,
    BNAME VARCHAR(20) CONSTRAINT NN_BNAME NOT NULL,
    BHP VARCHAR2(20) CONSTRAINT UQ_BHP UNIQUE,
    FOODNUM NUMBER(3),
    BOOKINGDAY DATE,
    CONSTRAINT FK_FOODNUM FOREIGN KEY(FOODNUM) REFERENCES FOOD(FOODNUM)
);     

--���� ���̺� �����͸� �߰��غ���
SELECT * FROM BOOKING;

INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'ȫ����','010-2222-3333',101,SYSDATE);--OK
--ORA-00001: ���Ἲ ���� ����(ANGEL.UQ_BHP)�� ����˴ϴ�
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'��ȣ��','010-2222-3333',101,SYSDATE);--�����߻�

--���÷κ��� 7�� �� ����
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'�̿���','010-3434-8899',301,SYSDATE+7);--OK

--���� �޴� �ֹ��� ���� �߻�
--ORA-02291: ���Ἲ ��������(ANGEL.FK_FOODNUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'������','010-3434-4545',500,SYSDATE+3);--�����߻�

INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'������','010-3434-4545',201,SYSDATE+3);--OK

INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'�չ̳�','010-3434-1234',100,SYSDATE+10);--OK

INSERT INTO BOOKING VALUES (SEQ_FOOD.NEXTVAL,'��ȿ��','010-3434-4321',400,SYSDATE+1);--OK
COMMIT;

--JOIN���� �� ���̺��� �����ؼ� ����Ͻÿ�
--BNUM,BNAME,BHP,FOODNUM,FOODNAME,FOODPRICE,FOODSIZE,BOOKINGDAY(YYYY-MM-DD)
SELECT BNUM,BNAME,BHP,B.FOODNUM,FOODNAME,FOODPRICE,
FOODSIZE,TO_CHAR(BOOKINGDAY,'YYYY-MM-DD') BOOKINGDAY 
FROM FOOD F,BOOKING B 
WHERE F.FOODNUM = B.FOODNUM;

--�ƹ��� �������� ���� FOOD ������ ������ ������?
SELECT
    BNUM,F.FOODNUM,FOODNAME,FOODPRICE,FOODSIZE
FROM FOOD F,BOOKING B
WHERE F.FOODNUM=B.FOODNUM(+) AND BNUM IS NULL;--200,300�޴��� �ƹ��� �ֹ� ����

--FOOD�� 200�� �޴��� ������ �ɱ��?
DELETE FROM FOOD WHERE FOODNUM=200;--�ƹ��� �ֹ��� ����� �����Ƿ� ��������

--FOOD�� 100�� �޴��� ������ �ɱ��?
--ORA-02292: ���Ἲ ��������(ANGEL.FK_FOODNUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
DELETE FROM FOOD WHERE FOODNUM=100; --100�� �޴��� �ֹ��� ���� �����Ƿ� ������ �� ����

--�θ� ���̺��� FOOD�� �����غ���
DROP TABLE FOOD; --�����߻�, �ڽ����̺��� ���� ���� �� �θ� ���̺��� �����ؾ߸� �Ѵ�

--������ ���� �� �� ���̺��� �����ϼ���
DROP TABLE BOOKING;--�ڽ� ���̺� ���� ����
DROP TABLE FOOD;--�ڽ� ���̺� ���� �� �θ� ���̺� ����
DROP SEQUENCE SEQ_FOOD;
-------------------------------------------------------------------------------

