select
  /*%expand*/*
from
  m_employee
order by
  del_flg,
  employee_code + 0