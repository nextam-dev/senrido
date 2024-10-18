/* =============================================================
 * システム名：武蔵野マイページシステム
 * ファイル名：ChatWorkInfo.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.http.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * チャットワークAPI用DTO.
 *
 * @author t_hirose
 * @version 2019/03/18
 *
 *
 */
@Data
@NoArgsConstructor
public class ChatworkInfo {

	private List<Map<String, String>> feature = new ArrayList<Map<String, String>>();
}
