package com.makino_saiten.goitai.dto;

import java.util.List;

/**
 * ページファクトリ
 * @author t_hirose
 */
public interface PageFactory {

    /**
     * インスタンスを生成して返します。
     * 
     * @param data
     * @param pageable
     * @param count
     * @param <T>
     * @return
     */
    <T> Page<T> create(List<T> data, Pageable pageable, long count);
}
