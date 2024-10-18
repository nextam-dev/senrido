/**
 *
 */
package com.makino_saiten.goitai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.json.CommonIO;

/**
 * メニューリクエスト制御クラス
 *
 * @author kurokawa
 *
 */
@RestController
@RequestMapping(value = "**/j002Menu")
public class J002MenuRestController {

	@Autowired
//	private J002MenuService j002MenuService;

//	@Autowired
//	private MVehicleService mVehicleService;

	/**
	 * 初期表示
	 *
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.POST)
	public CommonIO initData() throws Throwable {
		CommonIO io = new CommonIO();

		io.setResultCd(GoitaiConstant.SUCCESS);
		return io;
	}

	/**
	 * 検索
	 *
	 * @param form
	 * @param result
	 * @return
	 */
//	@RequestMapping(value = "/search", method = RequestMethod.POST)
//	public CommonIO search(@Valid @RequestBody J002MenuForm form) throws Throwable {
//		CommonIO io = new CommonIO();
//		String vehicleNo = form.getVehicleNo();
//
//		// 初期表示情報取得
//		io = j002MenuService.searchByRollCallRecordNo(vehicleNo);
//
//		return io;
//	}

    /**
     *
     * @return
     */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "/";
	}
}