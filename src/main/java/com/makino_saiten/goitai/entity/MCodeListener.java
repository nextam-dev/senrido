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
public class MCodeListener implements EntityListener<MCode> {

    @Override
    public void preInsert(MCode entity, PreInsertContext<MCode> context) {
    }

    @Override
    public void preUpdate(MCode entity, PreUpdateContext<MCode> context) {
    }

    @Override
    public void preDelete(MCode entity, PreDeleteContext<MCode> context) {
    }

    @Override
    public void postInsert(MCode entity, PostInsertContext<MCode> context) {
    }

    @Override
    public void postUpdate(MCode entity, PostUpdateContext<MCode> context) {
    }

    @Override
    public void postDelete(MCode entity, PostDeleteContext<MCode> context) {
    }
}