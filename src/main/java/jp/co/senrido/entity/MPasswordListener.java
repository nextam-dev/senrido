package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class MPasswordListener implements EntityListener<MPassword> {

    @Override
    public void preInsert(MPassword entity, PreInsertContext<MPassword> context) {
    }

    @Override
    public void preUpdate(MPassword entity, PreUpdateContext<MPassword> context) {
    }

    @Override
    public void preDelete(MPassword entity, PreDeleteContext<MPassword> context) {
    }

    @Override
    public void postInsert(MPassword entity, PostInsertContext<MPassword> context) {
    }

    @Override
    public void postUpdate(MPassword entity, PostUpdateContext<MPassword> context) {
    }

    @Override
    public void postDelete(MPassword entity, PostDeleteContext<MPassword> context) {
    }

}
