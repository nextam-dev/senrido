select
   employee_code
 , employee_name
 , employee_kana
 , sec_code
 , case when (group_code is null or group_code = "") THEN 99 ELSE group_code END group_code  
 , position_code
 , employee_category_code
 , input_staff_name
from
  m_employee
where sec_code = /*secCode*/'1110'
 and  del_flg is false
order by group_code
