package com.workorder.mapper;

import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoSysRoleMapper {
    int countByExample(WoSysRoleExample example);

    int deleteByExample(WoSysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoSysRole record);

    int insertSelective(WoSysRole record);

    List<WoSysRole> selectByExample(WoSysRoleExample example);

    WoSysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoSysRole record, @Param("example") WoSysRoleExample example);

    int updateByExample(@Param("record") WoSysRole record, @Param("example") WoSysRoleExample example);

    int updateByPrimaryKeySelective(WoSysRole record);

    int updateByPrimaryKey(WoSysRole record);
    
    WoSysRole findRoleByUid(Integer uid);
    
    List<WoSysRole> findRoleListByUrl(String url);
}