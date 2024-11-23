package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TCriticalVisibilityNeeds
 */
public class TCriticalVisibilityNeedsListener implements EntityListener<TCriticalVisibilityNeeds> {

    @Override
    public void preInsert(TCriticalVisibilityNeeds entity, PreInsertContext<TCriticalVisibilityNeeds> context) {
    }

    @Override
    public void preUpdate(TCriticalVisibilityNeeds entity, PreUpdateContext<TCriticalVisibilityNeeds> context) {
    }

    @Override
    public void preDelete(TCriticalVisibilityNeeds entity, PreDeleteContext<TCriticalVisibilityNeeds> context) {
    }

    @Override
    public void postInsert(TCriticalVisibilityNeeds entity, PostInsertContext<TCriticalVisibilityNeeds> context) {
    }

    @Override
    public void postUpdate(TCriticalVisibilityNeeds entity, PostUpdateContext<TCriticalVisibilityNeeds> context) {
    }

    @Override
    public void postDelete(TCriticalVisibilityNeeds entity, PostDeleteContext<TCriticalVisibilityNeeds> context) {
    }
}
