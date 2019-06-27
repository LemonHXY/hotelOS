/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/25 10:38:04                           */
/*==============================================================*/
DROP DATABASE IF EXISTS hos;
CREATE DATABASE hos;
USE hos;

DROP TABLE IF EXISTS city;

DROP TABLE IF EXISTS guest;

DROP TABLE IF EXISTS hotel;

DROP TABLE IF EXISTS manager;

DROP TABLE IF EXISTS r_img;

DROP TABLE IF EXISTS r_order;

DROP TABLE IF EXISTS room;

DROP TABLE IF EXISTS room_quantity;

DROP TABLE IF EXISTS user;

/*==============================================================*/
/* Table: city                                                  */
/*==============================================================*/
CREATE TABLE city
(
  city_id INT         NOT NULL,
  city    VARCHAR(20) NOT NULL,
  PRIMARY KEY (city_id)
);

/*==============================================================*/
/* Table: guest                                                 */
/*==============================================================*/
CREATE TABLE guest
(
  g_id    INT         NOT NULL,
  u_id    INT         NOT NULL,
  g_name  VARCHAR(16) NOT NULL,
  g_phone VARCHAR(16) NOT NULL,
  PRIMARY KEY (g_id)
);
/*==============================================================*/
/* Table: hotel                                                 */
/*==============================================================*/
CREATE TABLE hotel
(
  hotel_id       INT           NOT NULL,
  city_id        INT,
  hotel_name     VARCHAR(128)  NOT NULL,
  addressline    VARCHAR(128)  NOT NULL,
  photo1         VARCHAR(256),
  photo2         VARCHAR(256),
  photo3         VARCHAR(256),
  photo4         VARCHAR(256),
  photo5         VARCHAR(256),
  star_rating    DECIMAL(2, 1) NOT NULL,
  checkin        TIME,
  checkout       TIME,
  longitude      DOUBLE        NOT NULL,
  latitude       DOUBLE        NOT NULL,
  overview       TEXT          NOT NULL,
  rates_from     INT           NOT NULL,
  rating_average DECIMAL(3, 1),
  PRIMARY KEY (hotel_id)
);
/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
CREATE TABLE manager
(
  m_id       VARCHAR(20) NOT NULL,
  m_password VARCHAR(20) NOT NULL,
  PRIMARY KEY (m_id)
);
/*==============================================================*/
/* Table: r_img                                                 */
/*==============================================================*/
CREATE TABLE r_img
(
  room_img_id INT          NOT NULL,
  room_id     INT,
  img         VARCHAR(128) NOT NULL,
  PRIMARY KEY (room_img_id)
);
/*==============================================================*/
/* Table: r_order                                               */
/*==============================================================*/
CREATE TABLE r_order
(
  o_id        INT         NOT NULL,
  u_id        INT         NOT NULL,
  room_id     INT         NOT NULL,
  o_time      DATETIME    NOT NULL,
  arr_date    DATE        NOT NULL,
  dep_date    DATE        NOT NULL,
  quantity    INT         NOT NULL,
  total_price INT         NOT NULL,
  g_name      VARCHAR(20) NOT NULL,
  g_phone     VARCHAR(16) NOT NULL,
  o_status    VARCHAR(10) NOT NULL,
  PRIMARY KEY (o_id)
);
/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
CREATE TABLE room
(
  room_id   INT         NOT NULL,
  hotel_id  INT,
  room_type VARCHAR(30) NOT NULL,
  breakfast VARCHAR(10) NOT NULL,
  price     INT         NOT NULL,
  amout     INT         NOT NULL,
  PRIMARY KEY (room_id)
);
/*==============================================================*/
/* Table: room_quantity                                         */
/*==============================================================*/
CREATE TABLE room_quantity
(
  room_id INT  NOT NULL,
  r_date  DATE NOT NULL,
  remain  INT  NOT NULL,
  PRIMARY KEY (room_id, r_date)
);
/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE user
(
  u_id       INT         NOT NULL,
  u_name     VARCHAR(20) NOT NULL,
  u_password CHAR(20)    NOT NULL,
  PRIMARY KEY (u_id)
);

ALTER TABLE user
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE room_quantity
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE room
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE r_order
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE r_img
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE manager
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE hotel
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE city
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE guest
  CONVERT TO CHARACTER SET utf8;

ALTER TABLE guest
  ADD CONSTRAINT FK_u_g FOREIGN KEY (u_id)
REFERENCES user (u_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE hotel
  ADD CONSTRAINT FK_c_h FOREIGN KEY (city_id)
REFERENCES city (city_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE r_img
  ADD CONSTRAINT FK_r_img FOREIGN KEY (room_id)
REFERENCES room (room_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE r_order
  ADD CONSTRAINT FK_r_o FOREIGN KEY (room_id)
REFERENCES room (room_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE r_order
  ADD CONSTRAINT FK_u_o FOREIGN KEY (u_id)
REFERENCES user (u_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE room
  ADD CONSTRAINT FK_h_r FOREIGN KEY (hotel_id)
REFERENCES hotel (hotel_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE room_quantity
  ADD CONSTRAINT FK_r_rq FOREIGN KEY (room_id)
REFERENCES room (room_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

