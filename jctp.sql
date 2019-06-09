/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/25 13:59:34                           */
/*==============================================================*/


<<<<<<< HEAD
drop table if exists jctp_chat_course;

drop table if exists jctp_chat_ts;

drop table if exists jctp_class;

drop table if exists jctp_course;

drop table if exists jctp_course_file;

drop table if exists jctp_course_job;

drop table if exists jctp_permission;

drop table if exists jctp_question_job;

drop table if exists jctp_questions;

drop table if exists jctp_role;

drop table if exists jctp_role_permission;

drop table if exists jctp_students_questions;

drop table if exists jctp_user;
=======
DROP TABLE IF EXISTS jctp_chat_course;

DROP TABLE IF EXISTS jctp_chat_ts;	

DROP TABLE IF EXISTS jctp_class;

DROP TABLE IF EXISTS jctp_course;

DROP TABLE IF EXISTS jctp_course_file;

DROP TABLE IF EXISTS jctp_course_job;

DROP TABLE IF EXISTS jctp_permission;

DROP TABLE IF EXISTS jctp_question_job;

DROP TABLE IF EXISTS jctp_questions;

DROP TABLE IF EXISTS jctp_role;

DROP TABLE IF EXISTS jctp_role_permission;

DROP TABLE IF EXISTS jctp_students_questions;

DROP TABLE IF EXISTS jctp_user;
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0

