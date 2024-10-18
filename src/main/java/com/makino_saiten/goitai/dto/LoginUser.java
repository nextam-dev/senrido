/**
 * 
 */
package com.makino_saiten.goitai.dto;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.makino_saiten.goitai.entity.MEmployee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author t_hirose
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginUser extends User {

    private static final long serialVersionUID = 1L;

    // 追加する（テーブルでユーザーのキーとなる値を設定する）
    public String empNo;

    // 追加する
    public String password;
    
    public String companyCd;

    // 独自で必要な項目
    public String name;

    public LoginUser(MEmployee emp, String password) {
        super(emp.getEmployeeCode(), password, true, true, true, true, new ArrayList<GrantedAuthority>());
        empNo = emp.getEmployeeCode();
        this.password = password;
        name = emp.getEmployeeName();
    }
}