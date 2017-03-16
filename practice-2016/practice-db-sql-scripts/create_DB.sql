----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------
create table ROOMS (
  ID 			number(10)	NOT NULL,
  Short_Description 	varchar2(256) 	NOT NULL,
  Full_Description 	varchar2(1024) 	NOT NULL,
  Persons 		number(10) 	NOT NULL, 
  Number_Of_Rooms 	number(10) 	NOT NULL, 
  Price 		number(10,4) 	NOT NULL, 
  Is_Booked 		number(1) 	default 0 NOT NULL,
  Is_Shown 		number(1) 	default 1 NOT NULL,
  Has_Breakfast 	number(1) 	default 1 NOT NULL,
  Url_Photo1 		varchar2(256) 	NOT NULL,
  Url_Photo2 		varchar2(256),
  Url_Photo3 		varchar2(256),
  Rating_Position 	number(10) 	default 4 NOT NULL, 
  Rating_Comfort 	number(10) 	default 4 NOT NULL, 
  Rating_Price 		number(10) 	default 4 NOT NULL, 
  Rating_Quality 	number(10) 	default 4 NOT NULL, 
  Rating_Avg 		number(10) 	default 4 NOT NULL, 

  constraint ID_Room Primary key (ID)
);

COMMENT ON COLUMN ROOMS.ID IS 'Primary key. Number of the room';
COMMENT ON COLUMN ROOMS.Short_Description IS 'Short description for the list of room';
COMMENT ON COLUMN ROOMS.Full_Description IS 'Full description for the detailed information of the room';
COMMENT ON COLUMN ROOMS.Persons IS 'Maximal number of persons which can live in the room';
COMMENT ON COLUMN ROOMS.Number_Of_Rooms IS 'Number of room in the room';
COMMENT ON COLUMN ROOMS.Price IS 'Price of the room on the current date';
COMMENT ON COLUMN ROOMS.Is_Booked IS 'Is room booked now';
COMMENT ON COLUMN ROOMS.Is_Shown IS 'Is room shown now for guests';
COMMENT ON COLUMN ROOMS.Has_Breakfast IS 'Is breakfast included for this room';
COMMENT ON COLUMN ROOMS.Url_Photo1 IS 'URL for the first photo of the room';
COMMENT ON COLUMN ROOMS.Url_Photo2 IS 'URL for the second photo of the room';
COMMENT ON COLUMN ROOMS.Url_Photo3 IS 'URL for the third photo of the room';
COMMENT ON COLUMN ROOMS.Rating_Position IS 'Rating of the room position';
COMMENT ON COLUMN ROOMS.Rating_Comfort IS 'Rating of the room comfort';
COMMENT ON COLUMN ROOMS.Rating_Price IS 'Rating of the room price';
COMMENT ON COLUMN ROOMS.Rating_Quality IS 'Rating of the room quality';
COMMENT ON COLUMN ROOMS.Rating_Avg IS 'Avarage rating by position, comfort, price, quality';

CREATE SEQUENCE ROOM_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

create table FACILITIES (
  ID			number(10)	NOT NULL, 
  Name 			varchar2(64) 	NOT NULL, 
  Description 		varchar2(256),
  constraint ID_Facility Primary key (ID)
);

COMMENT ON COLUMN FACILITIES.ID IS 'Primary key';
COMMENT ON COLUMN FACILITIES.Name IS 'Name of the facility';

CREATE SEQUENCE FACILITY_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

create table ROOM_FACILITIES (
  ID 			number(10)	NOT NULL, 
  Room_ID 		number(10)	NOT NULL, 
  Facility_ID 		number(10)	NOT NULL, 

  constraint ID_Facility_Room Primary key (ID),
  constraint OOM_FACILITY_FK_1 FOREIGN KEY (Room_ID) REFERENCES ROOMS (ID),
  constraint OOM_FACILITY_FK_2 FOREIGN KEY (Facility_ID) REFERENCES FACILITIES (ID)
); 

COMMENT ON COLUMN ROOM_FACILITIES.ID IS 'Primary key';
COMMENT ON COLUMN ROOM_FACILITIES.Room_ID IS 'Foreign key from ROOMS table';
COMMENT ON COLUMN ROOM_FACILITIES.Facility_ID IS 'Foreign key from FACILITIES table';

CREATE SEQUENCE ROOM_FACILITY_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ORDERS_STATUS (
  ID 		NUMBER(10) 	NOT NULL PRIMARY KEY,
  NAME 		VARCHAR2(64) 	NOT NULL,
  DESCRIPTION 	VARCHAR2(256) 	NOT NULL
);


