select
  /*%expand*/*
from m_employee
where abbreviation is not null
and employee_code not in (
	select
		ifnull(employee_code,'0')
	from
		t_work_schedule tws
	where
 		working_day = /* workingDay */'2022-11-22 00:00:00'
)
order by ifnull(employee_no,'9999')
