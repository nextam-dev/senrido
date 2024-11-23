package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TRefraction
 */
public class TRefractionListener implements EntityListener<TRefraction> {

    @Override
    public void preInsert(TRefraction entity, PreInsertContext<TRefraction> context) {
    }

    @Override
    public void preUpdate(TRefraction entity, PreUpdateContext<TRefraction> context) {
    }

    @Override
    public void preDelete(TRefraction entity, PreDeleteContext<TRefraction> context) {
    }

    @Override
    public void postInsert(TRefraction entity, PostInsertContext<TRefraction> context) {
    }

    @Override
    public void postUpdate(TRefraction entity, PostUpdateContext<TRefraction> context) {
    }

    @Override
    public void postDelete(TRefraction entity, PostDeleteContext<TRefraction> context) {
    }
}
