/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/25 11:50:00                           */
/*==============================================================*/


drop table if exists sys_chat_course;

drop table if exists sys_chat_ts;

drop table if exists sys_class;

drop table if exists sys_course;

drop table if exists sys_course_file;

drop table if exists sys_course_job;

drop table if exists sys_permission;

drop table if exists sys_question_job;

drop table if exists sys_questions;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_students_questions;

drop table if exists sys_user;

/*==============================================================*/
/* Table: sys_chat_course                                       */
/*==============================================================*/
create table sys_chat_course
(
   id                   int not null auto_increment,
   course_id            int,
   user_id              int,
   msg                  varchar(1000),
   seq                  int,
   date                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_chat_ts                                           */
/*==============================================================*/
create table sys_chat_ts
(
   id                   int not null auto_increment,
   student_id           int,
   teacher_id           int,
   course_id            int,
   student_msg          varchar(1000),
   teacher_msg          varchar(1000),
   state                int comment '0-教师未回复
            1-教师已回复',
   date                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_class                                             */
/*==============================================================*/
create table sys_class
(
   id                   int not null,
   college              varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: sys_course                                            */
/*==============================================================*/
create table sys_course
(
   id                   int not null auto_increment,
   class_id             int,
   teacher_id           int,
   course_name          varchar(100),
   create_date          datetime,
   grade                int,
   term                 int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_course_file                                       */
/*==============================================================*/
create table sys_course_file
(
   id                   int not null auto_increment,
   course_id            int,
   type                 int comment '1-视频
            2-文档以及PPT',
   file_name            varchar(100),
   file_path            varchar(200),
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_course_job                                        */
/*==============================================================*/
create table sys_course_job
(
   id                   int not null auto_increment,
   course_id            int,
   job_name             varchar(100),
   description          varchar(1000),
   date                 datetime,
   seq                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   id                   int not null auto_increment,
   name                 varchar(50),
   description          varchar(200),
   url                  varchar(100),
   pid                  int,
   method               varchar(10),
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_question_job                                      */
/*==============================================================*/
create table sys_question_job
(
   id                   int not null auto_increment,
   question_id          int,
   job_id               int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_questions                                         */
/*==============================================================*/
create table sys_questions
(
   id                   int not null auto_increment,
   question_name        varchar(100),
   question_type        int comment '0-填空题
            1-选择题
            2-判断题
            3-简答题
            4-代码题',
   answer               varchar(1000) comment 'json数据格式
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
   seq                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int not null auto_increment,
   name                 varchar(20),
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   id                   int not null auto_increment,
   role_id              int,
   permission_id        int,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_students_questions                                */
/*==============================================================*/
create table sys_students_questions
(
   id                   int not null auto_increment,
   user_id              int,
   question_id          int,
   date                 datetime,
   up_answer            varchar(1000),
   score                double,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   int not null auto_increment,
   name                 varchar(20),
   sex                  varchar(2),
   work_no              varchar(20),
   phone                varchar(11),
   role_id              int,
   state                int,
   class_id             int,
   password             varchar(16),
   primary key (id)
);

alter table sys_chat_course add constraint FK_Reference_10 foreign key (course_id)
      references sys_course (id) on delete restrict on update restrict;

alter table sys_chat_course add constraint FK_Reference_11 foreign key (user_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_chat_ts add constraint FK_Reference_12 foreign key (course_id)
      references sys_course (id) on delete restrict on update restrict;

alter table sys_chat_ts add constraint FK_Reference_13 foreign key (student_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_chat_ts add constraint FK_Reference_14 foreign key (teacher_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_course add constraint FK_Reference_15 foreign key (teacher_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_course add constraint FK_Reference_7 foreign key (class_id)
      references sys_class (id) on delete restrict on update restrict;

alter table sys_course_file add constraint FK_Reference_5 foreign key (course_id)
      references sys_course (id) on delete restrict on update restrict;

alter table sys_course_job add constraint FK_Reference_4 foreign key (course_id)
      references sys_course (id) on delete restrict on update restrict;

alter table sys_question_job add constraint FK_Reference_16 foreign key (question_id)
      references sys_questions (id) on delete restrict on update restrict;

alter table sys_question_job add constraint FK_Reference_17 foreign key (job_id)
      references sys_course_job (id) on delete restrict on update restrict;

alter table sys_role_permission add constraint FK_Reference_2 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

alter table sys_role_permission add constraint FK_Reference_3 foreign key (permission_id)
      references sys_permission (id) on delete restrict on update restrict;

alter table sys_students_questions add constraint FK_Reference_18 foreign key (question_id)
      references sys_questions (id) on delete restrict on update restrict;

alter table sys_students_questions add constraint FK_Reference_19 foreign key (user_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_user add constraint FK_Reference_1 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

alter table sys_user add constraint FK_Reference_9 foreign key (class_id)
      references sys_class (id) on delete restrict on update restrict;

