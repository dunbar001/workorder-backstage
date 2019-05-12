package com.workorder.mapper;

import com.workorder.pojo.WoUser;
import com.workorder.pojo.WoUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WoUserMapper {
    int countByExample(WoUserExample example);

    int deleteByExample(WoUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WoUser record);

    int insertSelective(WoUser record);

    List<WoUser> selectByExample(WoUserExample example);

    WoUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WoUser record, @Param("example") WoUserExample example);

    int updateByExample(@Param("record") WoUser record, @Param("example") WoUserExample example);

    int updateByPrimaryKeySelective(WoUser record);

    int updateByPrimaryKey(WoUser record);
}