select
  /*%expand*/*
from (
select
  /*%expand*/*
 ,1 as row
from
  m_employee
where
	del_flg = '0'
	and sort_order is not null
union 
select
  /*%expand*/*
 ,2 as row
from
  m_employee
where
	del_flg = '0'
	and sort_order is null
order by
  row,
  sort_order,
  employee_code + 0
) as m_employee
