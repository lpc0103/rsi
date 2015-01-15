package lpc.dao;

import java.util.List;
import java.util.Map;

public interface CommonJdbcDao {
	
	public <T> List<T> query(String sql,Class<?> elementType,Map<String, ?> paramMap);

}
