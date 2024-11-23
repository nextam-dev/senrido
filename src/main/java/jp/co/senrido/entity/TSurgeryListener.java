package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TSurgery
 */
public class TSurgeryListener implements EntityListener<TSurgery> {

    @Override
    public void preInsert(TSurgery entity, PreInsertContext<TSurgery> context) {
    }

    @Override
    public void preUpdate(TSurgery entity, PreUpdateContext<TSurgery> context) {
    }

    @Override
    public void preDelete(TSurgery entity, PreDeleteContext<TSurgery> context) {
    }

    @Override
    public void postInsert(TSurgery entity, PostInsertContext<TSurgery> context) {
    }

    @Override
    public void postUpdate(TSurgery entity, PostUpdateContext<TSurgery> context) {
    }

    @Override
    public void postDelete(TSurgery entity, PostDeleteContext<TSurgery> context) {
    }
}
