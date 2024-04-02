-- 계정 생성(system에서만 가능) : 실행은 ctrl+enger
create user angel identified by a1234; --오류 발생
-- 최신버전에서는 앞에 공통문자 c##을 붙여서 계정생성을 해야만 한다
create user c##angel identified by a1234;
-- system 계정에 생성된 계정 확인하기
select username from dba_users;
-- c##angel 계정 삭제하기
drop user c##angel;
-- c## 공통문자를 안붙이고 계정생성을 하려면 세션변경을 해야만 한다
alter session set "_ORACLE_SCRIPT"=true;
-- angel 계정을 생성해보자(비번은 a1234)
create user angel identified by a1234;
