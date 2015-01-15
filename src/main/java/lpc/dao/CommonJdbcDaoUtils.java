package lpc.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonJdbcDaoUtils {

	public static CommonJdbcDao commonJdbcDao;

	
	public static CommonJdbcDao getCommonJdbcDao() {
		return commonJdbcDao;
	}


	@Resource(name="commonJdbcDao")
	public void setCommonJdbcDao(CommonJdbcDao commonJdbcDao) {
		CommonJdbcDaoUtils.commonJdbcDao = commonJdbcDao;
	}


	public static <T> List<T> queryForList(String sql,Class<T> elementType,Map<String, ?> paramMap){
		//return .query(sql, elementType, paramMap);
		
		return getCommonJdbcDao().query(sql, elementType, paramMap);
	}


}
