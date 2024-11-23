package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TPastMedicalHistory
 */
public class TPastMedicalHistoryListener implements EntityListener<TPastMedicalHistory> {

    @Override
    public void preInsert(TPastMedicalHistory entity, PreInsertContext<TPastMedicalHistory> context) {
    }

    @Override
    public void preUpdate(TPastMedicalHistory entity, PreUpdateContext<TPastMedicalHistory> context) {
    }

    @Override
    public void preDelete(TPastMedicalHistory entity, PreDeleteContext<TPastMedicalHistory> context) {
    }

    @Override
    public void postInsert(TPastMedicalHistory entity, PostInsertContext<TPastMedicalHistory> context) {
    }

    @Override
    public void postUpdate(TPastMedicalHistory entity, PostUpdateContext<TPastMedicalHistory> context) {
    }

    @Override
    public void postDelete(TPastMedicalHistory entity, PostDeleteContext<TPastMedicalHistory> context) {
    }
}
