package com.makino_saiten.goitai.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author tsuruda
 *
 */
@Setter
@Getter
public class DefaultPageable implements Pageable {

    int page = 1;

    int perpage = 10;

    public DefaultPageable(int page, int perpage) {
        this.page = page;
        this.perpage = perpage;
    }
}
