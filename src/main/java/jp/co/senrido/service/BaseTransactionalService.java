/**
 *
 */
package jp.co.senrido.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dto.PageFactory;
import jp.co.senrido.dto.Pageable;
import jp.co.senrido.dto.UserDto;
import jp.co.senrido.entity.MCode;
import jp.co.senrido.utils.StringUtil;

/**
 * @author t_hirose
 *
 */
public abstract class BaseTransactionalService extends BaseService {

    @Autowired
    protected PageFactory pageFactory;
    
	@Autowired
	protected MCodeMasterService mCodeMasterService;

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
    
    /**
     * コードを名称に変換する処理.
     * 
     * @param divCode
     * @param codeList
     * @return
     * @throws Throwable
     */
    protected String changeCodeToName(String divCode, List<String> codeList) throws Throwable {
    	
    	List<String> nameList = new ArrayList<>();
    	
    	List<MCode> list = mCodeMasterService.getMCode(divCode);
    	
    	for (String code : codeList) {
    		List<MCode> matches = list.stream()
                    .filter(s -> Objects.equals(s.getCode(), code))
                    .collect(Collectors.toList());
    		
    		if (matches != null && matches.size() > 0) {
    			nameList.add(matches.get(0).getName());
    		}
    	}
    	
    	return String.join(",", nameList);
    }
    
    /**
     * コードを名称に変換する処理.
     * 
     * @param divCode
     * @param code
     * @return
     * @throws Throwable
     */
    protected String changeCodeToName(String divCode, String code) throws Throwable {
    	
    	String name = null;
    	
    	List<MCode> list = mCodeMasterService.getMCode(divCode);
    	
		List<MCode> matches = list.stream()
                .filter(s -> Objects.equals(s.getCode(), code))
                .collect(Collectors.toList());
		
		if (matches != null && matches.size() > 0) {
			name = matches.get(0).getName();
		}
    	
    	return name;
    }
    
    /**
     * カンマ文字列をListに変換する処理.
     * 
     * @param str
     * @param delimita
     * @return List<String>
     * @throws Throwable
     */
    protected List<String> changeCanmaToList(String str, String delimita) throws Throwable {
    	
    	List<String> lsit = new ArrayList();
    	
    	if (StringUtil.isEmpty(str)) {
    		return lsit;
    	}
    	
    	lsit = Arrays.asList(str.split(delimita));
    	
    	return lsit;
    }
}
