package jp.co.senrido.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TEyeUsageStatusListener.class)
@Table(name = "t_eye_usage_status")
@Data
public class TEyeUsageStatus {

    /** ���q�lID */
    @Id
    @Column(name = "id")
    Integer id;

    /** ���X�� */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** �g�сE�X�}�z�̎g�p���� */
    @Column(name = "use_time_mobile_phone")
    Integer useTimeMobilePhone;

    /** �g�сE�X�}�z�̉�ʂƂ̋��� */
    @Column(name = "distance_mobile_phone")
    Integer distanceMobilePhone;

    /** �p�\�R����� */
    @Column(name = "computer_type")
    String computerType;

    /** �p�\�R����ނ��̑� */
    @Column(name = "computer_type_other")
    String computerTypeOther;

    /** �p�\�R����ޖ��� */
    @Column(name = "computer_type_name")
    String computerTypeName;

    /** �^�u���b�g�̎g�p���� */
    @Column(name = "use_time_tablet")
    Integer useTimeTablet;

    /** �p�\�R���̎g�p���� */
    @Column(name = "use_time_pc")
    Integer useTimePC;

    /** �p�\�R���̎g�p���ԁE�^�u���b�g�̉�ʂƂ̋��� */
    @Column(name = "monitor_ditance")
    Integer monitorDistance;

    /** �Ǐ��̎��� */
    @Column(name = "reading_time")
    Integer readingTime;

    /** �Ǐ��̏K�� */
    @Column(name = "reading_habits")
    String readingHabits;

    /** �Ǐ��̏K������ */
    @Column(name = "reading_habits_name")
    String readingHabitsName;

    /** ���� */
    @Column(name = "number_of_books")
    Integer numberOfBooks;

    /** �{�Ƃ̋��� */
    @Column(name = "distance_book")
    Integer distanceBook;

    /** �����������̋��� */
    @Column(name = "distance_wtitting")
    Integer distanceWriting;

    /** �Q�[���̎��� */
    @Column(name = "game_time")
    Integer gameTime;

    /** �Q�[�� */
    @Column(name = "gaming")
    String gaming;

    /** �Q�[�����̑� */
    @Column(name = "gaming_other")
    String gamingOther;

    /** �Q�[������ */
    @Column(name = "gaming_name")
    String gamingName;

    /** �Q�[���̊�-�����e���r�� */
    @Column(name = "distance_tv_game")
    Integer distanceTVGame;

    /** �Q�[���̊�-�茳�� */
    @Column(name = "distance_game")
    Integer distanceGame;

    /** �e���r�̎��� */
    @Column(name = "tv_time")
    Integer tvTime;

    /** �e���r�Ƃ̋��� */
    @Column(name = "distance_tv")
    Integer distanceTV;

    /** �e���r�̑傫�� */
    @Column(name = "tv_size")
    Integer tvSize;
    
    /** �^�] */
    @Column(name = "driving_habits")
    String drivingHabits;

    /** �^�]���̑� */
    @Column(name = "driving_habits_name")
    String drivingHabitsName;

    /** �^�] */
    @Column(name = "driving")
    String driving;

    /** �^�]���̑� */
    @Column(name = "driving_other")
    String drivingOther;

    /** �^�]�ږ��� */
    @Column(name = "driving_eye_name")
    String drivingEyeName;

    /** �^�]�� */
    @Column(name = "driving_count")
    Integer drivingCount;

    /** �Ƌ���� */
    @Column(name = "license_type")
    String licenseType;

    /** �Ƌ���ނ��̑� */
    @Column(name = "license_type_other")
    String licenseTypeOther;

    /** �Ƌ���ޖ��� */
    @Column(name = "license_type_name")
    String licenseTypeName;

    /** ����Ƌ��X�V�� */
    @Column(name = "next_license_update_date")
    LocalDate nextLicenseUpdateDate;

    /** �폜�t���O */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** �o�^���� */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    @Column(name = "create_id")
    String createId;

    /** �X�V���� */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    @Column(name = "update_id")
    String updateId;
}
