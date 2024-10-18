/**
 *
 */
package com.makino_saiten.goitai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.dto.CodeNameDto;
import com.makino_saiten.goitai.json.CommonIO;
import com.makino_saiten.goitai.service.MCodeMasterService;
import com.makino_saiten.goitai.service.MEmployeeService;
import com.makino_saiten.goitai.utils.ObjectUtil;

/**
 * メニューリクエスト制御クラス
 *
 * @author h_kurokawa
 *
 */
@RestController
@RequestMapping(value = "**/list")
public class G002GoitaiListRestController {

	@Autowired
	private MEmployeeService mEmployeeService;

	@Autowired
	private MCodeMasterService mCodeMasterService;

	/**
	 * 初期表示
	 *
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
	 * @return
	 */
//	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
//	public CommonIO searchList(@Valid @RequestBody J003RollCallRecordListForm form) throws Throwable {
//		CommonIO io = new CommonIO();
//
//		RollCallRecordDto dto = new RollCallRecordDto();
//		dto.setOffsetLimit(form.getPage(), form.getPerpage());
//
//		System.out.print(form.getPage());
//		System.out.print(form.getPerpage());
//		System.out.print(dto.getOffset());
//
//		// 検索情報取得
//		List<RollCallRecordDto> rollCallRecordList = j003RollCallRecordListService.searchByAll(dto);
//
//		io.setRollCallRecordList(rollCallRecordList);
//
//		return io;
//	}

}