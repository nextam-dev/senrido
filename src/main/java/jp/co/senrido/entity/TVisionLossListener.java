package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TVisionLoss
 */
public class TVisionLossListener implements EntityListener<TVisionLoss> {

    @Override
    public void preInsert(TVisionLoss entity, PreInsertContext<TVisionLoss> context) {
    }

    @Override
    public void preUpdate(TVisionLoss entity, PreUpdateContext<TVisionLoss> context) {
    }

    @Override
    public void preDelete(TVisionLoss entity, PreDeleteContext<TVisionLoss> context) {
    }

    @Override
    public void postInsert(TVisionLoss entity, PostInsertContext<TVisionLoss> context) {
    }

    @Override
    public void postUpdate(TVisionLoss entity, PostUpdateContext<TVisionLoss> context) {
    }

    @Override
    public void postDelete(TVisionLoss entity, PostDeleteContext<TVisionLoss> context) {
    }
}
