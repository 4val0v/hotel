CREATE TABLE `ROOMS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SHORT_DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `FULL_DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `PERSONS` int(11) NOT NULL,
  `NUMBER_OF_ROOMS` int(11) NOT NULL,
  `PRICE` bigint(20) NOT NULL,
  `IS_BOOKED` tinyint(1) NOT NULL DEFAULT '0',
  `IS_SHOWN` tinyint(1) NOT NULL DEFAULT '1',
  `HAS_BREAKFAST` tinyint(1) NOT NULL DEFAULT '1',
  `URL_PHOTO1` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `URL_PHOTO2` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `URL_PHOTO3` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RATING_POSITION` double NOT NULL DEFAULT '4',
  `RATING_COMFORT` double NOT NULL DEFAULT '4',
  `RATING_PRICE` double NOT NULL DEFAULT '4',
  `RATING_QUALITY` double NOT NULL DEFAULT '4',
  `RATING_AVG` double NOT NULL DEFAULT '4',
  `NAME` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `FACILITIES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ROOM_FACILITIES` (
  `ROOM_ID` int(11) NOT NULL,
  `FACILITY_ID` int(11) NOT NULL,
  KEY `ROOM_ID` (`ROOM_ID`),
  CONSTRAINT `ROOM_FACILITIES_ibfk_1` FOREIGN KEY (`ROOM_ID`) REFERENCES `ROOMS` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ORDERS_STATUS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `ORDERS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_CHECK_IN` date NOT NULL,
  `DATE_CHECK_OUT` date NOT NULL,
  `GREETING_NAME` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `MAIL` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `COUNT_ADULTS` smallint(6) NOT NULL,
  `COUNT_CHILDREN` smallint(6) NOT NULL,
  `ORDER_STATUS_ID` bigint(20) NOT NULL,
  `ROOM_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ROOM_ID` (`ROOM_ID`),
  KEY `ORDER_STATUS_ID` (`ORDER_STATUS_ID`),
  CONSTRAINT `ORDERS_ibfk_1` FOREIGN KEY (`ROOM_ID`) REFERENCES `ROOMS` (`ID`),
  CONSTRAINT `ORDERS_ibfk_2` FOREIGN KEY (`ORDER_STATUS_ID`) REFERENCES `ORDERS_STATUS` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `FEEDBACK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `THEME` varchar(35) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MESSAGE` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `ROOM_PRICE_TYPES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ROOM_PRICES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROOM_ID` int(11) NOT NULL,
  `PRICE_TYPE_ID` int(11) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `PRICE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ROOM_ID` (`ROOM_ID`),
  KEY `PRICE_TYPE_ID` (`PRICE_TYPE_ID`),
  CONSTRAINT `ROOM_PRICES_ibfk_1` FOREIGN KEY (`ROOM_ID`) REFERENCES `ROOMS` (`ID`),
  CONSTRAINT `ROOM_PRICES_ibfk_2` FOREIGN KEY (`PRICE_TYPE_ID`) REFERENCES `ROOM_PRICE_TYPES` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ROOMS_COMMENTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROOM_ID` int(11) NOT NULL,
  `DATE_COMMENT` date NOT NULL,
  `FIRST_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `SECOND_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `EMAIL` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `RATING_1` double NOT NULL DEFAULT '0',
  `RATING_2` double NOT NULL DEFAULT '0',
  `RATING_3` double NOT NULL DEFAULT '0',
  `RATING_4` double NOT NULL DEFAULT '0',
  `ROOM_COMMENT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `COMMENT_VISIBLE` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `STATS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `WORK_DAY` date NOT NULL,
  `ADULTS_NUMBER` int(11) DEFAULT NULL,
  `CHILDREN_NUMBER` int(11) DEFAULT NULL,
  `OCCUPIED_ROOMS_ONE` int(11) DEFAULT NULL,
  `OCCUPIED_ROOMS_TWO` int(11) DEFAULT NULL,
  `OCCUPIED_ROOMS_THREE` int(11) DEFAULT NULL,
  `OCCUPIED_ROOMS_FOUR` int(11) DEFAULT NULL,
  `OCCUPIED_ROOMS_FIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `EMAIL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ROLES` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `USERS` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `PASSWORD` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `IS_LOCKED` tinyint(1) DEFAULT '0',
  `CREATED` date DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `USER_ROLES` (
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `USER_ROLES_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`USER_ID`),
  CONSTRAINT `USER_ROLES_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `LOG_TYPES` (
  `LOG_TYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`LOG_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `LOGS` (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `LOG_TYPE_ID` bigint(20) NOT NULL,
  `LOG_TIME` date DEFAULT NULL,
  `MESSAGE` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `LOG_TYPE_ID` (`LOG_TYPE_ID`),
  CONSTRAINT `LOGS_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`USER_ID`),
  CONSTRAINT `LOGS_ibfk_2` FOREIGN KEY (`LOG_TYPE_ID`) REFERENCES `LOG_TYPES` (`LOG_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
