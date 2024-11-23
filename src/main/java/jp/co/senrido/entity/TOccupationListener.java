package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TOccupation
 */
public class TOccupationListener implements EntityListener<TOccupation> {

    @Override
    public void preInsert(TOccupation entity, PreInsertContext<TOccupation> context) {
    }

    @Override
    public void preUpdate(TOccupation entity, PreUpdateContext<TOccupation> context) {
    }

    @Override
    public void preDelete(TOccupation entity, PreDeleteContext<TOccupation> context) {
    }

    @Override
    public void postInsert(TOccupation entity, PostInsertContext<TOccupation> context) {
    }

    @Override
    public void postUpdate(TOccupation entity, PostUpdateContext<TOccupation> context) {
    }

    @Override
    public void postDelete(TOccupation entity, PostDeleteContext<TOccupation> context) {
    }
}
