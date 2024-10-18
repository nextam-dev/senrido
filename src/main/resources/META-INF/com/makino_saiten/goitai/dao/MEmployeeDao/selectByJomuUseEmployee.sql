SELECT
  /*%expand*/*
FROM
  m_employee
WHERE
  del_flg IS FALSE
  AND jomu_use_employee_flg IS TRUE
ORDER BY
  sort_order,
  employee_code + 0
