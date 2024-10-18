package com.makino_saiten.goitai.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import com.makino_saiten.goitai.annotation.MessageName;
import com.makino_saiten.goitai.validation.constraints.BiteSize;

/**
 *
 */
@Entity(listener = MCodeListener.class)
@Table(name = "m_code")
public class MCode {

    /**  */
    @Id
    @Column(name = "div_code")
    String divCode;

    /**  */
    @Column(name = "div_name")
    String divName;

    /**  */
    @Id
    @Column(name = "code")
    @MessageName("情報入手経路コード")
    @NotBlank
    @BiteSize(biteMax = 5,fullCharMax = 2)
    String code;

    /**  */
    @Column(name = "name")
    @MessageName("情報入手経路名")
    String name;

    /**  */
    @Column(name = "disp_order")
    Integer dispOrder;

    /**  */
    @Column(name = "create_name")
    String createName;

    /**  */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /**  */
    @Column(name = "update_name")
    String updateName;

    /**  */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /**  */
    @Column(name = "del_flg")
    Boolean delFlg;

    /**
     * Returns the divCode.
     *
     * @return the divCode
     */
    public String getDivCode() {
        return divCode;
    }

    /**
     * Sets the divCode.
     *
     * @param divCode the divCode
     */
    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }

    /**
     * Returns the divName.
     *
     * @return the divName
     */
    public String getDivName() {
        return divName;
    }

    /**
     * Sets the divName.
     *
     * @param divName the divName
     */
    public void setDivName(String divName) {
        this.divName = divName;
    }

    /**
     * Returns the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the dispOrder.
     *
     * @return the dispOrder
     */
    public Integer getDispOrder() {
        return dispOrder;
    }

    /**
     * Sets the dispOrder.
     *
     * @param name the dispOrder
     */
    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }

    /**
     * Returns the createName.
     *
     * @return the createName
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * Sets the createName.
     *
     * @param createName the createName
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * Returns the createDate.
     *
     * @return the createDate
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * Sets the createDate.
     *
     * @param createDate the createDate
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * Returns the updateName.
     *
     * @return the updateName
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * Sets the updateName.
     *
     * @param updateName the updateName
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * Returns the updateDate.
     *
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the updateDate.
     *
     * @param updateDate the updateDate
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Returns the delFlg.
     *
     * @return the delFlg
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * Sets the delFlg.
     *
     * @param delFlg the delFlg
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}