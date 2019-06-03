package com.workorder.mapper;

import com.workorder.pojo.WoPermission;
import com.workorder.pojo.WoPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoPermissionMapper {
    int countByExample(WoPermissionExample example);

    int deleteByExample(WoPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoPermission record);

    int insertSelective(WoPermission record);

    List<WoPermission> selectByExample(WoPermissionExample example);

    WoPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoPermission record, @Param("example") WoPermissionExample example);

    int updateByExample(@Param("record") WoPermission record, @Param("example") WoPermissionExample example);

    int updateByPrimaryKeySelective(WoPermission record);

    int updateByPrimaryKey(WoPermission record);
}