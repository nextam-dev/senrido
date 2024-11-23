package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDetailsOptionsDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** �A�� */
    private Integer seq;

    /** �I�v�V�����A�� */
    private Integer optionSeq;

    /** �I�v�V����1 */
    private String option1;

    /** �I�v�V��������1 */
    private String optionName1;

    /** �I�v�V�������z1 */
    private BigDecimal optionPrice1;

    /** �I�v�V����2 */
    private String option2;

    /** �I�v�V��������2 */
    private String optionName2;

    /** �I�v�V�������z2 */
    private BigDecimal optionPrice2;

    /** �I�v�V����3 */
    private String option3;

    /** �I�v�V��������3 */
    private String optionName3;

    /** �I�v�V�������z3 */
    private BigDecimal optionPrice3;

    /** �폜�t���O */
    private Boolean delFlg;

    /** �o�^���� */
    private LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    private String createId;

    /** �X�V���� */
    private LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    private String updateId;
}
