/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：PdfController.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.makino_saiten.jomu.common.JomuConstant;
//import com.makino_saiten.jomu.dto.ReportParamDto;
//import com.makino_saiten.jomu.service.reports.RollCallRecordReportsService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping(path = "**/pdf")
public class PdfController extends BaseController {

//	@Autowired
//	RollCallRecordReportsService rollCallRecordReportsService;

	@Autowired
	ApplicationContext context;

	// ページ処理用
	static final Integer PAGE_SOURCE = 0;
	static final Integer PAGE_DISTINATION = 1;

//	/**
//	 * PDF作成(j004)
//	 *
//	 * @param response
//	 * @throws Throwable
//	 */
//	@RequestMapping(path = "/{rollCallRecordNo}/print.pdf", method = RequestMethod.GET)
//	@ResponseBody
//	public void print(HttpServletResponse response, @PathVariable Integer rollCallRecordNo) throws Throwable {
//		String jrxml = JomuConstant.JasperCd.JRXML_ROLLCALL_RECORD;
//
//		// 引数セット
//		ReportParamDto dto = new ReportParamDto();
//		dto.setRollCallRecordNo(rollCallRecordNo);
//		Map<String, Object> params = rollCallRecordReportsService.createPdfParam(dto);
//
//		// テーブル情報を設定
//		JRBeanCollectionDataSource jrBeanCollectionDataSource = (JRBeanCollectionDataSource) params
//				.get("REPORT_DATA_SOURCE");
//
//		// filename取得
//		String filename = createFilename(JomuConstant.JasperCd.TITLE_ROLLCALL_RECORD);
//
//		// レスポンスのコンテントタイプを設定
//		String encodedFilename = URLEncoder.encode(filename, "UTF-8");
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "inline; filename*=UTF-8''" + encodedFilename);
//
//        // ファイル生成
//		JasperPrint jasperPrint = makeJasperPrint(jrxml, params, jrBeanCollectionDataSource, filename);
//
//		// Export PDF Stream
//		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//
//	}
}
