package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for THobbiesClubActivities
 */
public class THobbiesClubActivitiesListener implements EntityListener<THobbiesClubActivities> {

    @Override
    public void preInsert(THobbiesClubActivities entity, PreInsertContext<THobbiesClubActivities> context) {
    }

    @Override
    public void preUpdate(THobbiesClubActivities entity, PreUpdateContext<THobbiesClubActivities> context) {
    }

    @Override
    public void preDelete(THobbiesClubActivities entity, PreDeleteContext<THobbiesClubActivities> context) {
    }

    @Override
    public void postInsert(THobbiesClubActivities entity, PostInsertContext<THobbiesClubActivities> context) {
    }

    @Override
    public void postUpdate(THobbiesClubActivities entity, PostUpdateContext<THobbiesClubActivities> context) {
    }

    @Override
    public void postDelete(THobbiesClubActivities entity, PostDeleteContext<THobbiesClubActivities> context) {
    }
}
