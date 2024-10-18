package com.makino_saiten.goitai.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageInfo {

	/**
	 * メッセージ
	 *
	 * <pre>
	 * 埋め字編集後の文字列
	 * </pre>
	 */
	private String message;

	/**
	 * メッセージ種別
	 *
	 * <pre>
	 * E：エラー（赤色）　W：警告（黄色）　I：インフォメーション（青色）
	 * </pre>
	 */
	private String messageType;

	/**
	 * 項目名
	 *
	 * <pre>
	 * 項目名を設定した場合、背景色ピンクにします。項目名未設定の場合、何もしません。
	 * リストの先頭の項目名にフォーカスを当てます。
	 * </pre>
	 */
	private String itemName; // TODO 項目名の物理名は? その他→propertyId

	/**
	 * メッセージ埋め字（論理名）
	 *
	 * <pre>
	 * 呼出元で論理名だけを使用する際は、こちらを使用。
	 * 例外ハンドラクラス内で、設定するため、業務処理内で特に設定不要です。
	 * </pre>
	 */
	private String messageName;

	/**
	 * エラーコード
	 *
	 * <pre>
	 * ある項目に関してのエラーコードを特に設定したい場合、こちらをご利用ください。
	 * </pre>
	 */
	private String errorCd;

}
