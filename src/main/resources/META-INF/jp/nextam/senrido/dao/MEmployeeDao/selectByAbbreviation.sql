select
  /*%expand*/*
from m_employee
where abbreviation is not null
and employee_code not in (
select
/*%if wakeFuneralCategory != "" && wakeFuneralCategory != null */
	 employee_code
/*%else*/
	staff_code
/*%end*/
from
/*%if wakeFuneralCategory != "" && wakeFuneralCategory != null */
	 t_service_staffing
/*%else*/
	t_funeral_info
/*%end*/
	where order_no = /* orderNo */'112212024'
/*%if wakeFuneralCategory != "" && wakeFuneralCategory != null */
	and wake_funeral_category = /* wakeFuneralCategory */'2'
	and employee_code is not null
/*%else*/
	and staff_code is not null
/*%end*/
)
order by ifnull(employee_no,'9999')
