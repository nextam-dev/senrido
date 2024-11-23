package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TGlare
 */
public class TGlareListener implements EntityListener<TGlare> {

    @Override
    public void preInsert(TGlare entity, PreInsertContext<TGlare> context) {
    }

    @Override
    public void preUpdate(TGlare entity, PreUpdateContext<TGlare> context) {
    }

    @Override
    public void preDelete(TGlare entity, PreDeleteContext<TGlare> context) {
    }

    @Override
    public void postInsert(TGlare entity, PostInsertContext<TGlare> context) {
    }

    @Override
    public void postUpdate(TGlare entity, PostUpdateContext<TGlare> context) {
    }

    @Override
    public void postDelete(TGlare entity, PostDeleteContext<TGlare> context) {
    }
}
