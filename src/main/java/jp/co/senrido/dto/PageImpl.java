package jp.co.senrido.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageImpl<T> implements Page<T>, Serializable {

    private static final long serialVersionUID = -4365096766976038677L;

    List<T> data;

    long count = -1;

    int page = 1;

    int perpage = 10;

    int totalPages = -1;

    /**
     * コンストラクタ
     * 
     * @param data
     * @param pageable
     */
    public PageImpl(List<T> data, Pageable pageable, long count) {
        this.data = (data == null) ? Collections.emptyList() : data;
        this.count = count;
        this.page = pageable.getPage();
        this.perpage = pageable.getPerpage();
        this.totalPages = Math.max(1, (int) Math.ceil((double) count / perpage));
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

	@Override
	public List<T> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}
}