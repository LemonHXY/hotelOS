/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/25 10:38:04                           */
/*==============================================================*/
drop database if exists hos;
create database hos;
use  hos;

drop table if exists city;

drop table if exists guest;

drop table if exists hotel;

drop table if exists manager;

drop table if exists r_img;

drop table if exists r_order;

drop table if exists room;

drop table if exists room_quantity;

drop table if exists user;

/*==============================================================*/
/* Table: city                                                  */
/*==============================================================*/
create table city
(
   city_id              int not null,
   city                 varchar(20) not null,
   primary key (city_id)
);

/*==============================================================*/
/* Table: guest                                                 */
/*==============================================================*/
create table guest
(
   g_id                 int not null,
   u_id                 varchar(20) not null,
   g_name               varchar(16) not null,
   g_phone              varchar(16) not null,
   primary key (g_id)
);

/*==============================================================*/
/* Table: hotel                                                 */
/*==============================================================*/
create table hotel
(
   hotel_id             int not null,
   city_id              int,
   hotel_name           varchar(128) not null,
   addressline          varchar(128) not null,
   photo1               varchar(256),
   photo2               varchar(256),
   photo3               varchar(256),
   photo4               varchar(256),
   photo5               varchar(256),
   star_rating          decimal(2,1) not null,
   checkin              time,
   checkout             time,
   longitude            double not null,
   latitude             double not null,
   overview             text not null,
   rates_from           int not null,
   rating_average       decimal(3,1),
   primary key (hotel_id)
);

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager
(
   m_id                 varchar(20) not null,
   m_password           varchar(20) not null,
   primary key (m_id)
);

/*==============================================================*/
/* Table: r_img                                                 */
/*==============================================================*/
create table r_img
(
   room_img_id          int not null,
   room_id              int,
   img                  varchar(128) not null,
   primary key (room_img_id)
);

/*==============================================================*/
/* Table: r_order                                               */
/*==============================================================*/
create table r_order
(
   o_id                 int not null,
   u_id                 varchar(20),
   room_id              int,
   o_time               datetime not null,
   arr_date             date not null,
   dep_date             date not null,
   quantity             int not null,
   total_price          int not null,
   g_name               varchar(20) not null,
   g_phone              varchar(16) not null,
   o_status             varchar(10) not null,
   primary key (o_id)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   room_id              int not null,
   hotel_id             int,
   room_type            varchar(30) not null,
   breakfast            varchar(10) not null,
   price                int not null,
   amout                int not null,
   primary key (room_id)
);

/*==============================================================*/
/* Table: room_quantity                                         */
/*==============================================================*/
create table room_quantity
(
   room_id              int not null,
   r_date                 date not null,
   remain               int not null,
   primary key (room_id, r_date)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   u_id                 varchar(20) not null,
   u_name               varchar(20) not null,
   u_password             char(20) not null,
   primary key (u_id)
);

alter table guest add constraint FK_u_g foreign key (u_id)
      references user (u_id) on delete restrict on update restrict;

alter table hotel add constraint FK_c_h foreign key (city_id)
      references city (city_id) on delete restrict on update restrict;

alter table r_img add constraint FK_r_img foreign key (room_id)
      references room (room_id) on delete restrict on update restrict;

alter table r_order add constraint FK_r_o foreign key (room_id)
      references room (room_id) on delete restrict on update restrict;

alter table r_order add constraint FK_u_o foreign key (u_id)
      references user (u_id) on delete restrict on update restrict;

alter table room add constraint FK_h_r foreign key (hotel_id)
      references hotel (hotel_id) on delete restrict on update restrict;

alter table room_quantity add constraint FK_r_rq foreign key (room_id)
      references room (room_id) on delete restrict on update restrict;

