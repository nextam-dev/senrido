package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TUsageStatus
 */
public class TUsageStatusListener implements EntityListener<TUsageStatus> {

    @Override
    public void preInsert(TUsageStatus entity, PreInsertContext<TUsageStatus> context) {
    }

    @Override
    public void preUpdate(TUsageStatus entity, PreUpdateContext<TUsageStatus> context) {
    }

    @Override
    public void preDelete(TUsageStatus entity, PreDeleteContext<TUsageStatus> context) {
    }

    @Override
    public void postInsert(TUsageStatus entity, PostInsertContext<TUsageStatus> context) {
    }

    @Override
    public void postUpdate(TUsageStatus entity, PostUpdateContext<TUsageStatus> context) {
    }

    @Override
    public void postDelete(TUsageStatus entity, PostDeleteContext<TUsageStatus> context) {
    }
}
