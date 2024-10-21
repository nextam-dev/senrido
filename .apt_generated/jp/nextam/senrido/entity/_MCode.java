package jp.nextam.senrido.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.12.0" }, date = "2024-10-21T09:27:40.319+0900")
public final class _MCode extends org.seasar.doma.jdbc.entity.AbstractEntityType<jp.nextam.senrido.entity.MCode> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.12.0");
    }

    private static final _MCode __singleton = new _MCode();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the divCode */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $divCode = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "divCode", "div_code", __namingType, false);

    /** the divName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $divName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "divName", "div_name", __namingType, true, true, false);

    /** the code */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $code = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "code", "code", __namingType, false);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "name", "name", __namingType, true, true, false);

    /** the dispOrder */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.Integer, Object> $dispOrder = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "dispOrder", "disp_order", __namingType, true, true, false);

    /** the createName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $createName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "createName", "create_name", __namingType, true, true, false);

    /** the createDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.time.LocalDateTime, Object> $createDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "createDate", "create_date", __namingType, true, true, false);

    /** the updateName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.String, Object> $updateName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "updateName", "update_name", __namingType, true, true, false);

    /** the updateDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.time.LocalDateTime, Object> $updateDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "updateDate", "update_date", __namingType, true, true, false);

    /** the delFlg */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, java.lang.Boolean, Object> $delFlg = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(jp.nextam.senrido.entity.MCode.class, java.lang.Boolean.class, java.lang.Boolean.class, () -> new org.seasar.doma.wrapper.BooleanWrapper(), null, null, "delFlg", "del_flg", __namingType, true, true, false);

    private final java.util.function.Supplier<jp.nextam.senrido.entity.MCodeListener> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __entityPropertyTypeMap;

    private _MCode() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "MCode";
        __catalogName = "";
        __schemaName = "";
        __tableName = "m_code";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __list = new java.util.ArrayList<>(10);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> __map = new java.util.HashMap<>(10);
        __idList.add($divCode);
        __list.add($divCode);
        __map.put("divCode", $divCode);
        __list.add($divName);
        __map.put("divName", $divName);
        __idList.add($code);
        __list.add($code);
        __map.put("code", $code);
        __list.add($name);
        __map.put("name", $name);
        __list.add($dispOrder);
        __map.put("dispOrder", $dispOrder);
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
    public void preInsert(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PreInsertContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PreUpdateContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PreDeleteContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PostInsertContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PostUpdateContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(jp.nextam.senrido.entity.MCode entity, org.seasar.doma.jdbc.entity.PostDeleteContext<jp.nextam.senrido.entity.MCode> context) {
        Class __listenerClass = jp.nextam.senrido.entity.MCodeListener.class;
        jp.nextam.senrido.entity.MCodeListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<jp.nextam.senrido.entity.MCode, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, jp.nextam.senrido.entity.MCode, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public jp.nextam.senrido.entity.MCode newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<jp.nextam.senrido.entity.MCode, ?>> __args) {
        jp.nextam.senrido.entity.MCode entity = new jp.nextam.senrido.entity.MCode();
        if (__args.get("divCode") != null) __args.get("divCode").save(entity);
        if (__args.get("divName") != null) __args.get("divName").save(entity);
        if (__args.get("code") != null) __args.get("code").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("dispOrder") != null) __args.get("dispOrder").save(entity);
        if (__args.get("createName") != null) __args.get("createName").save(entity);
        if (__args.get("createDate") != null) __args.get("createDate").save(entity);
        if (__args.get("updateName") != null) __args.get("updateName").save(entity);
        if (__args.get("updateDate") != null) __args.get("updateDate").save(entity);
        if (__args.get("delFlg") != null) __args.get("delFlg").save(entity);
        return entity;
    }

    @Override
    public Class<jp.nextam.senrido.entity.MCode> getEntityClass() {
        return jp.nextam.senrido.entity.MCode.class;
    }

    @Override
    public jp.nextam.senrido.entity.MCode getOriginalStates(jp.nextam.senrido.entity.MCode __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(jp.nextam.senrido.entity.MCode __entity) {
    }

    /**
     * @return the singleton
     */
    public static _MCode getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _MCode newInstance() {
        return new _MCode();
    }

    private static class ListenerHolder {
        private static jp.nextam.senrido.entity.MCodeListener listener = new jp.nextam.senrido.entity.MCodeListener();
    }

}
