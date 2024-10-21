SELECT
	emp.employee_code
	,emp.abbreviation
FROM
	m_employee emp
	/*%if orderNo != "" && wakeFuneralCategory != ""*/
	INNER JOIN t_service_contract cs
		ON cs.order_no = /*orderNo*/'111'
		AND cs.del_flg = 0
	INNER JOIN t_work_schedule ws
		ON ws.employee_code = emp.employee_code
		AND ws.del_flg = 0
		/*%if wakeFuneralCategory == "1"*/
		AND DATE_FORMAT(cs.vigil_start_time, '%Y-%m-%d') = DATE_FORMAT(ws.working_day, '%Y-%m-%d')
		/*%else*/
		AND DATE_FORMAT(cs.funeral_start_time, '%Y-%m-%d') = DATE_FORMAT(ws.working_day, '%Y-%m-%d')
		/*%end*/
	/*%end*/
where
	emp.del_flg = 0
	/*%if orderNo != "" && wakeFuneralCategory != ""*/
	AND NOT EXISTS(
		SELECT 1 FROM t_service_staffing
		WHERE
			order_no = /*orderNo*/'111'
			AND wake_funeral_category = /*wakeFuneralCategory*/'111'
			AND employee_code = emp.employee_code
			AND del_flg = 0
	)
	/*%end*/