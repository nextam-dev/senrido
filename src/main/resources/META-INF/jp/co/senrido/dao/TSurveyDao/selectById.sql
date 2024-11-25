select
  /*%expand*/*
from
  t_survey
where
  del_flg = false
and id = /* id */0
and visit_date = /* visitDate */''

