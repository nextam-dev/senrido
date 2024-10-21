/**
 *
 */
package jp.co.senrido.service;

import java.time.LocalDateTime;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import jp.co.senrido.dto.PageFactory;
import jp.co.senrido.dto.Pageable;
import jp.co.senrido.dto.UserDto;

/**
 * @author t_hirose
 *
 */
public abstract class BaseTransactionalService extends BaseService {

    @Autowired
    protected PageFactory pageFactory;

    /**
     * SearchOptionsを作成して返します。
     *
     * @param pageable
     * @return
     */
    protected SelectOptions createSearchOptions(Pageable pageable) {
        int page = pageable.getPage();
        int perpage = pageable.getPerpage();
        return createSearchOptions(page, perpage);
    }

    /**
     * SearchOptionsを作成して返します。
     *
     * @param page
     * @param perpage
     * @return
     */
    protected SelectOptions createSearchOptions(int page, int perpage) {
        int offset = (page - 1) * perpage;
        return SelectOptions.get().offset(offset).limit(perpage);
    }

    /**
     * ログイン情報を取得して返します。
     *
     * @param
     * @return
     */
	protected UserDto createUserDto() {
		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDto;
	}

    /**
     * 現在日時を取得して返します。
     *
     * @param
     * @return
     */
    protected LocalDateTime createCurrentDate() {
    	LocalDateTime localTimeNow = LocalDateTime.now();
        return localTimeNow;
    }
}
