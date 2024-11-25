package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class TSurveyListener implements EntityListener<TSurvey> {

    @Override
    public void preInsert(TSurvey entity, PreInsertContext<TSurvey> context) {
    }

    @Override
    public void preUpdate(TSurvey entity, PreUpdateContext<TSurvey> context) {
    }

    @Override
    public void preDelete(TSurvey entity, PreDeleteContext<TSurvey> context) {
    }

    @Override
    public void postInsert(TSurvey entity, PostInsertContext<TSurvey> context) {
    }

    @Override
    public void postUpdate(TSurvey entity, PostUpdateContext<TSurvey> context) {
    }

    @Override
    public void postDelete(TSurvey entity, PostDeleteContext<TSurvey> context) {
    }

}
