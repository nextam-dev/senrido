package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TOngoingDiseasesMedication
 */
public class TOngoingDiseasesMedicationListener implements EntityListener<TOngoingDiseasesMedication> {

    @Override
    public void preInsert(TOngoingDiseasesMedication entity, PreInsertContext<TOngoingDiseasesMedication> context) {
    }

    @Override
    public void preUpdate(TOngoingDiseasesMedication entity, PreUpdateContext<TOngoingDiseasesMedication> context) {
    }

    @Override
    public void preDelete(TOngoingDiseasesMedication entity, PreDeleteContext<TOngoingDiseasesMedication> context) {
    }

    @Override
    public void postInsert(TOngoingDiseasesMedication entity, PostInsertContext<TOngoingDiseasesMedication> context) {
    }

    @Override
    public void postUpdate(TOngoingDiseasesMedication entity, PostUpdateContext<TOngoingDiseasesMedication> context) {
    }

    @Override
    public void postDelete(TOngoingDiseasesMedication entity, PostDeleteContext<TOngoingDiseasesMedication> context) {
    }
}
