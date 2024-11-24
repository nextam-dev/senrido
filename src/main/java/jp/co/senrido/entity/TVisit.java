/**
 * 
 */
package jp.co.senrido.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

/**
 * @author takam
 *
 */
@Entity(listener = TVisitListener.class)
@Table(name = "t_visit")
@Data
public class TVisit {

	/** お客様ID */
	@Id
	@Column(name = "id")
	Integer id;

	/** 来店日 */
	@Id
	@Column(name = "visit_date")
	String visitDate;

	/** 開始時間 */
	@Column(name = "start_time")
	String startTime;

	/** 終了時間 */
	@Column(name = "end_time")
	String endTime;

	/** 東京測定会フラグ */
	@Column(name = "tokyo_measurement_event_flag")
	Boolean tokyoMeasurementEventFlag;

	/** 店舗コード */
	@Column(name = "shop_cd")
	String shopCd;

	/** 時間枠区分 */
	@Column(name = "time_slot_type")
	String timeSlotType;

	/** 目的 */
	@Column(name = "purpose")
	String purpose;

	/** 初回フラグ */
	@Column(name = "first_time_flag")
	Boolean firstTimeFlag;

	/** アンケート回答フラグ */
	@Column(name = "survey_response_flag")
	Boolean surveyResponseFlag;

	/** アンケート回答日 */
	@Column(name = "survey_response_date")
	String surveyResponseDate;

	/** 通知種別 */
	@Column(name = "notification_type")
	String notificationType;

	/** 削除フラグ */
	@Column(name = "del_flg")
	Boolean delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	LocalDateTime createDate;

	/** 登録者コード */
	@Column(name = "create_id")
	String createId;

	/** 更新日時 */
	@Column(name = "update_date")
	LocalDateTime updateDate;

	/** 更新者コード */
	@Column(name = "update_id")
	String updateId;
}
