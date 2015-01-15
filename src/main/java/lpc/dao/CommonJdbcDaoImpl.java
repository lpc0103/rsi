package lpc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class CommonJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements CommonJdbcDao{

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> query(String sql, Class<?> elementType,
			Map<String, ?> paramMap) {
		// TODO Auto-generated method stub
		
		List<?> rl = this.getNamedParameterJdbcTemplate().query(sql, paramMap, new BeanPropertyRowMapper(elementType));
		 
		 return (List<T>) rl;
	}
	
}
