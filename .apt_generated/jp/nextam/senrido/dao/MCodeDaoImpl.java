package jp.nextam.senrido.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.12.0" }, date = "2024-10-21T09:27:40.529+0900")
public class MCodeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements jp.nextam.senrido.dao.MCodeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.12.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectById", java.lang.String.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectByDivCode", java.lang.String.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectByDivCodeDesc", java.lang.String.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectByDivCodeName", java.lang.String.class, java.lang.String.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectByDivCodeAndDivName", java.lang.String.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MCodeDao.class, "selectByDivCodeAllocation", java.lang.String.class, java.lang.String.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MCodeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public jp.nextam.senrido.entity.MCode selectById(java.lang.String divCode, java.lang.String code) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectById", divCode, code);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectById.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.addParameter("code", java.lang.String.class, code);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.nextam.senrido.entity.MCode> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            jp.nextam.senrido.entity.MCode __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MCode> selectByDivCode(java.lang.String divCode) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCode", divCode);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectByDivCode.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectByDivCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MCode>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MCode> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MCode> selectByDivCodeDesc(java.lang.String divCode) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeDesc", divCode);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectByDivCodeDesc.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectByDivCodeDesc");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MCode>> __command = getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MCode> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeDesc", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeDesc", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MCode> selectByDivCodeName(java.lang.String divCode, java.lang.String code, java.lang.String name) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeName", divCode, code, name);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectByDivCodeName.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.addParameter("code", java.lang.String.class, code);
            __query.addParameter("name", java.lang.String.class, name);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectByDivCodeName");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MCode>> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MCode> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeName", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MCode> selectByDivCodeAndDivName(java.lang.String divCode, java.lang.String divName) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAndDivName", divCode, divName);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectByDivCodeAndDivName.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.addParameter("divName", java.lang.String.class, divName);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectByDivCodeAndDivName");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MCode>> __command = getCommandImplementors().createSelectCommand(__method4, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MCode> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAndDivName", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAndDivName", __e);
            throw __e;
        }
    }

    @Override
    public jp.nextam.senrido.entity.MCode selectByDivCodeAllocation(java.lang.String divCode, java.lang.String code) {
        entering("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAllocation", divCode, code);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MCodeDao/selectByDivCodeAllocation.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MCode.getSingletonInternal());
            __query.addParameter("divCode", java.lang.String.class, divCode);
            __query.addParameter("code", java.lang.String.class, code);
            __query.setCallerClassName("jp.nextam.senrido.dao.MCodeDaoImpl");
            __query.setCallerMethodName("selectByDivCodeAllocation");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.nextam.senrido.entity.MCode> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.nextam.senrido.entity.MCode>(jp.nextam.senrido.entity._MCode.getSingletonInternal()));
            jp.nextam.senrido.entity.MCode __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAllocation", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MCodeDaoImpl", "selectByDivCodeAllocation", __e);
            throw __e;
        }
    }

}