COMMENT ON TABLE ORDERS_STATUS IS 'Table status of the orders';
COMMENT ON COLUMN ORDERS_STATUS.ID IS 'Primary key. Number of the status';
COMMENT ON COLUMN ORDERS_STATUS.NAME IS 'Name of the status';
COMMENT ON COLUMN ORDERS_STATUS.DESCRIPTION IS 'Description for the status';

CREATE SEQUENCE ORDERS_STATUS_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ORDERS (
  ID 			NUMBER(10) 	NOT NULL PRIMARY KEY,
  DATE_CHECK_IN 	DATE 		NOT NULL,
  DATE_CHECK_OUT 	DATE 		NOT NULL,
  GREETING_NAME 	VARCHAR2(256) 	NOT NULL,
  MAIL 			VARCHAR2(256) 	NOT NULL,
  PHONE 		VARCHAR2(32) 	NOT NULL,
  COUNT_ADULTS 		NUMBER(2) 	NOT NULL,
  COUNT_CHILDREN 	NUMBER(2)  	NOT NULL,
  ORDER_STATUS_ID NUMBER(10) 	NOT NULL,
  ROOM_ID 		NUMBER(10) 	NOT NULL,

  CONSTRAINT ORDER_FK_1 FOREIGN KEY (ROOM_ID) REFERENCES ROOMS(ID),
  CONSTRAINT ORDER_FK_2 FOREIGN KEY (ORDER_STATUS_ID) REFERENCES ORDERS_STATUS(ID)
);


COMMENT ON TABLE ORDERS IS 'Table orders';
COMMENT ON COLUMN ORDERS.ID IS 'Primary key. Number of the order';
COMMENT ON COLUMN ORDERS.DATE_CHECK_IN IS 'Check in date';
COMMENT ON COLUMN ORDERS.DATE_CHECK_OUT IS 'Check out date';
COMMENT ON COLUMN ORDERS.GREETING_NAME IS 'Guest name for greetings';
COMMENT ON COLUMN ORDERS.MAIL IS 'Guest email';
COMMENT ON COLUMN ORDERS.PHONE IS 'Guest phone number';
COMMENT ON COLUMN ORDERS.COUNT_ADULTS IS 'Count of adult guests';
COMMENT ON COLUMN ORDERS.COUNT_CHILDREN IS 'Count of child guests';
COMMENT ON COLUMN ORDERS.ORDER_STATUS_ID IS 'Foreign key from ORDER_STATUS table';
COMMENT ON COLUMN ORDERS.ROOM_ID IS 'Foreign key from ROOMS table';

CREATE SEQUENCE ORDERS_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ROOMS_COMMENTS ( 
  ID 			NUMBER(10) 	NOT NULL PRIMARY KEY,
  room_ID 		NUMBER(10) 	NOT NULL, 
  date_comment 		DATE 		NOT NULL, 
  first_name 		VARCHAR2(128) 	NOT NULL, 
  second_name 		VARCHAR2(128)  	NOT NULL, 
  email 		VARCHAR2(128) 	NOT NULL, 
  phone 		VARCHAR2(32) 	NOT NULL,
  rating_1 		NUMBER(5,2) 	DEFAULT 0 NOT NULL,
  rating_2 		NUMBER(5,2) 	DEFAULT 0 NOT NULL,
  rating_3 		NUMBER(5,2) 	DEFAULT 0 NOT NULL,
  rating_4 		NUMBER(5,2) 	DEFAULT 0 NOT NULL,
  room_comment 		CLOB 		NOT NULL, 
  comment_visible 	NUMBER(1) 	DEFAULT 0 NOT NULL,
                    
  CONSTRAINT ROOMS_COMMENT_FK_1 FOREIGN KEY (ROOM_ID) REFERENCES ROOMS(ID) 
);

COMMENT ON TABLE ROOMS_COMMENTS IS 'Table comments room';
COMMENT ON COLUMN ROOMS_COMMENTS.ID IS 'ID comment';
COMMENT ON COLUMN ROOMS_COMMENTS.Room_ID IS 'ID room';
COMMENT ON COLUMN ROOMS_COMMENTS.Date_Comment IS 'Date pushing comment';
COMMENT ON COLUMN ROOMS_COMMENTS.First_Name IS 'First name pushing comment';
COMMENT ON COLUMN ROOMS_COMMENTS.Second_Name IS 'Second name pushing comment';
COMMENT ON COLUMN ROOMS_COMMENTS.Email IS 'Email user';
COMMENT ON COLUMN ROOMS_COMMENTS.Phone IS 'Phone user';
COMMENT ON COLUMN ROOMS_COMMENTS.Rating_1 IS 'Raiting comment 1, 1-5';
COMMENT ON COLUMN ROOMS_COMMENTS.Rating_2 IS 'Raiting comment 2, 1-5';
COMMENT ON COLUMN ROOMS_COMMENTS.Rating_3 IS 'Raiting comment 3, 1-5';
COMMENT ON COLUMN ROOMS_COMMENTS.Rating_4 IS 'Raiting comment 4, 1-5';
COMMENT ON COLUMN ROOMS_COMMENTS.Room_Comment IS 'Comment about the room';
COMMENT ON COLUMN ROOMS_COMMENTS.Comment_Visible IS 'Visible comment(moderation, default 0 = unvisible, 1 = visible)';

