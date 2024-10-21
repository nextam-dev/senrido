package jp.nextam.senrido.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.12.0" }, date = "2024-10-21T09:27:40.664+0900")
public class MEmployeeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements jp.nextam.senrido.dao.MEmployeeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.12.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectById", java.lang.String.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectAll");

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "insert", jp.nextam.senrido.entity.MEmployee.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "update", jp.nextam.senrido.entity.MEmployee.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "delete", jp.nextam.senrido.entity.MEmployee.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectEmpBySection", int.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectByIdExt", java.lang.String.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectBySecCode", java.lang.String.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectByEmployeeNo", java.lang.String.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectBySortOrder");

    private static final java.lang.reflect.Method __method10 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectByJomuUseEmployee");

    private static final java.lang.reflect.Method __method11 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectUnassignedEmp", java.lang.String.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method12 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectByAbbreviation", java.lang.Integer.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method13 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MEmployeeDao.class, "selectByAbbreviationYmd", java.time.LocalDateTime.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MEmployeeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public jp.nextam.senrido.entity.MEmployee selectById(java.lang.String employeeCode) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectById", employeeCode);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectById.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("employeeCode", java.lang.String.class, employeeCode);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.nextam.senrido.entity.MEmployee> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            jp.nextam.senrido.entity.MEmployee __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectAll() {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectAll.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int insert(jp.nextam.senrido.entity.MEmployee entity) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<jp.nextam.senrido.entity.MEmployee> __query = getQueryImplementors().createAutoInsertQuery(__method2, jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(jp.nextam.senrido.entity.MEmployee entity) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<jp.nextam.senrido.entity.MEmployee> __query = getQueryImplementors().createAutoUpdateQuery(__method3, jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(jp.nextam.senrido.entity.MEmployee entity) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<jp.nextam.senrido.entity.MEmployee> __query = getQueryImplementors().createAutoDeleteQuery(__method4, jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method4, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectEmpBySection(int seq) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectEmpBySection", seq);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectEmpBySection.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("seq", int.class, seq);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectEmpBySection");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectEmpBySection", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectEmpBySection", __e);
            throw __e;
        }
    }

    @Override
    public jp.nextam.senrido.entity.MEmployeeExt selectByIdExt(java.lang.String employeeCode) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByIdExt", employeeCode);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method6);
            __query.setMethod(__method6);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectByIdExt.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployeeExt.getSingletonInternal());
            __query.addParameter("employeeCode", java.lang.String.class, employeeCode);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectByIdExt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<jp.nextam.senrido.entity.MEmployeeExt> __command = getCommandImplementors().createSelectCommand(__method6, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<jp.nextam.senrido.entity.MEmployeeExt>(jp.nextam.senrido.entity._MEmployeeExt.getSingletonInternal()));
            jp.nextam.senrido.entity.MEmployeeExt __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByIdExt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByIdExt", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectBySecCode(java.lang.String secCode) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySecCode", secCode);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method7);
            __query.setMethod(__method7);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectBySecCode.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("secCode", java.lang.String.class, secCode);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectBySecCode");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method7, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySecCode", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySecCode", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectByEmployeeNo(java.lang.String employeeNo) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByEmployeeNo", employeeNo);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method8);
            __query.setMethod(__method8);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectByEmployeeNo.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("employeeNo", java.lang.String.class, employeeNo);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectByEmployeeNo");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method8, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByEmployeeNo", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByEmployeeNo", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectBySortOrder() {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySortOrder");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method9);
            __query.setMethod(__method9);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectBySortOrder.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectBySortOrder");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method9, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySortOrder", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectBySortOrder", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectByJomuUseEmployee() {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByJomuUseEmployee");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method10);
            __query.setMethod(__method10);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectByJomuUseEmployee.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectByJomuUseEmployee");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method10, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByJomuUseEmployee", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByJomuUseEmployee", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectUnassignedEmp(java.lang.String orderNo, java.lang.String wakeFuneralCategory) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectUnassignedEmp", orderNo, wakeFuneralCategory);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method11);
            __query.setMethod(__method11);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectUnassignedEmp.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("orderNo", java.lang.String.class, orderNo);
            __query.addParameter("wakeFuneralCategory", java.lang.String.class, wakeFuneralCategory);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectUnassignedEmp");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method11, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectUnassignedEmp", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectUnassignedEmp", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectByAbbreviation(java.lang.Integer orderNo, java.lang.String wakeFuneralCategory) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviation", orderNo, wakeFuneralCategory);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method12);
            __query.setMethod(__method12);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectByAbbreviation.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("orderNo", java.lang.Integer.class, orderNo);
            __query.addParameter("wakeFuneralCategory", java.lang.String.class, wakeFuneralCategory);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectByAbbreviation");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method12, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviation", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviation", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<jp.nextam.senrido.entity.MEmployee> selectByAbbreviationYmd(java.time.LocalDateTime workingDay) {
        entering("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviationYmd", workingDay);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method13);
            __query.setMethod(__method13);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/jp/nextam/senrido/dao/MEmployeeDao/selectByAbbreviationYmd.sql");
            __query.setEntityType(jp.nextam.senrido.entity._MEmployee.getSingletonInternal());
            __query.addParameter("workingDay", java.time.LocalDateTime.class, workingDay);
            __query.setCallerClassName("jp.nextam.senrido.dao.MEmployeeDaoImpl");
            __query.setCallerMethodName("selectByAbbreviationYmd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<jp.nextam.senrido.entity.MEmployee>> __command = getCommandImplementors().createSelectCommand(__method13, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<jp.nextam.senrido.entity.MEmployee>(jp.nextam.senrido.entity._MEmployee.getSingletonInternal()));
            java.util.List<jp.nextam.senrido.entity.MEmployee> __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviationYmd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MEmployeeDaoImpl", "selectByAbbreviationYmd", __e);
            throw __e;
        }
    }

}
