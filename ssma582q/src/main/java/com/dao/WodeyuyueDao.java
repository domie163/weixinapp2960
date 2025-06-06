package com.dao;

import com.entity.WodeyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodeyuyueVO;
import com.entity.view.WodeyuyueView;


/**
 * 我的预约
 * 
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface WodeyuyueDao extends BaseMapper<WodeyuyueEntity> {
	
	List<WodeyuyueVO> selectListVO(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
	
	WodeyuyueVO selectVO(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
	
	List<WodeyuyueView> selectListView(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);

	List<WodeyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
	
	WodeyuyueView selectView(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
	

}
