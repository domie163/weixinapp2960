package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangdishiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangdishiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdishiyongView;


/**
 * 场地使用
 *
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
public interface ChangdishiyongService extends IService<ChangdishiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangdishiyongVO> selectListVO(Wrapper<ChangdishiyongEntity> wrapper);
   	
   	ChangdishiyongVO selectVO(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
   	
   	List<ChangdishiyongView> selectListView(Wrapper<ChangdishiyongEntity> wrapper);
   	
   	ChangdishiyongView selectView(@Param("ew") Wrapper<ChangdishiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangdishiyongEntity> wrapper);
   	

}

