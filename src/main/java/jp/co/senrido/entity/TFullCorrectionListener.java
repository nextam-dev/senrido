package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * Entity Listener for TFullCorrection
 */
public class TFullCorrectionListener implements EntityListener<TFullCorrection> {

    @Override
    public void preInsert(TFullCorrection entity, PreInsertContext<TFullCorrection> context) {
    }

    @Override
    public void preUpdate(TFullCorrection entity, PreUpdateContext<TFullCorrection> context) {
    }

    @Override
    public void preDelete(TFullCorrection entity, PreDeleteContext<TFullCorrection> context) {
    }

    @Override
    public void postInsert(TFullCorrection entity, PostInsertContext<TFullCorrection> context) {
    }

    @Override
    public void postUpdate(TFullCorrection entity, PostUpdateContext<TFullCorrection> context) {
    }

    @Override
    public void postDelete(TFullCorrection entity, PostDeleteContext<TFullCorrection> context) {
    }
}
