/* =============================================================
 * システム名：武蔵野マイページシステム
 * ファイル名：GoogleAuthUserinfoResult.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.http.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {クラスの処理内容を記載}.
 *
 * @author t_hirose
 * @version 2019/04/18
 *
 *
 */
@Data
@NoArgsConstructor
public class GoogleAuthUserinfoResult {

	private String id;
	private String email;
	private String verified_email;
	private String picture;
	private String hd;
}