/*==============================================================*/
/* Table: jctp_chat_course                                      */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_chat_course
(
   id                   int not null auto_increment,
   course_id            int,
   user_id              int,
   msg                  varchar(1000),
   seq                  int,
   date                 datetime,
   primary key (id)
=======
CREATE TABLE jctp_chat_course
(
   id                   INT NOT NULL AUTO_INCREMENT,
   course_id            INT,
   user_id              INT,
   msg                  VARCHAR(1000),
   seq                  INT,
   DATE                 DATETIME,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_chat_ts                                          */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_chat_ts
(
   id                   int not null auto_increment,
   student_id           int,
   teacher_id           int,
   course_id            int,
   student_msg          varchar(1000),
   teacher_msg          varchar(1000),
   state                int comment '0-½ÌÊ¦Î´»Ø¸´
            1-½ÌÊ¦ÒÑ»Ø¸´',
   date                 datetime,
   primary key (id)
=======
CREATE TABLE jctp_chat_ts
(
   id                   INT NOT NULL AUTO_INCREMENT,
   student_id           INT,
   teacher_id           INT,
   course_id            INT,
   student_msg          VARCHAR(1000),
   teacher_msg          VARCHAR(1000),
   state                INT COMMENT '0-æ•™å¸ˆæœªå›žå¤
            1-æ•™å¸ˆå·²å›žå¤',
   DATE                 DATETIME,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_class                                            */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_class
(
   id                   int not null,
   college              varchar(100),
   primary key (id)
=======
CREATE TABLE jctp_class
(
   id                   INT NOT NULL,
   college              VARCHAR(100),
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_course                                           */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_course
(
   id                   int not null auto_increment,
   class_id             int,
   teacher_id           int,
   course_name          varchar(100),
   create_date          datetime,
   grade                int,
   term                 int,
   primary key (id)
=======
CREATE TABLE jctp_course
(
   id                   INT NOT NULL AUTO_INCREMENT,
   class_id             INT,
   teacher_id           INT,
   course_name          VARCHAR(100),
   create_date          DATETIME,
   grade                INT,
   term                 INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_course_file                                      */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_course_file
(
   id                   int not null auto_increment,
   course_id            int,
   type                 int comment '1-ÊÓÆµ
            2-ÎÄµµÒÔ¼°PPT',
   file_name            varchar(100),
   file_path            varchar(200),
   state                int,
   primary key (id)
=======
CREATE TABLE jctp_course_file
(
   id                   INT NOT NULL AUTO_INCREMENT,
   course_id            INT,
   TYPE                 INT COMMENT '1-è§†é¢‘
            2-æ–‡æ¡£ä»¥åŠPPT',
   file_name            VARCHAR(100),
   file_path            VARCHAR(200),
   state                INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_course_job                                       */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_course_job
(
   id                   int not null auto_increment,
   course_id            int,
   job_name             varchar(100),
   description          varchar(1000),
   date                 datetime,
   seq                  int,
   primary key (id)
=======
CREATE TABLE jctp_course_job
(
   id                   INT NOT NULL AUTO_INCREMENT,
   course_id            INT,
   job_name             VARCHAR(100),
   description          VARCHAR(1000),
   DATE                 DATETIME,
   seq                  INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_permission                                       */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_permission
(
   id                   int not null auto_increment,
   name                 varchar(50),
   description          varchar(200),
   url                  varchar(100),
   pid                  int,
   method               varchar(10),
   state                int,
   primary key (id)
=======
CREATE TABLE jctp_permission
(
   id                   INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(50),
   description          VARCHAR(200),
   url                  VARCHAR(100),
   pid                  INT,
   method               VARCHAR(10),
   state                INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_question_job                                     */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_question_job
(
   id                   int not null auto_increment,
   question_id          int,
   job_id               int,
   primary key (id)
=======
CREATE TABLE jctp_question_job
(
   id                   INT NOT NULL AUTO_INCREMENT,
   question_id          INT,
   job_id               INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_questions                                        */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_questions
(
   id                   int not null auto_increment,
   question_name        varchar(100),
   question_type        int comment '0-Ìî¿ÕÌâ
            1-Ñ¡ÔñÌâ
            2-ÅÐ¶ÏÌâ
            3-¼ò´ðÌâ
            4-´úÂëÌâ',
   answer               varchar(1000) comment 'jsonÊý¾Ý¸ñÊ½
=======
CREATE TABLE jctp_questions
(
   id                   INT NOT NULL AUTO_INCREMENT,
   question_name        VARCHAR(100),
   question_type        INT COMMENT '0-å¡«ç©ºé¢˜
            1-é€‰æ‹©é¢˜
            2-åˆ¤æ–­é¢˜
            3-ç®€ç­”é¢˜
            4-ä»£ç é¢˜',
   answer               VARCHAR(1000) COMMENT 'jsonæ•°æ®æ ¼å¼
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
            [
                {
                    input::1,
                    output:1
                },
                {
                    input::2,
                    output:2
                }
            ]',
<<<<<<< HEAD
   seq                  int,
   primary key (id)
=======
   seq                  INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_role                                             */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_role
(
   id                   int not null auto_increment,
   name                 varchar(20),
   state                int,
   primary key (id)
=======
CREATE TABLE jctp_role
(
   id                   INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(20),
   state                INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_role_permission                                  */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_role_permission
(
   id                   int not null auto_increment,
   role_id              int,
   permission_id        int,
   state                int,
   primary key (id)
=======
CREATE TABLE jctp_role_permission
(
   id                   INT NOT NULL AUTO_INCREMENT,
   role_id              INT,
   permission_id        INT,
   state                INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_students_questions                               */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_students_questions
(
   id                   int not null auto_increment,
   user_id              int,
   question_id          int,
   date                 datetime,
   up_answer            varchar(1000),
   score                double,
   state                int,
   primary key (id)
=======
CREATE TABLE jctp_students_questions
(
   id                   INT NOT NULL AUTO_INCREMENT,
   user_id              INT,
   question_id          INT,
   DATE                 DATETIME,
   up_answer            VARCHAR(1000),
   score                DOUBLE,
   state                INT,
   PRIMARY KEY (id)
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0
);

/*==============================================================*/
/* Table: jctp_user                                             */
/*==============================================================*/
<<<<<<< HEAD
create table jctp_user
(
   id                   int not null auto_increment,
   name                 varchar(20),
   sex                  varchar(2),
   work_no              varchar(20),
   phone                varchar(11),
   role_id              int,
   state                int,
   class_id             int,
   password             varchar(256),
   primary key (id)
);

alter table jctp_chat_course add constraint FK_Reference_10 foreign key (course_id)
      references jctp_course (id) on delete restrict on update restrict;

alter table jctp_chat_course add constraint FK_Reference_11 foreign key (user_id)
      references jctp_user (id) on delete restrict on update restrict;

alter table jctp_chat_ts add constraint FK_Reference_12 foreign key (course_id)
      references jctp_course (id) on delete restrict on update restrict;

alter table jctp_chat_ts add constraint FK_Reference_13 foreign key (student_id)
      references jctp_user (id) on delete restrict on update restrict;

alter table jctp_chat_ts add constraint FK_Reference_14 foreign key (teacher_id)
      references jctp_user (id) on delete restrict on update restrict;

alter table jctp_course add constraint FK_Reference_15 foreign key (teacher_id)
      references jctp_user (id) on delete restrict on update restrict;

alter table jctp_course add constraint FK_Reference_7 foreign key (class_id)
      references jctp_class (id) on delete restrict on update restrict;

alter table jctp_course_file add constraint FK_Reference_5 foreign key (course_id)
      references jctp_course (id) on delete restrict on update restrict;

alter table jctp_course_job add constraint FK_Reference_4 foreign key (course_id)
      references jctp_course (id) on delete restrict on update restrict;

alter table jctp_question_job add constraint FK_Reference_16 foreign key (question_id)
      references jctp_questions (id) on delete restrict on update restrict;

alter table jctp_question_job add constraint FK_Reference_17 foreign key (job_id)
      references jctp_course_job (id) on delete restrict on update restrict;

alter table jctp_role_permission add constraint FK_Reference_2 foreign key (role_id)
      references jctp_role (id) on delete restrict on update restrict;

alter table jctp_role_permission add constraint FK_Reference_3 foreign key (permission_id)
      references jctp_permission (id) on delete restrict on update restrict;

alter table jctp_students_questions add constraint FK_Reference_18 foreign key (question_id)
      references jctp_questions (id) on delete restrict on update restrict;

alter table jctp_students_questions add constraint FK_Reference_19 foreign key (user_id)
      references jctp_user (id) on delete restrict on update restrict;

alter table jctp_user add constraint FK_Reference_1 foreign key (role_id)
      references jctp_role (id) on delete restrict on update restrict;

alter table jctp_user add constraint FK_Reference_9 foreign key (class_id)
      references jctp_class (id) on delete restrict on update restrict;
=======
CREATE TABLE jctp_user
(
   id                   INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(20),
   sex                  VARCHAR(2),
   work_no              VARCHAR(20),
   phone                VARCHAR(11),
   role_id              INT,
   state                INT,
   class_id             INT,
   PASSWORD             VARCHAR(16),
   PRIMARY KEY (id)
);

ALTER TABLE jctp_chat_course ADD CONSTRAINT FK_Reference_10 FOREIGN KEY (course_id)
      REFERENCES jctp_course (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_chat_course ADD CONSTRAINT FK_Reference_11 FOREIGN KEY (user_id)
      REFERENCES jctp_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_chat_ts ADD CONSTRAINT FK_Reference_12 FOREIGN KEY (course_id)
      REFERENCES jctp_course (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_chat_ts ADD CONSTRAINT FK_Reference_13 FOREIGN KEY (student_id)
      REFERENCES jctp_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_chat_ts ADD CONSTRAINT FK_Reference_14 FOREIGN KEY (teacher_id)
      REFERENCES jctp_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_course ADD CONSTRAINT FK_Reference_15 FOREIGN KEY (teacher_id)
      REFERENCES jctp_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_course ADD CONSTRAINT FK_Reference_7 FOREIGN KEY (class_id)
      REFERENCES jctp_class (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_course_file ADD CONSTRAINT FK_Reference_5 FOREIGN KEY (course_id)
      REFERENCES jctp_course (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_course_job ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (course_id)
      REFERENCES jctp_course (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_question_job ADD CONSTRAINT FK_Reference_16 FOREIGN KEY (question_id)
      REFERENCES jctp_questions (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_question_job ADD CONSTRAINT FK_Reference_17 FOREIGN KEY (job_id)
      REFERENCES jctp_course_job (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_role_permission ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (role_id)
      REFERENCES jctp_role (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_role_permission ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (permission_id)
      REFERENCES jctp_permission (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_students_questions ADD CONSTRAINT FK_Reference_18 FOREIGN KEY (question_id)
      REFERENCES jctp_questions (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_students_questions ADD CONSTRAINT FK_Reference_19 FOREIGN KEY (user_id)
      REFERENCES jctp_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_user ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (role_id)
      REFERENCES jctp_role (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE jctp_user ADD CONSTRAINT FK_Reference_9 FOREIGN KEY (class_id)
      REFERENCES jctp_class (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
>>>>>>> e6d3476417879417c55ba423291edb31a6295cf0

