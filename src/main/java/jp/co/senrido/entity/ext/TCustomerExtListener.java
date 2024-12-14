package jp.co.senrido.entity.ext;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class TCustomerExtListener implements EntityListener<TCustomerExt> {

    @Override
    public void preInsert(TCustomerExt entity, PreInsertContext<TCustomerExt> context) {
    }

    @Override
    public void preUpdate(TCustomerExt entity, PreUpdateContext<TCustomerExt> context) {
    }

    @Override
    public void preDelete(TCustomerExt entity, PreDeleteContext<TCustomerExt> context) {
    }

    @Override
    public void postInsert(TCustomerExt entity, PostInsertContext<TCustomerExt> context) {
    }

    @Override
    public void postUpdate(TCustomerExt entity, PostUpdateContext<TCustomerExt> context) {
    }

    @Override
    public void postDelete(TCustomerExt entity, PostDeleteContext<TCustomerExt> context) {
    }

}
