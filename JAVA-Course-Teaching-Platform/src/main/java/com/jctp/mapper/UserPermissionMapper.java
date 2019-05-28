package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.jctp.beans.Permission;
import com.jctp.beans.Role;
import com.jctp.beans.RolePermission;
import com.jctp.beans.User;

@Mapper
public interface UserPermissionMapper {
	@Select("SELECT * FROM JCTP_USER WHERE work_no=#{workNo}")
	public User getUserByWorkNo(@Param("workNo") String workNo);

	@Select("SELECT * FROM JCTP_ROLE WHERE ID=#{role_id}")
	public Role getRoleListById(@Param("role_id") int role_id);
	
	
	@Select("SELECT * FROM JCTP_PERMISSION WHERE ID=#{permissionId}")
	public Permission getPermissions(@Param("permissionId") int permissionId);
	
	@Select("SELECT *,rp.id AS rp_id FROM JCTP_ROLE_PERMISSION RP "
			+ "LEFT JOIN JCTP_PERMISSION P ON RP.PERMISSION_ID=P.ID "
			+ "LEFT JOIN JCTP_ROLE R ON RP.ROLE_ID = R.ID")
	@Results({
		@Result(property = "id",column = "rp_id"),
		@Result(property = "permission",column = "permission_id", one = @One(select = "com.jctp.mapper.UserPermissionMapper.getPermissions")),
		@Result(property = "role",column = "role_id" , one = @One(select = "com.jctp.mapper.UserPermissionMapper.getRoleListById"))
	})
	public List<RolePermission> getRolePermissions();
}
