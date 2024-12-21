SELECT
    mc_shop.name AS shop_name,
    tc.id,
    tc.customer_cd,
    tc.name,
    tc.name_kana,
    tc.birthday_nengo,
    tc.birthday,
    mc_sex.name AS sex,
    tc.sex_other,
    tc.zipcode,
    tc.prefecture_cd,
    tc.address,
    tc.main_contact_type,
    tc.telephone,
    tc.mobile_phone,
    tc.work_phone,
    tc.next_visit_date,
    tc.previous_visit_date,
    mc_person.name AS person_name,
    mc_time_slot.name AS time_slot

FROM
    t_customer tc
INNER JOIN
    t_visit tv
ON
    tc.id = tv.id
LEFT JOIN
    m_code mc_sex
ON
    tc.sex = mc_sex.code
    AND mc_sex.div_code = 'sex'
LEFT JOIN
    m_code mc_shop
ON
    tv.shop_cd = mc_shop.code
    AND mc_shop.div_code = 'shop_cd'
LEFT JOIN
    m_code mc_person
ON
    tc.person_in_charge_cd = mc_person.code
    AND mc_person.div_code = 'person_in_charge_cd'
LEFT JOIN
    m_code mc_time_slot
ON
    tv.time_slot_type = mc_time_slot.code
    AND mc_time_slot.div_code = 'time_slot_type'
WHERE
    /*%if customerSerch.shopCd != "" */
    (tv.shop_cd = /* customerSerch.shopCd */'a' OR /* customerSerch.shopCd */'a' IS NULL) -- 店舗コード
    /*%end*/
    /*%if customerSerch.customerCd != "" */
    AND (tc.customer_cd = /* customerSerch.customerCd */'a' OR /* customerSerch.customerCd */'a' IS NULL) -- 顧客番号
    /*%end*/
    /*%if customerSerch.name != "" */
    AND (tc.name LIKE concat('%', /* customerSerch.name */'a', '%') OR /* customerSerch.name */'a' IS NULL) -- 名前
    /*%end*/
    /*%if customerSerch.nameKana != "" */
    AND (tc.name_kana LIKE concat('%', /* customerSerch.nameKana */'a', '%') OR /* customerSerch.nameKana */'a' IS NULL) -- 名前カナ
    /*%end*/
    /*%if customerSerch.sex != "" */
    AND (tc.sex = /* customerSerch.sex */'a' OR /* customerSerch.sex */'a' IS NULL) -- 性別
    /*%end*/
    /*%if customerSerch.personName != "" */
    AND (tc.person_in_charge_cd = /* customerSerch.personName */'a' OR /* customerSerch.personName */'a' IS NULL) -- 担当者コード
    /*%end*/
    /*%if customerSerch.telephone != "" */
    AND (
        tc.telephone LIKE concat('%', /* customerSerch.telephone */'a', '%') OR
        tc.mobile_phone LIKE concat('%', /* customerSerch.telephone */'a', '%') OR
        tc.work_phone LIKE concat('%', /* customerSerch.telephone */'a', '%') OR
        /* customerSerch.telephone */'a' IS NULL
    ) -- 電話番号検索
    /*%end*/
    /*%if customerSerch.eventDateStart != null && customerSerch.eventDateEnd != null */
	AND (tc.next_visit_date BETWEEN /* customerSerch.eventDateStart */'a' AND /* customerSerch.eventDateEnd */'a')
	/*%end*/
	AND tv.tokyo_measurement_event_flag IS TRUE -- 東京測定会フラグ
    AND tc.del_flg IS FALSE -- 削除フラグ

