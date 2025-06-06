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


import com.dao.TuihuiyajinDao;
import com.entity.TuihuiyajinEntity;
import com.service.TuihuiyajinService;
import com.entity.vo.TuihuiyajinVO;
import com.entity.view.TuihuiyajinView;

@Service("tuihuiyajinService")
public class TuihuiyajinServiceImpl extends ServiceImpl<TuihuiyajinDao, TuihuiyajinEntity> implements TuihuiyajinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuihuiyajinEntity> page = this.selectPage(
                new Query<TuihuiyajinEntity>(params).getPage(),
                new EntityWrapper<TuihuiyajinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuihuiyajinEntity> wrapper) {
		  Page<TuihuiyajinView> page =new Query<TuihuiyajinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuihuiyajinVO> selectListVO(Wrapper<TuihuiyajinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuihuiyajinVO selectVO(Wrapper<TuihuiyajinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuihuiyajinView> selectListView(Wrapper<TuihuiyajinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuihuiyajinView selectView(Wrapper<TuihuiyajinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
