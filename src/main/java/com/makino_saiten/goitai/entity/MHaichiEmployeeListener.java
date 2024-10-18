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
public class MHaichiEmployeeListener implements EntityListener<MHaichiEmployee> {

    @Override
    public void preInsert(MHaichiEmployee entity, PreInsertContext<MHaichiEmployee> context) {
    }

    @Override
    public void preUpdate(MHaichiEmployee entity, PreUpdateContext<MHaichiEmployee> context) {
    }

    @Override
    public void preDelete(MHaichiEmployee entity, PreDeleteContext<MHaichiEmployee> context) {
    }

    @Override
    public void postInsert(MHaichiEmployee entity, PostInsertContext<MHaichiEmployee> context) {
    }

    @Override
    public void postUpdate(MHaichiEmployee entity, PostUpdateContext<MHaichiEmployee> context) {
    }

    @Override
    public void postDelete(MHaichiEmployee entity, PostDeleteContext<MHaichiEmployee> context) {
    }
}