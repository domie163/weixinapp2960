package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WodeyuyueEntity;
import com.entity.view.WodeyuyueView;

import com.service.WodeyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 我的预约
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
@RestController
@RequestMapping("/wodeyuyue")
public class WodeyuyueController {
    @Autowired
    private WodeyuyueService wodeyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodeyuyueEntity wodeyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodeyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodeyuyueEntity> ew = new EntityWrapper<WodeyuyueEntity>();
		PageUtils page = wodeyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeyuyue), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodeyuyueEntity wodeyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodeyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodeyuyueEntity> ew = new EntityWrapper<WodeyuyueEntity>();
		PageUtils page = wodeyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodeyuyueEntity wodeyuyue){
       	EntityWrapper<WodeyuyueEntity> ew = new EntityWrapper<WodeyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodeyuyue, "wodeyuyue")); 
        return R.ok().put("data", wodeyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodeyuyueEntity wodeyuyue){
        EntityWrapper< WodeyuyueEntity> ew = new EntityWrapper< WodeyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodeyuyue, "wodeyuyue")); 
		WodeyuyueView wodeyuyueView =  wodeyuyueService.selectView(ew);
		return R.ok("查询我的预约成功").put("data", wodeyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodeyuyueEntity wodeyuyue = wodeyuyueService.selectById(id);
        return R.ok().put("data", wodeyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodeyuyueEntity wodeyuyue = wodeyuyueService.selectById(id);
        return R.ok().put("data", wodeyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodeyuyueEntity wodeyuyue, HttpServletRequest request){
    	wodeyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeyuyue);

        wodeyuyueService.insert(wodeyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodeyuyueEntity wodeyuyue, HttpServletRequest request){
    	wodeyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeyuyue);
    	wodeyuyue.setUserid((Long)request.getSession().getAttribute("userId"));

        wodeyuyueService.insert(wodeyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WodeyuyueEntity wodeyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodeyuyue);
        wodeyuyueService.updateById(wodeyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodeyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<WodeyuyueEntity> wrapper = new EntityWrapper<WodeyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = wodeyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
