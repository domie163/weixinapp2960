package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChangdishiyongDao;
import com.entity.ChangdishiyongEntity;
import com.service.ChangdishiyongService;
import com.entity.vo.ChangdishiyongVO;
import com.entity.view.ChangdishiyongView;

@Service("changdishiyongService")
public class ChangdishiyongServiceImpl extends ServiceImpl<ChangdishiyongDao, ChangdishiyongEntity> implements ChangdishiyongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangdishiyongEntity> page = this.selectPage(
                new Query<ChangdishiyongEntity>(params).getPage(),
                new EntityWrapper<ChangdishiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdishiyongEntity> wrapper) {
		  Page<ChangdishiyongView> page =new Query<ChangdishiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChangdishiyongVO> selectListVO(Wrapper<ChangdishiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangdishiyongVO selectVO(Wrapper<ChangdishiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangdishiyongView> selectListView(Wrapper<ChangdishiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangdishiyongView selectView(Wrapper<ChangdishiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
