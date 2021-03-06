CREATE SEQUENCE  "ADDRESS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "AUCTION_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "CARGO_USER_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "CARRIER_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "COMPANY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "CONTACT_INFO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "FIRM_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "LOAD_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "USER_ROLE_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
commit;

CREATE TABLE "ADDRESS" 
(
"ID" NUMBER(20,0), 
"NUMBER" VARCHAR2(10 CHAR), 
"STREET" VARCHAR2(100 CHAR),  
"CITY" VARCHAR2(50 CHAR),
"COUNTRY" VARCHAR2(50 CHAR),
"COUNTRY_CODE" VARCHAR2(10 CHAR)
);

CREATE TABLE "AUCTION" 
(
"ID" NUMBER(20,0), 
"AUCTION_NUMBER" VARCHAR2(20 CHAR),
"AUCTION_NAME" VARCHAR2(30 CHAR),
"DESCRIPTION" VARCHAR2(100 CHAR),
"PRICE" NUMBER(14,0), 
"IS_FINISHED" NUMBER(1,0) DEFAULT 0
);

CREATE TABLE "CARGO_USER" 
(
"ID" NUMBER(20,0), 
"USERNAME" VARCHAR2(30 CHAR),
"PASSWORD" VARCHAR2(30 CHAR),
"EMAIL" VARCHAR2(30 CHAR)
);
   
CREATE TABLE "CARRIER" 
(
"ID" NUMBER(20,0), 
"CARRIER_NAME" VARCHAR2(30 CHAR)
);

CREATE TABLE "COMPANY" 
(
"ID" NUMBER(20,0), 
"COMPANY_NAME" VARCHAR2(30 CHAR)
);

CREATE TABLE "CONTACT_INFO" 
(
"ID" NUMBER(20,0), 
"EMAIL" VARCHAR2(30 CHAR),
"MOBILE_PHONE" VARCHAR2(30 CHAR)
);

CREATE TABLE "FIRM" 
(
"ID" NUMBER(20,0), 
"FIRM_NAME" VARCHAR2(30 CHAR)
);

CREATE TABLE "LOAD" 
(
"ID" NUMBER(20,0), 
"LOAD_NAME" VARCHAR2(30 CHAR),
"DESCRIPTION" VARCHAR2(200 CHAR)
);

CREATE TABLE "USER_ROLE" 
(
"ID" NUMBER(20,0), 
"ROLE_NAME" VARCHAR2(30 CHAR),
"DESCRIPTION" VARCHAR2(200 CHAR)
);

commit;

COMMENT ON COLUMN "ADDRESS"."ID"  IS 'row identifier';
COMMENT ON COLUMN "AUCTION"."ID"  IS 'row identifier';
COMMENT ON COLUMN "CARGO_USER"."ID"  IS 'row identifier';
COMMENT ON COLUMN "CARRIER"."ID"  IS 'row identifier';
COMMENT ON COLUMN "COMPANY"."ID"  IS 'row identifier';
COMMENT ON COLUMN "CONTACT_INFO"."ID"  IS 'row identifier';
COMMENT ON COLUMN "FIRM"."ID"  IS 'row identifier';
COMMENT ON COLUMN "LOAD"."ID"  IS 'row identifier';
COMMENT ON COLUMN "USER_ROLE"."ID"  IS 'row identifier';

COMMIT;

--------------------------------------------------------
--   Ref Constraints for Table ADDRESS
-------------------------------------------------------- 
CREATE UNIQUE INDEX "ADDRESS_PK_INDEX" ON "ADDRESS" ("ID");
ALTER TABLE "ADDRESS" ADD (
  CONSTRAINT "ADDRESS_PK" PRIMARY KEY ("ID")
  USING INDEX "ADDRESS_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table AUCTION
-------------------------------------------------------- 
CREATE UNIQUE INDEX "AUCTION_PK_INDEX" ON "AUCTION" ("ID");
ALTER TABLE "AUCTION" ADD (
  CONSTRAINT "AUCTION_PK" PRIMARY KEY ("ID")
  USING INDEX "AUCTION_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table CARGO_USER
-------------------------------------------------------- 
CREATE UNIQUE INDEX "CARGO_USER_PK_INDEX" ON "CARGO_USER" ("ID");
ALTER TABLE "CARGO_USER" ADD (
  CONSTRAINT "CARGO_USER_PK" PRIMARY KEY ("ID")
  USING INDEX "CARGO_USER_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table CARRIER
-------------------------------------------------------- 
CREATE UNIQUE INDEX "CARRIER_PK_INDEX" ON "CARRIER" ("ID");
ALTER TABLE "CARRIER" ADD (
  CONSTRAINT "CARRIER_PK" PRIMARY KEY ("ID")
  USING INDEX "CARRIER_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table COMPANY
-------------------------------------------------------- 
CREATE UNIQUE INDEX "COMPANY_PK_INDEX" ON "COMPANY" ("ID");
ALTER TABLE "COMPANY" ADD (
  CONSTRAINT "COMPANY_PK" PRIMARY KEY ("ID")
  USING INDEX "COMPANY_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table CONTACT_INFO
-------------------------------------------------------- 
CREATE UNIQUE INDEX "CONTACT_INFO_PK_INDEX" ON "CONTACT_INFO" ("ID");
ALTER TABLE "CONTACT_INFO" ADD (
  CONSTRAINT "CONTACT_INFO_PK" PRIMARY KEY ("ID")
  USING INDEX "CONTACT_INFO_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table FIRM
-------------------------------------------------------- 
CREATE UNIQUE INDEX "FIRM_PK_INDEX" ON "FIRM" ("ID");
ALTER TABLE "FIRM" ADD (
  CONSTRAINT "FIRM_PK" PRIMARY KEY ("ID")
  USING INDEX "FIRM_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table LOAD
-------------------------------------------------------- 
CREATE UNIQUE INDEX "LOAD_PK_INDEX" ON "LOAD" ("ID");
ALTER TABLE "LOAD" ADD (
  CONSTRAINT "LOAD_PK" PRIMARY KEY ("ID")
  USING INDEX "LOAD_PK_INDEX"
);

--------------------------------------------------------
--   Ref Constraints for Table USER_ROLE
-------------------------------------------------------- 
CREATE UNIQUE INDEX "USER_ROLE_PK_INDEX" ON "USER_ROLE" ("ID");
ALTER TABLE "USER_ROLE" ADD (
  CONSTRAINT "USER_ROLE_PK" PRIMARY KEY ("ID")
  USING INDEX "USER_ROLE_PK_INDEX"
);
	
COMMIT;

QUIT;
