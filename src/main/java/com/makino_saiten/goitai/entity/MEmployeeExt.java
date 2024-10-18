/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MEmployeeExt.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 従業員マスタ拡張エンティティ
 * @author tsuruda
 *
 */
@Getter
@Setter
@Entity(listener = MEmployeeExtListener.class)
@Table(name = "m_employee_ext")
public class MEmployeeExt extends MEmployee {

	/** 部門名 */
	@Column(name = "sec_name")
	String secName;

}
