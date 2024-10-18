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
@Entity(listener = MHaichiEmployeeListener.class)
@Table(name = "m_haichi_employee")
public class MHaichiEmployee {

    /**  */
    @Id
    @Column(name = "employee_code")
    @MessageName("はなこID")
    @NotBlank
    @BiteSize(biteMax = 4,fullCharMax = 2)
    String employeeCode;

    /**  */
    @Column(name = "employee_no")
    @MessageName("従業員番号")
    @BiteSize(biteMax = 4,fullCharMax = 2)
    String employeeNo;

    /**  */
    @Column(name = "employee_name")
    @MessageName("従業員名")
    String employeeName;

    /** 略称（配置システム使用） */
    @Column(name = "abbreviation")
    @MessageName("略称")
    String abbreviation;

    /**  */
    @Column(name = "employee_kana")
    @MessageName("フリガナ")
    String employeeKana;

    /** 役割区分（配置システム使用） */
    @Column(name = "work_division")
    @MessageName("役割区分")
    String workDivision;

    /**  */
    @Column(name = "sec_code")
    @MessageName("部門")
    String secCode;

    /**  */
    @Column(name = "group_code")
    @MessageName("グループ")
    String groupCode;

    /**  */
    @Column(name = "position_code")
    @MessageName("役職")
    String positionCode;

    /**  */
    @Column(name = "employee_category_code")
    @MessageName("社員分類")
    String employeeCategoryCode;

    /**  */
    @Column(name = "input_staff_name")
    @MessageName("入力担当者")
    String inputStaffName;

    /**  */
    @Column(name = "password")
    @MessageName("パスワード")
    String password;

    /**  */
    @Column(name = "chatwork_id")
    String chatworkId;

    /**  */
    @Column(name = "login_count")
    @MessageName("ログイン試行回数")
    int loginCount;

    /**  */
    @Column(name = "sort_order")
    @MessageName("業務担当並び順")
    Integer sortOrder;

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
     * Returns the employeeCode.
     *
     * @return the employeeCode
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * Sets the employeeCode.
     *
     * @param employeeCode the employeeCode
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * Returns the employeeNo.
     *
     * @return the employeeNo
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * Sets the employeeNo.
     *
     * @param employeeNo the employeeNo
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * Returns the employeeName.
     *
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the employeeName.
     *
     * @param employeeName the employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Returns the employeeKana.
     *
     * @return the employeeKana
     */
    public String getEmployeeKana() {
        return employeeKana;
    }

    /**
     * Sets the employeeKana.
     *
     * @param employeeKana the employeeKana
     */
    public void setEmployeeKana(String employeeKana) {
        this.employeeKana = employeeKana;
    }

    /**
     * Returns the secCode.
     *
     * @return the secCode
     */
    public String getSecCode() {
        return secCode;
    }

    /**
     * Sets the secCode.
     *
     * @param secCode the secCode
     */
    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    /**
     * Returns the groupCode.
     *
     * @return the groupCode
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the groupCode.
     *
     * @param groupCode the groupCode
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * Returns the positionCode.
     *
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * Sets the positionCode.
     *
     * @param positionCode the positionCode
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    /**
     * Returns the employeeCategoryCode.
     *
     * @return the employeeCategoryCode
     */
    public String getEmployeeCategoryCode() {
        return employeeCategoryCode;
    }

    /**
     * Sets the employeeCategoryCode.
     *
     * @param employeeCategoryCode the employeeCategoryCode
     */
    public void setEmployeeCategoryCode(String employeeCategoryCode) {
        this.employeeCategoryCode = employeeCategoryCode;
    }

    /**
     * Returns the inputStaffName.
     *
     * @return the inputStaffName
     */
    public String getInputStaffName() {
        return inputStaffName;
    }

    /**
     * Sets the inputStaffName.
     *
     * @param inputStaffName the inputStaffName
     */
    public void setInputStaffName(String inputStaffName) {
        this.inputStaffName = inputStaffName;
    }

    /**
     * Returns the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the loginCount.
     *
     * @return the loginCount
     */
    public int getloginCount() {
        return loginCount;
    }

    /**
     * Sets the loginCount.
     *
     * @param the loginCount
     */
    public void setloginCount(int loginCount) {
        this.loginCount = loginCount;
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

	public String getChatworkId() {
		return chatworkId;
	}

	public void setChatworkId(String chatworkId) {
		this.chatworkId = chatworkId;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation セットする abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return workDivision
	 */
	public String getWorkDivision() {
		return workDivision;
	}

	/**
	 * @param workDivision セットする workDivision
	 */
	public void setWorkDivision(String workDivision) {
		this.workDivision = workDivision;
	}

}