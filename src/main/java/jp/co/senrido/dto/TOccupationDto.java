package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOccupationDto {

    /** ���q�lID */
    @NotNull
    @MessageName("���q�lID")
    private Integer id;

    /** ���X�� */
    @NotNull
    @MessageName("���X��")
    private LocalDateTime visitDate;

    /** �E�ƁE�E�� */
    @Size(max = 200)
    @MessageName("�E�ƁE�E��")
    private String occupationType;

    /** �d�����e */
    @Size(max = 2000)
    @MessageName("�d�����e")
    private String jobDetails;

    /** �폜�t���O */
    @NotNull
    @MessageName("�폜�t���O")
    private Boolean delFlg;

    /** �o�^���� */
    @NotNull
    @MessageName("�o�^����")
    private LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    @NotBlank
    @Size(max = 8)
    @MessageName("�o�^�҃R�[�h")
    private String createId;

    /** �X�V���� */
    @NotNull
    @MessageName("�X�V����")
    private LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    @NotBlank
    @Size(max = 8)
    @MessageName("�X�V�҃R�[�h")
    private String updateId;
}
