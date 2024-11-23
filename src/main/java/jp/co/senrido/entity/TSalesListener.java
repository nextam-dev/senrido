package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TSales
 */
public class TSalesListener implements EntityListener<TSales> {

    @Override
    public void preInsert(TSales entity, PreInsertContext<TSales> context) {
    }

    @Override
    public void preUpdate(TSales entity, PreUpdateContext<TSales> context) {
    }

    @Override
    public void preDelete(TSales entity, PreDeleteContext<TSales> context) {
    }

    @Override
    public void postInsert(TSales entity, PostInsertContext<TSales> context) {
    }

    @Override
    public void postUpdate(TSales entity, PostUpdateContext<TSales> context) {
    }

    @Override
    public void postDelete(TSales entity, PostDeleteContext<TSales> context) {
    }
}
