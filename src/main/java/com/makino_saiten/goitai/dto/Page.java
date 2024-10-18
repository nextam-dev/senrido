/**
 * 
 */
package com.makino_saiten.goitai.dto;

import java.util.List;
/**
 * @author t_hirose
 *
 */
public interface Page<T> extends Pageable {

    /**
     * データを返します。
     * 
     * @return
     */
    List<T> getData();

    /**
     * データ件数を返します。
     * 
     * @return
     */
    long getCount();

    /**
     * ページ数を返します。
     *
     * @return
     */
    int getTotalPages();
}
