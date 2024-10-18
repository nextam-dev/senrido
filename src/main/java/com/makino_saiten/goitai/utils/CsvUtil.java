/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：CsvUtil.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CSV編集用Utilクラス
 * 
 * @author $Author:  $
 * @version $Revision:  $  $Date:  $
 *
 */
public class CsvUtil {

	private static final Log log = LogFactory.getLog(CsvUtil.class);

	// 改行コード（CSV出力に使用）
	private static final String STR_CRLF = "\r\n";

	/**
     * CSVデータ編集用処理.
     *
     * @param csvitem
     * @param items
     * @return
     */
    public static List<String> editCsvData(String csvitem, List<Map<String, Object>> items) {
        if (StringUtil.isEmpty(csvitem)) {
            return null;
        }
        if (items == null || items.size() == 0) {
            return null;
        }
        List<String> lines = new ArrayList<String>();
        String[] csvitems = csvitem.split(",");
        // 取得件数分繰り返し出力
        for(Map<String, Object> entity: items){
            //プロパティファイルに設定されているカラム分設定
            String line = "";
            Boolean firstLineFlag = true;
            for (String column: csvitems) {
                //最初の項目にはカンマは付けない
                if (firstLineFlag) {
                	firstLineFlag = false;
                }
                else  {
                    line = line + ",";
                }
                line = line + editCsv(entity.get(column));
            }

            lines.add(line);
        }

        return lines;
    }

    /**
     * CSVデータ編集用処理.
     *
     * @param csvitem
     * @param items
     * @return
     */
    public static byte[]  csvToByte(String header, List<String> csvList) {
		String CSVData = null;
		try {
			StringBuilder CSV = new StringBuilder();
			// ヘッダー部設定
			CSV.append(header);
			// データ部設定
			for (String linedata : csvList) {
				// 改行コード設定
				CSV.append(STR_CRLF);
				// 1行分出力
				CSV.append(linedata);
			}
			CSVData =CSV.toString();
		}
		catch(Exception e) {
			System.out.println(e);
			log.error(e.getMessage());
		}
		byte[] streamData = null;
		try {
			if(CSVData != null) {
				streamData = CSVData.getBytes("MS932");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			log.error(e.getMessage());
		}
		return streamData;
    }
    /**
     * CSV用ダブルコーテーション付与メソッド.
     *
     * @return String
     */
    private static String editCsv(Object obj) {
        if (obj == null || "".equals(obj)) {
            return "";
        }

        return "\"" + obj.toString() + "\"";
    }
}
