package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TDiscomfortFatigue
 */
public class TDiscomfortFatigueListener implements EntityListener<TDiscomfortFatigue> {

    @Override
    public void preInsert(TDiscomfortFatigue entity, PreInsertContext<TDiscomfortFatigue> context) {
    }

    @Override
    public void preUpdate(TDiscomfortFatigue entity, PreUpdateContext<TDiscomfortFatigue> context) {
    }

    @Override
    public void preDelete(TDiscomfortFatigue entity, PreDeleteContext<TDiscomfortFatigue> context) {
    }

    @Override
    public void postInsert(TDiscomfortFatigue entity, PostInsertContext<TDiscomfortFatigue> context) {
    }

    @Override
    public void postUpdate(TDiscomfortFatigue entity, PostUpdateContext<TDiscomfortFatigue> context) {
    }

    @Override
    public void postDelete(TDiscomfortFatigue entity, PostDeleteContext<TDiscomfortFatigue> context) {
    }
}
