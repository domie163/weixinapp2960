package com.dao;

import com.entity.ChangdishiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangdishiyongVO;
import com.entity.view.ChangdishiyongView;


/**
 * 场地使用
 * 
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface ChangdishiyongDao extends BaseMapper<ChangdishiyongEntity> {
	
	List<ChangdishiyongVO> selectListVO(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
	
	ChangdishiyongVO selectVO(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
	
	List<ChangdishiyongView> selectListView(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);

	List<ChangdishiyongView> selectListView(Pagination page,@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
	
	ChangdishiyongView selectView(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
	

}
