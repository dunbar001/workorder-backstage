package com.workorder.mapper;

import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoSysUserExample;
import com.workorder.vo.V_WoUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoSysUserMapper {
    int countByExample(WoSysUserExample example);

    int deleteByExample(WoSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoSysUser record);

    int insertSelective(WoSysUser record);

    List<WoSysUser> selectByExample(WoSysUserExample example);

    WoSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoSysUser record, @Param("example") WoSysUserExample example);

    int updateByExample(@Param("record") WoSysUser record, @Param("example") WoSysUserExample example);

    int updateByPrimaryKeySelective(WoSysUser record);

    int updateByPrimaryKey(WoSysUser record);
    
    V_WoUser findById(Integer id);
}