/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：CompareUtil.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 比較ユーティリティ
 * @author tsuruda
 *
 */
public class CompareUtil {
	public static <T> Boolean diff(T a, T b) {
		BeanWrapper aWrap = new BeanWrapperImpl(a);
		PropertyDescriptor[] pds = aWrap.getPropertyDescriptors();
		List<String> propertyNames = new ArrayList<String>();
		for (PropertyDescriptor pd : pds) {
			if (aWrap.isReadableProperty(pd.getName())) {
				propertyNames.add(pd.getName());
			}
		}

		BeanWrapper bWrap = new BeanWrapperImpl(b);

		for (String propertyName : propertyNames) {
			Object aPropValue = aWrap.getPropertyValue(propertyName);
			Object bPropValue = bWrap.getPropertyValue(propertyName);
			
			if (aPropValue == null) {
				if (bPropValue != null) {
					return false;
				}
			}
			else {
				if(!aPropValue.equals(bPropValue)) {
					return false;
				}
			}
		}
		return true;
	}
}
