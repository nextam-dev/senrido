package jp.co.senrido.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class TCustomerListener implements EntityListener<TCustomer> {

    @Override
    public void preInsert(TCustomer entity, PreInsertContext<TCustomer> context) {
    }

    @Override
    public void preUpdate(TCustomer entity, PreUpdateContext<TCustomer> context) {
    }

    @Override
    public void preDelete(TCustomer entity, PreDeleteContext<TCustomer> context) {
    }

    @Override
    public void postInsert(TCustomer entity, PostInsertContext<TCustomer> context) {
    }

    @Override
    public void postUpdate(TCustomer entity, PostUpdateContext<TCustomer> context) {
    }

    @Override
    public void postDelete(TCustomer entity, PostDeleteContext<TCustomer> context) {
    }

}
