select
  /*%expand*/*
from
  m_password
where
  user_cd = /* userCd */'1'
and del_flg = false

