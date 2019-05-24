/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019/5/23 22:49:10                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_chat_course') and o.name = 'FK_SYS_CHAT_REFERENCE_SYS_COUR')
alter table sys_chat_course
   drop constraint FK_SYS_CHAT_REFERENCE_SYS_COUR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_chat_course') and o.name = 'FK_SYS_CHAT_REFERENCE_SYS_USER')
alter table sys_chat_course
   drop constraint FK_SYS_CHAT_REFERENCE_SYS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_chat_ts') and o.name = 'FK_SYS_CHAT_REFERENCE_SYS_COUR')
alter table sys_chat_ts
   drop constraint FK_SYS_CHAT_REFERENCE_SYS_COUR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_chat_ts') and o.name = 'FK_SYS_CHAT_REFERENCE_SYS_USER')
alter table sys_chat_ts
   drop constraint FK_SYS_CHAT_REFERENCE_SYS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_chat_ts') and o.name = 'FK_SYS_CHAT_REFERENCE_SYS_USER')
alter table sys_chat_ts
   drop constraint FK_SYS_CHAT_REFERENCE_SYS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_course') and o.name = 'FK_SYS_COUR_REFERENCE_SYS_USER')
alter table sys_course
   drop constraint FK_SYS_COUR_REFERENCE_SYS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_course') and o.name = 'FK_SYS_COUR_REFERENCE_SYS_CLAS')
alter table sys_course
   drop constraint FK_SYS_COUR_REFERENCE_SYS_CLAS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_course_file') and o.name = 'FK_SYS_COUR_REFERENCE_SYS_COUR')
alter table sys_course_file
   drop constraint FK_SYS_COUR_REFERENCE_SYS_COUR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_course_job') and o.name = 'FK_SYS_COUR_REFERENCE_SYS_COUR')
alter table sys_course_job
   drop constraint FK_SYS_COUR_REFERENCE_SYS_COUR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_question_job') and o.name = 'FK_SYS_QUES_REFERENCE_SYS_QUES')
alter table sys_question_job
   drop constraint FK_SYS_QUES_REFERENCE_SYS_QUES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_question_job') and o.name = 'FK_SYS_QUES_REFERENCE_SYS_COUR')
alter table sys_question_job
   drop constraint FK_SYS_QUES_REFERENCE_SYS_COUR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_role_permission') and o.name = 'FK_SYS_ROLE_REFERENCE_SYS_ROLE')
alter table sys_role_permission
   drop constraint FK_SYS_ROLE_REFERENCE_SYS_ROLE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_role_permission') and o.name = 'FK_SYS_ROLE_REFERENCE_SYS_PERM')
alter table sys_role_permission
   drop constraint FK_SYS_ROLE_REFERENCE_SYS_PERM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_students_questions') and o.name = 'FK_SYS_STUD_REFERENCE_SYS_QUES')
alter table sys_students_questions
   drop constraint FK_SYS_STUD_REFERENCE_SYS_QUES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_students_questions') and o.name = 'FK_SYS_STUD_REFERENCE_SYS_USER')
alter table sys_students_questions
   drop constraint FK_SYS_STUD_REFERENCE_SYS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_user') and o.name = 'FK_SYS_USER_REFERENCE_SYS_ROLE')
alter table sys_user
   drop constraint FK_SYS_USER_REFERENCE_SYS_ROLE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sys_user') and o.name = 'FK_SYS_USER_REFERENCE_SYS_CLAS')
alter table sys_user
   drop constraint FK_SYS_USER_REFERENCE_SYS_CLAS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_chat_course')
            and   type = 'U')
   drop table sys_chat_course
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_chat_ts')
            and   type = 'U')
   drop table sys_chat_ts
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_class')
            and   type = 'U')
   drop table sys_class
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_course')
            and   type = 'U')
   drop table sys_course
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_course_file')
            and   type = 'U')
   drop table sys_course_file
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_course_job')
            and   type = 'U')
   drop table sys_course_job
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_permission')
            and   type = 'U')
   drop table sys_permission
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_question_job')
            and   type = 'U')
   drop table sys_question_job
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_questions')
            and   type = 'U')
   drop table sys_questions
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_role')
            and   type = 'U')
   drop table sys_role
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_role_permission')
            and   type = 'U')
   drop table sys_role_permission
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_students_questions')
            and   type = 'U')
   drop table sys_students_questions
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sys_user')
            and   type = 'U')
   drop table sys_user
