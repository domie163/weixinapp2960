package com.entity.view;

import com.entity.WodeyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 我的预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
@TableName("wodeyuyue")
public class WodeyuyueView  extends WodeyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WodeyuyueView(){
	}
 
 	public WodeyuyueView(WodeyuyueEntity wodeyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, wodeyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
