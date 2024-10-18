select
  me.*
from
  m_employee as me
  	left outer join m_section as ms on (me.sec_code = ms.sec_code)
where
  ms.seq = /* seq */'a'
