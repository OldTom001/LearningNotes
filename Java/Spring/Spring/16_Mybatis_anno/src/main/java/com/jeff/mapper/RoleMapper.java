package com.jeff.mapper;

import com.jeff.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * FROM sys_user_role ur, sys_role r WHERE ur.roleId = r.id AND ur.userId = #{id}")
    public List<Role> findByUid(int uid);
}
