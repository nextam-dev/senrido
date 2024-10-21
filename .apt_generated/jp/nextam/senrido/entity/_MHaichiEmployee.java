package jp.nextam.senrido.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.12.0" }, date = "2024-10-21T09:27:40.310+0900")
public final class _MHaichiEmployee extends org.seasar.doma.jdbc.entity.AbstractEntityType<jp.nextam.senrido.entity.MHaichiEmployee> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.12.0");
    }

    private static final _MHaichiEmployee __singleton = new _MHaichiEmployee();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the employeeCode */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $employeeCode = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "employeeCode", "employee_code", __namingType, false);

    /** the employeeNo */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $employeeNo = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "employeeNo", "employee_no", __namingType, true, true, false);

    /** the employeeName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $employeeName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "employeeName", "employee_name", __namingType, true, true, false);

    /** the abbreviation */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $abbreviation = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "abbreviation", "abbreviation", __namingType, true, true, false);

    /** the employeeKana */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $employeeKana = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "employeeKana", "employee_kana", __namingType, true, true, false);

    /** the workDivision */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $workDivision = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "workDivision", "work_division", __namingType, true, true, false);

    /** the secCode */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $secCode = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "secCode", "sec_code", __namingType, true, true, false);

    /** the groupCode */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $groupCode = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "groupCode", "group_code", __namingType, true, true, false);

    /** the positionCode */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $positionCode = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "positionCode", "position_code", __namingType, true, true, false);

    /** the employeeCategoryCode */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $employeeCategoryCode = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "employeeCategoryCode", "employee_category_code", __namingType, true, true, false);

    /** the inputStaffName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $inputStaffName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "inputStaffName", "input_staff_name", __namingType, true, true, false);

    /** the password */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $password = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "password", "password", __namingType, true, true, false);

    /** the chatworkId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $chatworkId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "chatworkId", "chatwork_id", __namingType, true, true, false);

    /** the loginCount */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.Integer, Object> $loginCount = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "loginCount", "login_count", __namingType, true, true, false);

    /** the sortOrder */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.Integer, Object> $sortOrder = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "sortOrder", "sort_order", __namingType, true, true, false);

    /** the createName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $createName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "createName", "create_name", __namingType, true, true, false);

    /** the createDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.time.LocalDateTime, Object> $createDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "createDate", "create_date", __namingType, true, true, false);

    /** the updateName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.String, Object> $updateName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "updateName", "update_name", __namingType, true, true, false);

    /** the updateDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.time.LocalDateTime, Object> $updateDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "updateDate", "update_date", __namingType, true, true, false);

    /** the delFlg */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, java.lang.Boolean, Object> $delFlg = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MHaichiEmployee.class, java.lang.Boolean.class, java.lang.Boolean.class, () -> new org.seasar.doma.wrapper.BooleanWrapper(), null, null, "delFlg", "del_flg", __namingType, true, true, false);

    private final java.util.function.Supplier<jp.nextam.senrido.entity.MHaichiEmployeeListener> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __entityPropertyTypeMap;

    private _MHaichiEmployee() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "MHaichiEmployee";
        __catalogName = "";
        __schemaName = "";
        __tableName = "m_haichi_employee";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __list = new java.util.ArrayList<>(20);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __map = new java.util.HashMap<>(20);
        __idList.add($employeeCode);
        __list.add($employeeCode);
        __map.put("employeeCode", $employeeCode);
        __list.add($employeeNo);
        __map.put("employeeNo", $employeeNo);
        __list.add($employeeName);
        __map.put("employeeName", $employeeName);
        __list.add($abbreviation);
        __map.put("abbreviation", $abbreviation);
        __list.add($employeeKana);
        __map.put("employeeKana", $employeeKana);
        __list.add($workDivision);
        __map.put("workDivision", $workDivision);
        __list.add($secCode);
        __map.put("secCode", $secCode);
        __list.add($groupCode);
        __map.put("groupCode", $groupCode);
        __list.add($positionCode);
        __map.put("positionCode", $positionCode);
        __list.add($employeeCategoryCode);
        __map.put("employeeCategoryCode", $employeeCategoryCode);
        __list.add($inputStaffName);
        __map.put("inputStaffName", $inputStaffName);
        __list.add($password);
        __map.put("password", $password);
        __list.add($chatworkId);
        __map.put("chatworkId", $chatworkId);
        __list.add($loginCount);
        __map.put("loginCount", $loginCount);
        __list.add($sortOrder);
        __map.put("sortOrder", $sortOrder);
        __list.add($createName);
        __map.put("createName", $createName);
        __list.add($createDate);
        __map.put("createDate", $createDate);
        __list.add($updateName);
        __map.put("updateName", $updateName);
        __list.add($updateDate);
        __map.put("updateDate", $updateDate);
        __list.add($delFlg);
        __map.put("delFlg", $delFlg);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PreInsertContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PreUpdateContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PreDeleteContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PostInsertContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PostUpdateContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(jp.nextam.senrido.entity.MHaichiEmployee entity, org.seasar.doma.jdbc.entity.PostDeleteContext<jp.nextam.senrido.entity.MHaichiEmployee> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MHaichiEmployeeListener.class;
        jp.nextam.senrido.entity.MHaichiEmployeeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MHaichiEmployee, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, jp.nextam.senrido.entity.MHaichiEmployee, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public jp.nextam.senrido.entity.MHaichiEmployee newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<jp.nextam.senrido.entity.MHaichiEmployee, ?>> __args) {
        jp.nextam.senrido.entity.MHaichiEmployee entity = new jp.nextam.senrido.entity.MHaichiEmployee();
        if (__args.get("employeeCode") != null) __args.get("employeeCode").save(entity);
        if (__args.get("employeeNo") != null) __args.get("employeeNo").save(entity);
        if (__args.get("employeeName") != null) __args.get("employeeName").save(entity);
        if (__args.get("abbreviation") != null) __args.get("abbreviation").save(entity);
        if (__args.get("employeeKana") != null) __args.get("employeeKana").save(entity);
        if (__args.get("workDivision") != null) __args.get("workDivision").save(entity);
        if (__args.get("secCode") != null) __args.get("secCode").save(entity);
        if (__args.get("groupCode") != null) __args.get("groupCode").save(entity);
        if (__args.get("positionCode") != null) __args.get("positionCode").save(entity);
        if (__args.get("employeeCategoryCode") != null) __args.get("employeeCategoryCode").save(entity);
        if (__args.get("inputStaffName") != null) __args.get("inputStaffName").save(entity);
        if (__args.get("password") != null) __args.get("password").save(entity);
        if (__args.get("chatworkId") != null) __args.get("chatworkId").save(entity);
        if (__args.get("loginCount") != null) __args.get("loginCount").save(entity);
        if (__args.get("sortOrder") != null) __args.get("sortOrder").save(entity);
        if (__args.get("createName") != null) __args.get("createName").save(entity);
        if (__args.get("createDate") != null) __args.get("createDate").save(entity);
        if (__args.get("updateName") != null) __args.get("updateName").save(entity);
        if (__args.get("updateDate") != null) __args.get("updateDate").save(entity);
        if (__args.get("delFlg") != null) __args.get("delFlg").save(entity);
        return entity;
    }

    @Override
    public Class<jp.nextam.senrido.entity.MHaichiEmployee> getEntityClass() {
        return jp.nextam.senrido.entity.MHaichiEmployee.class;
    }

    @Override
    public jp.nextam.senrido.entity.MHaichiEmployee getOriginalStates(jp.nextam.senrido.entity.MHaichiEmployee __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(jp.nextam.senrido.entity.MHaichiEmployee __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MHaichiEmployee getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MHaichiEmployee newInstance() {
        return new _MHaichiEmployee();
    }

    private static class ListenerHolder {
        private static jp.nextam.senrido.entity.MHaichiEmployeeListener listener = new jp.nextam.senrido.entity.MHaichiEmployeeListener();
    }

}
