package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TSalesDetails
 */
public class TSalesDetailsListener implements EntityListener<TSalesDetails> {

    @Override
    public void preInsert(TSalesDetails entity, PreInsertContext<TSalesDetails> context) {
    }

    @Override
    public void preUpdate(TSalesDetails entity, PreUpdateContext<TSalesDetails> context) {
    }

    @Override
    public void preDelete(TSalesDetails entity, PreDeleteContext<TSalesDetails> context) {
    }

    @Override
    public void postInsert(TSalesDetails entity, PostInsertContext<TSalesDetails> context) {
    }

    @Override
    public void postUpdate(TSalesDetails entity, PostUpdateContext<TSalesDetails> context) {
    }

    @Override
    public void postDelete(TSalesDetails entity, PostDeleteContext<TSalesDetails> context) {
    }
}
