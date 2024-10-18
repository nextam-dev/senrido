select
   mc.div_code
 , mc.div_name
 , mc.code
 , mc.name
 , mc.create_name
 , mc.create_date
 , mc.update_name
 , mc.update_date
 , mc.del_flg
from
  m_code as mc
where
      mc.div_code = /* divCode */'a'
/*%if name != null && name != "" */
  and (mc.name like CONCAT('%' , /* name */'a' , '%')
      or mc.name like CONCAT('%' , /* name */'a' , '%'))
/*%end */
/*%if code != null && code != "" */
  and mc.code like CONCAT('%' , /* code */'a' , '%')
/*%end */
  and mc.del_flg is false
order by mc.code + 0
