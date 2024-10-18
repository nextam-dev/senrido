select
   employee_code
 , employee_name
 , employee_kana
 , sec_code
 , case when (group_code is null or group_code = "") THEN 99 ELSE group_code END group_code
 , position_code
 , employee_category_code
 , input_staff_name
 , del_flg
from
  m_employee
where employee_no = /*employeeNo*/51
