/**
 *
 */
package com.makino_saiten.goitai.controller;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.dto.CodeNameDto;
import com.makino_saiten.goitai.entity.MCode;
import com.makino_saiten.goitai.json.CommonIO;
import com.makino_saiten.goitai.service.MCodeMasterService;
import com.makino_saiten.goitai.service.MEmployeeService;
import com.makino_saiten.goitai.utils.BeanUtils;
import com.makino_saiten.goitai.utils.ObjectUtil;

/**
 * 点呼記録簿リクエスト制御クラス
 *
 * @author hirokawa
 */
@RestController
@RequestMapping(value = "**/g004")
public class G004RestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;

	@Autowired
	private MEmployeeService mEmployeeService;

	@Autowired
	private MessageSource msg;

	/**
	 * 初期表示
	 *
	 * @param form
	 * @return CommonIO
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.POST)
	public CommonIO initData() throws Throwable {
		CommonIO io = new CommonIO();

		io.setResultCd(GoitaiConstant.SUCCESS);
		return io;
	}
}
