select
  code
  , name
  , div_name
from
  m_code
where
  div_code = /* divCode */'a'
order by code + 0 desc