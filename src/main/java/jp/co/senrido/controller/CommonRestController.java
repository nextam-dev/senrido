/* =============================================================
 * システム名：マキノ祭典　ご遺体管理システム
 * ファイル名：CommonRestController.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
