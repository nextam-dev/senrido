package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TSymptoms
 */
public class TSymptomsListener implements EntityListener<TSymptoms> {

    @Override
    public void preInsert(TSymptoms entity, PreInsertContext<TSymptoms> context) {
    }

    @Override
    public void preUpdate(TSymptoms entity, PreUpdateContext<TSymptoms> context) {
    }

    @Override
    public void preDelete(TSymptoms entity, PreDeleteContext<TSymptoms> context) {
    }

    @Override
    public void postInsert(TSymptoms entity, PostInsertContext<TSymptoms> context) {
    }

    @Override
    public void postUpdate(TSymptoms entity, PostUpdateContext<TSymptoms> context) {
    }

    @Override
    public void postDelete(TSymptoms entity, PostDeleteContext<TSymptoms> context) {
    }
}