CREATE SEQUENCE COMMENT_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE STATS(
  ID 			NUMBER(10) 	NOT NULL PRIMARY KEY,
  WORK_DAY 		DATE 		NOT NULL,
  ADULTS_NUMBER 	NUMBER(10),
  CHILDREN_NUMBER 	NUMBER(10),
  OCCUPIED_ROOMS_ONE 	NUMBER(10),
  OCCUPIED_ROOMS_TWO 	NUMBER(10),
  OCCUPIED_ROOMS_THREE 	NUMBER(10),
  OCCUPIED_ROOMS_FOUR 	NUMBER(10),
  OCCUPIED_ROOMS_FIVE 	NUMBER(10)
);

COMMENT ON TABLE STATS IS 'Таблица статистики нагрузки по дням';
COMMENT ON COLUMN STATS.ID IS 'ID дня';
COMMENT ON COLUMN STATS.WORK_DAY IS 'Дата';
COMMENT ON COLUMN STATS.ADULTS_NUMBER IS 'Количество заселенных взрослых';
COMMENT ON COLUMN STATS.CHILDREN_NUMBER IS 'Количество заселенных детей';
COMMENT ON COLUMN STATS.OCCUPIED_ROOMS_ONE IS 'Количество занятых однокомнатных номеров';
COMMENT ON COLUMN STATS.OCCUPIED_ROOMS_TWO IS 'Количество занятых двухкомнатных номеров';
COMMENT ON COLUMN STATS.OCCUPIED_ROOMS_THREE IS 'Количество занятых трехкомнатных номеров';
COMMENT ON COLUMN STATS.OCCUPIED_ROOMS_FOUR IS 'Количество занятых четырехкомнатных номеров';
COMMENT ON COLUMN STATS.OCCUPIED_ROOMS_FIVE IS 'Количество занятых пятикомнатных номеров';

CREATE SEQUENCE STATS_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

create table ROOM_PRICE_TYPES (
  ID 		NUMBER(10) 	NOT NULL PRIMARY KEY,
  NAME 		VARCHAR2(64) 	NOT NULL,
  DESCRIPTION 	VARCHAR2(256) 	NOT NULL
);

COMMENT ON COLUMN ROOM_PRICE_TYPES.ID IS 'Primary key';
COMMENT ON COLUMN ROOM_PRICE_TYPES.NAME IS 'Name low, middle, hight';
COMMENT ON COLUMN ROOM_PRICE_TYPES.DESCRIPTION IS 'General description about type';

CREATE SEQUENCE ROOM_PRICE_TYPES_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

create table ROOM_PRICES (
  ID 			NUMBER(10) 	NOT NULL PRIMARY KEY,
  Room_ID 		number(10),
  Price_Type_ID 	number(10) 	NOT NULL,
  Start_Date 		date 		NOT NULL, 
  End_Date 		date 		NOT NULL,
  Price 		number(10) 	NOT NULL, 

  constraint ROOM_PRICE_FK_1 FOREIGN KEY (Room_ID) REFERENCES ROOMS (ID),
  constraint ROOM_PRICE_FK_2 FOREIGN KEY (Price_Type_ID) REFERENCES ROOM_PRICE_TYPES (ID)
);

COMMENT ON COLUMN ROOM_PRICES.ID IS 'Primary key';
COMMENT ON COLUMN ROOM_PRICES.Room_ID IS 'Foreign key from ROOMS table';
COMMENT ON COLUMN ROOM_PRICES.Price_Type_ID IS 'Price type identifier. 1 - Low, 2 - Middle, 3 - High';
COMMENT ON COLUMN ROOM_PRICES.Start_Date IS 'Start date for this type of price';
COMMENT ON COLUMN ROOM_PRICES.End_Date IS 'End date for this type of price';
COMMENT ON COLUMN ROOM_PRICES.Price IS 'Price of the room';

CREATE SEQUENCE ROOM_PRICE_ID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------



