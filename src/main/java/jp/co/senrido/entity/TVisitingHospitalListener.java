package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class TVisitingHospitalListener implements EntityListener<TVisitingHospital> {

    @Override
    public void preInsert(TVisitingHospital entity, PreInsertContext<TVisitingHospital> context) {
    }

    @Override
    public void preUpdate(TVisitingHospital entity, PreUpdateContext<TVisitingHospital> context) {
    }

    @Override
    public void preDelete(TVisitingHospital entity, PreDeleteContext<TVisitingHospital> context) {
    }

    @Override
    public void postInsert(TVisitingHospital entity, PostInsertContext<TVisitingHospital> context) {
    }

    @Override
    public void postUpdate(TVisitingHospital entity, PostUpdateContext<TVisitingHospital> context) {
    }

    @Override
    public void postDelete(TVisitingHospital entity, PostDeleteContext<TVisitingHospital> context) {
    }
}