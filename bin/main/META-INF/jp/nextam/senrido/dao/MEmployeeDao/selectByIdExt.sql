select
    me.*
  , ms.sec_name
from
  m_employee as me
  	left outer join m_section as ms
  	 on(
  	 		me.sec_code = ms.sec_code
  	 	and ms.del_flg is false
  	 )
where
  employee_code = /* employeeCode */'1'
and
  me.del_flg = "0"