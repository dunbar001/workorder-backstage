package com.workorder.mapper;

import com.workorder.pojo.WoUserRole;
import com.workorder.pojo.WoUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoUserRoleMapper {
    int countByExample(WoUserRoleExample example);

    int deleteByExample(WoUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoUserRole record);

    int insertSelective(WoUserRole record);

    List<WoUserRole> selectByExample(WoUserRoleExample example);

    WoUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoUserRole record, @Param("example") WoUserRoleExample example);

    int updateByExample(@Param("record") WoUserRole record, @Param("example") WoUserRoleExample example);

    int updateByPrimaryKeySelective(WoUserRole record);

    int updateByPrimaryKey(WoUserRole record);
}