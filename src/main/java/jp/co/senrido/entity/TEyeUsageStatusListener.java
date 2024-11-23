package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TEyeUsageStatus
 */
public class TEyeUsageStatusListener implements EntityListener<TEyeUsageStatus> {

    @Override
    public void preInsert(TEyeUsageStatus entity, PreInsertContext<TEyeUsageStatus> context) {
    }

    @Override
    public void preUpdate(TEyeUsageStatus entity, PreUpdateContext<TEyeUsageStatus> context) {
    }

    @Override
    public void preDelete(TEyeUsageStatus entity, PreDeleteContext<TEyeUsageStatus> context) {
    }

    @Override
    public void postInsert(TEyeUsageStatus entity, PostInsertContext<TEyeUsageStatus> context) {
    }

    @Override
    public void postUpdate(TEyeUsageStatus entity, PostUpdateContext<TEyeUsageStatus> context) {
    }

    @Override
    public void postDelete(TEyeUsageStatus entity, PostDeleteContext<TEyeUsageStatus> context) {
    }
}
