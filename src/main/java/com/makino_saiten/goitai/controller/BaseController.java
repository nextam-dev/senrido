/**
 *
 */
package com.makino_saiten.goitai.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.utils.DateUtil;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;

/**
 * @author hirokawa
 *
 */
@RestController
public class BaseController {

	/**
	 * 1帳票出力処理
	 *
	 * @param page
	 * @param jrxml
	 * @param params
	 * @param pdfData
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public JasperPrint makeJasperPrint(String jrxml, Map<String, Object> params, JRBeanCollectionDataSource dataSource, String filename)
			throws IOException, JRException {
		// Get JRXML template from resources folder
		String resource = "/static/reports/" + jrxml + ".jrxml";

		JasperPrint jasperPrint = null;
		try (InputStream template = PdfController.class.getResourceAsStream(resource)) {

			// jrxmlをコンパイル
			JasperReport report = JasperCompileManager.compileReport(template);

			JRFileVirtualizer virtualizer = new JRFileVirtualizer(2, System
	                .getProperty("java.io.tmpdir"));
			params.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

	        report.getPropertiesMap().setProperty("net.sf.jasperreports.export.pdf.metadata.title", filename);


			// パラメータを埋め込む
			if(dataSource == null) {
				jasperPrint = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
			} else {
				jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
			}

		}
		return jasperPrint;
	}

	/**
	 * PDFファイル名作成
	 *
	 * @param response
	 * @return
	 * @throws Throwable
	 */
	public String createFilename(String title) throws Throwable {
		String filename = null;

		filename = title + "(" + DateUtil.getSysdateFormat(DateUtil.DATE_FORMAT_TIMESTAMP) + ")";

		return filename;
	}

}
