package jp.nextam.senrido.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.12.0" }, date = "2024-10-21T09:27:40.577+0900")
public class MHaichiEmployeeDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements jp.nextam.senrido.dao.MHaichiEmployeeDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.12.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MHaichiEmployeeDao.class, "insert", jp.nextam.senrido.entity.MHaichiEmployee.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MHaichiEmployeeDao.class, "update", jp.nextam.senrido.entity.MHaichiEmployee.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(jp.nextam.senrido.dao.MHaichiEmployeeDao.class, "delete", jp.nextam.senrido.entity.MHaichiEmployee.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MHaichiEmployeeDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(jp.nextam.senrido.entity.MHaichiEmployee entity) {
        entering("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<jp.nextam.senrido.entity.MHaichiEmployee> __query = getQueryImplementors().createAutoInsertQuery(__method0, jp.nextam.senrido.entity._MHaichiEmployee.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method0, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(jp.nextam.senrido.entity.MHaichiEmployee entity) {
        entering("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<jp.nextam.senrido.entity.MHaichiEmployee> __query = getQueryImplementors().createAutoUpdateQuery(__method1, jp.nextam.senrido.entity._MHaichiEmployee.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl");
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
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method1, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(jp.nextam.senrido.entity.MHaichiEmployee entity) {
        entering("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<jp.nextam.senrido.entity.MHaichiEmployee> __query = getQueryImplementors().createAutoDeleteQuery(__method2, jp.nextam.senrido.entity._MHaichiEmployee.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("jp.nextam.senrido.dao.MHaichiEmployeeDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
