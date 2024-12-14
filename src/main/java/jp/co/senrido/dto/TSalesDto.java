package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** �A�� */
    private Integer seq;

    /** ����� */
    private BigDecimal tax;

    /** ���v���z */
    private BigDecimal totalPrice;

    /** ����1 */
    private BigDecimal deposit1;

    /** ������ʃR�[�h1 */
    private String depositKindCd1;

    /** ����2 */
    private BigDecimal deposit2;

    /** ������ʃR�[�h2 */
    private String depositKindCd2;

    /** �c��1 */
    private BigDecimal balance1;

    /** �c����ʃR�[�h1 */
    private String balanceKindCd1;

    /** �c��2 */
    private BigDecimal balance2;

    /** �c����ʃR�[�h2 */
    private String balanceKindCd2;

    /** �t���[���J�[�u�� */
    private Integer frameCurveCount;

    /** �����Y�J�[�u�� */
    private Integer lensCurveCount;

    /** �T�C�Y */
    private Integer size;

    /** �a�[�� */
    private Integer grooveDepth;

    /** �a�� */
    private Integer grooveWidth;

    /** ���H */
    private String processing;

    /** �`�F�b�N */
    private String glassesCheck;

    /** ���n�� */
    private String delivery;

    /** �t�B�b�e�B���O */
    private String fitting;

    /** �����A�� */
    private String completionContact;

    /** �����A������ */
    private String completionContactName;

    /** �����\��� */
    private LocalDate completionScheduledDate;

    /** �����Y������ */
    private LocalDate lensShippingDate;

    /** �A���� */
    private LocalDate contactDate;

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
