package com.makino_saiten.goitai.dto;
/**
 * ページング可能であることを示す
 * @author t_hirose
 */
public interface Pageable {

    Pageable DEFAULT_PAGEABLE = new DefaultPageable(1, 10);

    Pageable NO_LIMIT_PAGEABLE = new DefaultPageable(1, Integer.MAX_VALUE);

    /**
     * 
     * @return
     */
    int getPage();

    /**
     * 
     * @return
     */
    int getPerpage();
}
