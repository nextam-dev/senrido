package com.makino_saiten.goitai.entity;

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
public class MEmployeeListener implements EntityListener<MEmployee> {

    @Override
    public void preInsert(MEmployee entity, PreInsertContext<MEmployee> context) {
    }

    @Override
    public void preUpdate(MEmployee entity, PreUpdateContext<MEmployee> context) {
    }

    @Override
    public void preDelete(MEmployee entity, PreDeleteContext<MEmployee> context) {
    }

    @Override
    public void postInsert(MEmployee entity, PostInsertContext<MEmployee> context) {
    }

    @Override
    public void postUpdate(MEmployee entity, PostUpdateContext<MEmployee> context) {
    }

    @Override
    public void postDelete(MEmployee entity, PostDeleteContext<MEmployee> context) {
    }
}