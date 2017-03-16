-- Пример именования скриптов изменения БД 
insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Good room on the first floor with video',
'Good room on the first floor with video. All people are happy to live there', 2, 1, 105, 0, 1, 1,
'URL1', 'URL2', 'URL3', 4, 4, 4, 4, 4);
insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Room with hollidays atmosphere',
'Room with hollidays atmosphere. Funny to live there', 5, 2, 319, 1, 1, 0,
'URL4', 'URL5', 'URL6', 4, 4, 4, 4, 4);
insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL7', 'URL8', 'URL9', 4, 4, 4, 4, 4);

insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Coffee machine');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Cardkey');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'DVD player');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Wifi');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Hairdryer');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Air-conditioning');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'SAFEBOX');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Towels');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'TV');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'Oven');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'WC');
insert into FACILITIES values (FACILITY_ID_SEQ.nextval, 'BADKINGSIZE');

insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 1, 3);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 2, 8);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 2, 10);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 2, 12);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 1);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 2);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 3);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 4);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 5);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 6);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 7);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 8);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 9);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 10);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 11);
insert into ROOMS_FACILITIES values (ROOM_FACILITY_ID_SEQ.nextval, 3, 12);

insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 1, 1, TO_DATE('2016/09/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/12/20 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 105);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 1, 3, TO_DATE('2016/12/21 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/01/10 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 145);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 1, 2, TO_DATE('2017/01/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/06/01 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 122);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 1, 3, TO_DATE('2017/06/02 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/09/04 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 145);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 2, 1, TO_DATE('2016/09/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/12/20 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 319);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 2, 3, TO_DATE('2016/12/21 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/01/10 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 370);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 2, 2, TO_DATE('2017/01/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/06/01 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 347);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 2, 3, TO_DATE('2017/06/02 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/09/04 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 370);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 3, 1, TO_DATE('2016/09/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/12/20 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 690);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 3, 3, TO_DATE('2016/12/21 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/01/10 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 954);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 3, 2, TO_DATE('2017/01/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/06/01 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 760);
insert into ROOM_PRICES values (ROOM_PRICE_ID_SEQ.nextval, 3, 3, TO_DATE('2017/06/02 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2017/09/04 23:59:59', 'yyyy/mm/dd hh24:mi:ss'), 954);

INSERT INTO ORDERS_STATUS VALUES (ORDERS_STATUS_SEQ.NEXTVAL, 'ORDERED', 'For current orders');
INSERT INTO ORDERS_STATUS VALUES (ORDERS_STATUS_SEQ.NEXTVAL, 'HOLD', 'For hold orders');
INSERT INTO ORDERS_STATUS VALUES (ORDERS_STATUS_SEQ.NEXTVAL, 'CLOSED', 'For closed orders');

INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL,TO_DATE('2016/11/25', 'yyyy/mm/dd') , TO_DATE('2016/11/30', 'yyyy/mm/dd'), 'Ted Merphi',
'merphi@mail.com', '+4238173401', 3, 1, 2, 1);
INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL, TO_DATE('2016/11/24', 'yyyy/mm/dd'), TO_DATE('2016/11/29', 'yyyy/mm/dd'), 'Mark Okon',
'mark@mail.com', '+6238177401', 1, 0, 3, 2);
INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL, TO_DATE('2016/11/24 00:00:00', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/12/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss'),
'Obivan Cenobi','cenobi@mail.com', '+1277401', 1, 0, 3, 12);
INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL, TO_DATE('2016/11/24', 'yyyy/mm/dd'), TO_DATE('2016/12/01', 'yyyy/mm/dd'),
'Obivan Cenobi','cenobi@mail.com', '+1277401', 1, 0, 3, 12);
INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL, TO_DATE('2016/12/02', 'yyyy/mm/dd'), TO_DATE('2016/12/08', 'yyyy/mm/dd'),
'Tom Pitkin','pitkin@mail.com', '+1274501', 1, 0, 2, 12);
INSERT INTO ORDERS VALUES (ORDERS_SEQ.NEXTVAL,TO_DATE('2017/01/25', 'yyyy/mm/dd') , TO_DATE('2017/02/08', 'yyyy/mm/dd'), 'Maya Frain',
'frain@mail.com', '+4238101', 1, 0, 3, 12);


CREATE TABLE FEEDBACK (
  ID NUMBER(10) NOT NULL PRIMARY KEY,
  THEME VARCHAR2(35),
  MESSAGE VARCHAR2(500)
);

COMMENT ON COLUMN FEEDBACK.ID IS 'Primary key';
COMMENT ON COLUMN FEEDBACK.THEME IS 'theme of the message';
COMMENT ON COLUMN FEEDBACK.MESSAGE IS 'message';

CREATE SEQUENCE FEEDBACK_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

INSERT INTO FEEDBACK VALUES (FEEDBACK_ID_SEQ.nextval, 'good service', 'everything was perfect!');
INSERT INTO FEEDBACK VALUES (FEEDBACK_ID_SEQ.nextval, 'pool', 'dirty water. fix, please');
INSERT INTO FEEDBACK VALUES (FEEDBACK_ID_SEQ.nextval, 'bar', 'nice bar and lounge');
INSERT INTO FEEDBACK VALUES (FEEDBACK_ID_SEQ.nextval, 'restaurant', 'why there is no vegetarian food in menu?');

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL7', 'URL8', 'URL9', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL10', 'URL11', 'URL12', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL13', 'URL14', 'URL15', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL16', 'URL17', 'URL18', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL19', 'URL20', 'URL21', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL22', 'URL23', 'URL24', 4, 4, 4, 4, 4);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL25', 'URL26', 'URL27', 4, 4, 4, 4, 4);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL28', 'URL29', 'URL30', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL31', 'URL32', 'URL33', 4, 4, 4, 4, 5);

insert into ROOMS values (ROOM_ID_SEQ.nextval, 'Best room for business people',
'Best room for business people. All things are for you here', 1, 2, 690, 0, 1, 1,
'URL34', 'URL35', 'URL36', 4, 4, 4, 4, 5);

ALTER TABLE PRACTICE_ADMIN.ROOMS ADD NAME VARCHAR2(20) DEFAULT '' NOT NULL;

CREATE TABLE EMAIL (
ID NUMBER(10) NOT NULL PRIMARY KEY,
EMAIL_ADDRESS VARCHAR(50)
);

COMMENT ON COLUMN EMAIL.ID IS 'Primary key';
COMMENT ON COLUMN EMAIL.EMAIL_ADDRESS IS 'Email';

CREATE SEQUENCE EMAIL_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;
