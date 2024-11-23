package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TGlassesUsage
 */
public class TGlassesUsageListener implements EntityListener<TGlassesUsage> {

    @Override
    public void preInsert(TGlassesUsage entity, PreInsertContext<TGlassesUsage> context) {
    }

    @Override
    public void preUpdate(TGlassesUsage entity, PreUpdateContext<TGlassesUsage> context) {
    }

    @Override
    public void preDelete(TGlassesUsage entity, PreDeleteContext<TGlassesUsage> context) {
    }

    @Override
    public void postInsert(TGlassesUsage entity, PostInsertContext<TGlassesUsage> context) {
    }

    @Override
    public void postUpdate(TGlassesUsage entity, PostUpdateContext<TGlassesUsage> context) {
    }

    @Override
    public void postDelete(TGlassesUsage entity, PostDeleteContext<TGlassesUsage> context) {
    }
}
