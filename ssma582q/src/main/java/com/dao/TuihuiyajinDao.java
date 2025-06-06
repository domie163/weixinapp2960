package com.dao;

import com.entity.TuihuiyajinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuihuiyajinVO;
import com.entity.view.TuihuiyajinView;


/**
 * 退回押金
 * 
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface TuihuiyajinDao extends BaseMapper<TuihuiyajinEntity> {
	
	List<TuihuiyajinVO> selectListVO(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
	
	TuihuiyajinVO selectVO(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
	
	List<TuihuiyajinView> selectListView(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);

	List<TuihuiyajinView> selectListView(Pagination page,@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
	
	TuihuiyajinView selectView(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
	

}
