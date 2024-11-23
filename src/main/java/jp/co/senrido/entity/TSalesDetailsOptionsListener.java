package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TSalesDetailsOptions
 */
public class TSalesDetailsOptionsListener implements EntityListener<TSalesDetailsOptions> {

    @Override
    public void preInsert(TSalesDetailsOptions entity, PreInsertContext<TSalesDetailsOptions> context) {
    }

    @Override
    public void preUpdate(TSalesDetailsOptions entity, PreUpdateContext<TSalesDetailsOptions> context) {
    }

    @Override
    public void preDelete(TSalesDetailsOptions entity, PreDeleteContext<TSalesDetailsOptions> context) {
    }

    @Override
    public void postInsert(TSalesDetailsOptions entity, PostInsertContext<TSalesDetailsOptions> context) {
    }

    @Override
    public void postUpdate(TSalesDetailsOptions entity, PostUpdateContext<TSalesDetailsOptions> context) {
    }

    @Override
    public void postDelete(TSalesDetailsOptions entity, PostDeleteContext<TSalesDetailsOptions> context) {
    }
}
