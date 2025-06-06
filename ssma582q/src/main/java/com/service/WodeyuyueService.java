package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodeyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodeyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodeyuyueView;


/**
 * 我的预约
 *
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface WodeyuyueService extends IService<WodeyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodeyuyueVO> selectListVO(Wrapper<WodeyuyueEntity> wrapper);
   	
   	WodeyuyueVO selectVO(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
   	
   	List<WodeyuyueView> selectListView(Wrapper<WodeyuyueEntity> wrapper);
   	
   	WodeyuyueView selectView(@Param("ew") Wrapper<WodeyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodeyuyueEntity> wrapper);
   	

}