go

/*==============================================================*/
/* Table: sys_chat_course                                       */
/*==============================================================*/
create table sys_chat_course (
   id                   int                  not null,
   course_id            int                  null,
   user_id              int                  null,
   msg                  varchar(1000)        null,
   seq                  int                  identity,
   date                 datetime             null,
   constraint PK_SYS_CHAT_COURSE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_chat_ts                                           */
/*==============================================================*/
create table sys_chat_ts (
   id                   int                  not null,
   student_id           int                  null,
   teacher_id           int                  null,
   course_id            int                  null,
   student_msg          varchar(1000)        null,
   teacher_msg          varchar(1000)        null,
   state                int                  null,
   date                 datetime             null,
   constraint PK_SYS_CHAT_TS primary key nonclustered (id)
)
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('sys_chat_ts')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'state')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'sys_chat_ts', 'column', 'state'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '0-教师未回复
   1-教师已回复',
   'user', @CurrentUser, 'table', 'sys_chat_ts', 'column', 'state'
go

/*==============================================================*/
/* Table: sys_class                                             */
/*==============================================================*/
create table sys_class (
   id                   int                  not null,
   college              varchar(100)         null,
   constraint PK_SYS_CLASS primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_course                                            */
/*==============================================================*/
create table sys_course (
   id                   int                  not null,
   class_id             int                  null,
   teacher_id           int                  null,
   course_name          varchar(100)         null,
   create_date          datetime             null,
   grade                int                  null,
   term                 int                  null,
   constraint PK_SYS_COURSE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_course_file                                       */
/*==============================================================*/
create table sys_course_file (
   id                   int                  not null,
   course_id            int                  null,
   type                 int                  null,
   file_name            varchar(100)         null,
   file_path            varchar(200)         null,
   state                int                  null,
   constraint PK_SYS_COURSE_FILE primary key nonclustered (id)
)
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('sys_course_file')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'type')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'sys_course_file', 'column', 'type'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '1-视频
   2-文档以及PPT',
   'user', @CurrentUser, 'table', 'sys_course_file', 'column', 'type'
go

/*==============================================================*/
/* Table: sys_course_job                                        */
/*==============================================================*/
create table sys_course_job (
   id                   int                  not null,
   course_id            int                  null,
   job_name             varchar(100)         null,
   description          varchar(1000)        null,
   date                 datetime             null,
   seq                  int                  identity,
   constraint PK_SYS_COURSE_JOB primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission (
   id                   int                  identity,
   name                 varchar(50)          null,
   description          varchar(200)         null,
   url                  varchar(100)         null,
   pid                  int                  null,
   method               varchar(10)          null,
   state                int                  null,
   constraint PK_SYS_PERMISSION primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_question_job                                      */
/*==============================================================*/
create table sys_question_job (
   id                   int                  not null,
   question_id          int                  null,
   job_id               int                  null,
   constraint PK_SYS_QUESTION_JOB primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_questions                                         */
/*==============================================================*/
create table sys_questions (
   id                   int                  not null,
   question_name        varchar(100)         null,
   question_type        int                  null,
   answer               varchar(1000)        null,
   seq                  int                  null,
   constraint PK_SYS_QUESTIONS primary key nonclustered (id)
)
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('sys_questions')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'question_type')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'sys_questions', 'column', 'question_type'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '0-填空题
   1-选择题
   2-判断题
   3-简答题
   4-代码题',
   'user', @CurrentUser, 'table', 'sys_questions', 'column', 'question_type'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('sys_questions')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'answer')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'sys_questions', 'column', 'answer'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'json数据格式
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
   'user', @CurrentUser, 'table', 'sys_questions', 'column', 'answer'
go

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role (
   id                   int                  identity,
   name                 varchar(20)          null,
   state                int                  null,
   constraint PK_SYS_ROLE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission (
   id                   int                  not null,
   role_id              int                  null,
   permission_id        int                  null,
   state                int                  null,
   constraint PK_SYS_ROLE_PERMISSION primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_students_questions                                */
/*==============================================================*/
create table sys_students_questions (
   id                   int                  not null,
   user_id              int                  null,
   question_id          int                  null,
   date                 datetime             null,
   up_answer            varchar(1000)        null,
   score                double precision     null,
   state                int                  null,
   constraint PK_SYS_STUDENTS_QUESTIONS primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user (
   id                   int                  not null,
   name                 varchar(20)          null,
   sex                  varchar(2)           null,
   work_no              varchar(20)          null,
   phone                varchar(11)          null,
   role                 int                  null,
   state                int                  null,
   class_id             int                  null,
   password             varchar(16)          null,
   constraint PK_SYS_USER primary key nonclustered (id)
)
go

alter table sys_chat_course
   add constraint FK_SYS_CHAT_REFERENCE_SYS_COUR foreign key (course_id)
      references sys_course (id)
go

alter table sys_chat_course
   add constraint FK_SYS_CHAT_REFERENCE_SYS_USER foreign key (user_id)
      references sys_user (id)
go

alter table sys_chat_ts
   add constraint FK_SYS_CHAT_REFERENCE_SYS_COUR foreign key (course_id)
      references sys_course (id)
go

alter table sys_chat_ts
   add constraint FK_SYS_CHAT_REFERENCE_SYS_USER foreign key (student_id)
      references sys_user (id)
go

alter table sys_chat_ts
   add constraint FK_SYS_CHAT_REFERENCE_SYS_USER foreign key (teacher_id)
      references sys_user (id)
go

alter table sys_course
   add constraint FK_SYS_COUR_REFERENCE_SYS_USER foreign key (teacher_id)
      references sys_user (id)
go

alter table sys_course
   add constraint FK_SYS_COUR_REFERENCE_SYS_CLAS foreign key (class_id)
      references sys_class (id)
go

alter table sys_course_file
   add constraint FK_SYS_COUR_REFERENCE_SYS_COUR foreign key (course_id)
      references sys_course (id)
go

alter table sys_course_job
   add constraint FK_SYS_COUR_REFERENCE_SYS_COUR foreign key (course_id)
      references sys_course (id)
go

alter table sys_question_job
   add constraint FK_SYS_QUES_REFERENCE_SYS_QUES foreign key (question_id)
      references sys_questions (id)
go

alter table sys_question_job
   add constraint FK_SYS_QUES_REFERENCE_SYS_COUR foreign key (job_id)
      references sys_course_job (id)
go

alter table sys_role_permission
   add constraint FK_SYS_ROLE_REFERENCE_SYS_ROLE foreign key (role_id)
      references sys_role (id)
go

alter table sys_role_permission
   add constraint FK_SYS_ROLE_REFERENCE_SYS_PERM foreign key (permission_id)
      references sys_permission (id)
go

alter table sys_students_questions
   add constraint FK_SYS_STUD_REFERENCE_SYS_QUES foreign key (question_id)
      references sys_questions (id)
go

alter table sys_students_questions
   add constraint FK_SYS_STUD_REFERENCE_SYS_USER foreign key (user_id)
      references sys_user (id)
go

alter table sys_user
   add constraint FK_SYS_USER_REFERENCE_SYS_ROLE foreign key (role)
      references sys_role (id)
go

alter table sys_user
   add constraint FK_SYS_USER_REFERENCE_SYS_CLAS foreign key (class_id)
      references sys_class (id)
go

