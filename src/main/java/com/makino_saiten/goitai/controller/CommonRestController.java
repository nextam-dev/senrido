/* =============================================================
 * システム名：マキノ祭典　ご遺体管理システム
 * ファイル名：CommonRestController.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.service.MEmployeeService;

/**
 * 共通リクエストコントローラクラス
 *
 * @author tsuruda
 *
 */
@RestController
@RequestMapping(value = "/Common")
public class CommonRestController {

	/** */
	@Autowired
	MessageSource msg;

	// 社員マスタサービス
	@Autowired
	MEmployeeService mEmployeeService;

}
