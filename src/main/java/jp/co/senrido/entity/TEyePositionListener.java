package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TEyePosition
 */
public class TEyePositionListener implements EntityListener<TEyePosition> {

    @Override
    public void preInsert(TEyePosition entity, PreInsertContext<TEyePosition> context) {
    }

    @Override
    public void preUpdate(TEyePosition entity, PreUpdateContext<TEyePosition> context) {
    }

    @Override
    public void preDelete(TEyePosition entity, PreDeleteContext<TEyePosition> context) {
    }

    @Override
    public void postInsert(TEyePosition entity, PostInsertContext<TEyePosition> context) {
    }

    @Override
    public void postUpdate(TEyePosition entity, PostUpdateContext<TEyePosition> context) {
    }

    @Override
    public void postDelete(TEyePosition entity, PostDeleteContext<TEyePosition> context) {
    }
}
