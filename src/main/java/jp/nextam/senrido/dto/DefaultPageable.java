package jp.nextam.senrido.dto;

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

	@Override
	public int getPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPerpage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
