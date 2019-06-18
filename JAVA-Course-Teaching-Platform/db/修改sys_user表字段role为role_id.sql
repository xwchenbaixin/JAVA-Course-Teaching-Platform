alter table sys_user drop constraint FK_SYS_USER_REFERENCE_SYS_ROLE;

exec sp_rename 'sys_user.role','role_id';
alter table sys_user add constraint FK_SYS_USER_REFERENCE_SYS_ROLE foreign key(role_id) references sys_role(id);
