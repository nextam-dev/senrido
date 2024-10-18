select
  /*%expand*/*
from
  m_code
where
  div_code = /* divCode */''
  and code = /* code */''
  and del_flg is false
order by code