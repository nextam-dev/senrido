package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TPrescribedLensStrength
 */
public class TPrescribedLensStrengthListener implements EntityListener<TPrescribedLensStrength> {

    @Override
    public void preInsert(TPrescribedLensStrength entity, PreInsertContext<TPrescribedLensStrength> context) {
    }

    @Override
    public void preUpdate(TPrescribedLensStrength entity, PreUpdateContext<TPrescribedLensStrength> context) {
    }

    @Override
    public void preDelete(TPrescribedLensStrength entity, PreDeleteContext<TPrescribedLensStrength> context) {
    }

    @Override
    public void postInsert(TPrescribedLensStrength entity, PostInsertContext<TPrescribedLensStrength> context) {
    }

    @Override
    public void postUpdate(TPrescribedLensStrength entity, PostUpdateContext<TPrescribedLensStrength> context) {
    }

    @Override
    public void postDelete(TPrescribedLensStrength entity, PostDeleteContext<TPrescribedLensStrength> context) {
    }
}
