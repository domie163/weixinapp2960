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

import com.entity.ChangdishiyongEntity;
import com.entity.view.ChangdishiyongView;

import com.service.ChangdishiyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 场地使用
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
@RestController
@RequestMapping("/changdishiyong")
public class ChangdishiyongController {
    @Autowired
    private ChangdishiyongService changdishiyongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdishiyongEntity changdishiyong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			changdishiyong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChangdishiyongEntity> ew = new EntityWrapper<ChangdishiyongEntity>();
		PageUtils page = changdishiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdishiyong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdishiyongEntity changdishiyong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			changdishiyong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChangdishiyongEntity> ew = new EntityWrapper<ChangdishiyongEntity>();
		PageUtils page = changdishiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdishiyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdishiyongEntity changdishiyong){
       	EntityWrapper<ChangdishiyongEntity> ew = new EntityWrapper<ChangdishiyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdishiyong, "changdishiyong")); 
        return R.ok().put("data", changdishiyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdishiyongEntity changdishiyong){
        EntityWrapper< ChangdishiyongEntity> ew = new EntityWrapper< ChangdishiyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdishiyong, "changdishiyong")); 
		ChangdishiyongView changdishiyongView =  changdishiyongService.selectView(ew);
		return R.ok("查询场地使用成功").put("data", changdishiyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdishiyongEntity changdishiyong = changdishiyongService.selectById(id);
        return R.ok().put("data", changdishiyong);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdishiyongEntity changdishiyong = changdishiyongService.selectById(id);
        return R.ok().put("data", changdishiyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdishiyongEntity changdishiyong, HttpServletRequest request){
    	changdishiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changdishiyong);

        changdishiyongService.insert(changdishiyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdishiyongEntity changdishiyong, HttpServletRequest request){
    	changdishiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changdishiyong);
    	changdishiyong.setUserid((Long)request.getSession().getAttribute("userId"));

        changdishiyongService.insert(changdishiyong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChangdishiyongEntity changdishiyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdishiyong);
        changdishiyongService.updateById(changdishiyong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdishiyongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ChangdishiyongEntity> wrapper = new EntityWrapper<ChangdishiyongEntity>();
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

		int count = changdishiyongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
