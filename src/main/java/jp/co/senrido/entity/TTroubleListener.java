package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TTrouble
 */
public class TTroubleListener implements EntityListener<TTrouble> {

    @Override
    public void preInsert(TTrouble entity, PreInsertContext<TTrouble> context) {
    }

    @Override
    public void preUpdate(TTrouble entity, PreUpdateContext<TTrouble> context) {
    }

    @Override
    public void preDelete(TTrouble entity, PreDeleteContext<TTrouble> context) {
    }

    @Override
    public void postInsert(TTrouble entity, PostInsertContext<TTrouble> context) {
    }

    @Override
    public void postUpdate(TTrouble entity, PostUpdateContext<TTrouble> context) {
    }

    @Override
    public void postDelete(TTrouble entity, PostDeleteContext<TTrouble> context) {
    }
}
