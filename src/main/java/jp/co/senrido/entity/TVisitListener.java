package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class TVisitListener implements EntityListener<TVisit> {

    @Override
    public void preInsert(TVisit entity, PreInsertContext<TVisit> context) {
    }

    @Override
    public void preUpdate(TVisit entity, PreUpdateContext<TVisit> context) {
    }

    @Override
    public void preDelete(TVisit entity, PreDeleteContext<TVisit> context) {
    }

    @Override
    public void postInsert(TVisit entity, PostInsertContext<TVisit> context) {
    }

    @Override
    public void postUpdate(TVisit entity, PostUpdateContext<TVisit> context) {
    }

    @Override
    public void postDelete(TVisit entity, PostDeleteContext<TVisit> context) {
    }

}
