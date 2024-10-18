package com.makino_saiten.goitai.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.message.MessageInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * レスポンス基盤クラス
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 結果コード */
	private String resultCd = GoitaiConstant.ResultCd.SUCCESS;

	/** メッセージ情報リスト */
	private List<MessageInfo> messageList;
}
