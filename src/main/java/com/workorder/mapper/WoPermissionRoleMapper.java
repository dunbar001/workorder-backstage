package com.workorder.mapper;

import com.workorder.pojo.WoPermissionRole;
import com.workorder.pojo.WoPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoPermissionRoleMapper {
    int countByExample(WoPermissionRoleExample example);

    int deleteByExample(WoPermissionRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoPermissionRole record);

    int insertSelective(WoPermissionRole record);

    List<WoPermissionRole> selectByExample(WoPermissionRoleExample example);

    WoPermissionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoPermissionRole record, @Param("example") WoPermissionRoleExample example);

    int updateByExample(@Param("record") WoPermissionRole record, @Param("example") WoPermissionRoleExample example);

    int updateByPrimaryKeySelective(WoPermissionRole record);

    int updateByPrimaryKey(WoPermissionRole record);
}