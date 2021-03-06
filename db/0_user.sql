@0_parameters.sql

CREATE TABLESPACE &ts_data
DATAFILE
  &file_ts_data_01 SIZE 10M reuse AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
	LOGGING
	ONLINE
	PERMANENT
	EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	SEGMENT SPACE MANAGEMENT AUTO;

CREATE TABLESPACE &ts_index
DATAFILE
  &file_ts_index SIZE 10M reuse AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
	LOGGING
	ONLINE
	PERMANENT
	EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	SEGMENT SPACE MANAGEMENT AUTO;


CREATE TABLESPACE &ts_lob
DATAFILE
  &file_ts_lob SIZE 10M reuse AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
	LOGGING
	ONLINE
	PERMANENT
	EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	SEGMENT SPACE MANAGEMENT AUTO;

CREATE TABLESPACE &ts_log
DATAFILE
  &file_ts_log SIZE 10M reuse AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
	LOGGING
	ONLINE
	PERMANENT
	EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	SEGMENT SPACE MANAGEMENT AUTO;

CREATE TABLESPACE &ts_log_lob
DATAFILE
  &file_ts_log_lob SIZE 10M reuse AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
	LOGGING
	ONLINE
	PERMANENT
	EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	SEGMENT SPACE MANAGEMENT AUTO;

CREATE USER CARGO PROFILE DEFAULT IDENTIFIED BY cargo DEFAULT TABLESPACE &ts_data ACCOUNT UNLOCK;

GRANT CONNECT TO CARGO;

ALTER USER CARGO QUOTA 0 ON SYSTEM;

GRANT CREATE SESSION to CARGO;

GRANT CREATE PROCEDURE  to CARGO;

GRANT CREATE SEQUENCE  to CARGO;

GRANT CREATE TABLE to CARGO;

GRANT CREATE TYPE  to CARGO;

GRANT CREATE VIEW to CARGO;

GRANT CREATE TRIGGER to CARGO;

GRANT CREATE PUBLIC SYNONYM TO CARGO;

ALTER USER CARGO QUOTA UNLIMITED ON &ts_index;

ALTER USER CARGO QUOTA UNLIMITED ON &ts_data;

ALTER USER CARGO QUOTA UNLIMITED ON &ts_lob;

ALTER USER CARGO QUOTA UNLIMITED ON &ts_log;

ALTER USER CARGO QUOTA UNLIMITED ON &ts_log_lob;

COMMIT;
QUIT;