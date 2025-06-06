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


import com.dao.WodeyuyueDao;
import com.entity.WodeyuyueEntity;
import com.service.WodeyuyueService;
import com.entity.vo.WodeyuyueVO;
import com.entity.view.WodeyuyueView;

@Service("wodeyuyueService")
public class WodeyuyueServiceImpl extends ServiceImpl<WodeyuyueDao, WodeyuyueEntity> implements WodeyuyueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodeyuyueEntity> page = this.selectPage(
                new Query<WodeyuyueEntity>(params).getPage(),
                new EntityWrapper<WodeyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodeyuyueEntity> wrapper) {
		  Page<WodeyuyueView> page =new Query<WodeyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodeyuyueVO> selectListVO(Wrapper<WodeyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodeyuyueVO selectVO(Wrapper<WodeyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodeyuyueView> selectListView(Wrapper<WodeyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodeyuyueView selectView(Wrapper<WodeyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
