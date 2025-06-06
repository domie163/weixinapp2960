package com.entity.view;

import com.entity.ChangdishiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 场地使用
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-20 17:26:02
 */
@TableName("changdishiyong")
public class ChangdishiyongView  extends ChangdishiyongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChangdishiyongView(){
	}
 
 	public ChangdishiyongView(ChangdishiyongEntity changdishiyongEntity){
 	try {
			BeanUtils.copyProperties(this, changdishiyongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
