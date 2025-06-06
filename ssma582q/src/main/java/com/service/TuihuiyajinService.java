package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuihuiyajinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuihuiyajinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuihuiyajinView;


/**
 * 退回押金
 *
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface TuihuiyajinService extends IService<TuihuiyajinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuihuiyajinVO> selectListVO(Wrapper<TuihuiyajinEntity> wrapper);
   	
   	TuihuiyajinVO selectVO(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
   	
   	List<TuihuiyajinView> selectListView(Wrapper<TuihuiyajinEntity> wrapper);
   	
   	TuihuiyajinView selectView(@Param("ew") Wrapper<TuihuiyajinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuihuiyajinEntity> wrapper);
   	

}

