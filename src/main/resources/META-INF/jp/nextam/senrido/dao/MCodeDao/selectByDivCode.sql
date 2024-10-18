select
  /*%expand*/*
from
  m_code
where
  div_code = /* divCode */''
  and del_flg is false
order by disp_order, code