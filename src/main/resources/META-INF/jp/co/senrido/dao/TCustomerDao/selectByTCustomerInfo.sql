select
  tc.id
  ,tc.customer_cd
  ,tc.name
  ,tc.name_kana
  ,tc.sex
  ,tc.birthday
  ,tc.zipcode
  ,tc.address
  ,tc.main_contact_type
  ,tc.telephone
  ,tc.mobile_phone
  ,tc.work_phone
  ,tc.referrer
  ,tc.mail
  ,tc.next_visit_date
  ,tc.previous_visit_date
  ,mc.name AS sex_name
from
  t_customer  tc
LEFT JOIN
    m_code mc
ON
    tc.sex = mc.code
    AND mc.div_code = 'sex'
where
  id = /* id */0
