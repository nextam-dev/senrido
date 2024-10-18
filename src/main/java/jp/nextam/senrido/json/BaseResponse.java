package jp.nextam.senrido.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jp.nextam.senrido.common.GoitaiConstant;
import jp.nextam.senrido.message.MessageInfo;
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

	public void setResultCd(String bussinessError) {
		// TODO Auto-generated method stub
		
	}

	public void setMessageList(List<MessageInfo> messageList2) {
		// TODO Auto-generated method stub
		
	}
}
