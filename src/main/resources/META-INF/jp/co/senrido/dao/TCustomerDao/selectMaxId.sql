select
  MAX(id) AS max_id
from
  t_customer
where
  del_flg = false
