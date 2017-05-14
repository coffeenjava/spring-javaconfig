package market.dao;

import lombok.extern.slf4j.Slf4j;
import market.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lcrapper on 2017. 4. 25..
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public User findById(String id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", id);
        
		String sql = "SELECT * FROM user WHERE user_id=:userId";
		
		User result = namedParameterJdbcTemplate.queryForObject(
				sql,
				params,
				userMapper
				);

        //new BeanPropertyRowMapper(Customer.class));
        
        return result;
        
	}

	@Override
	public List<User> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM user";
		
        List<User> result = namedParameterJdbcTemplate.query(sql, params, userMapper);
        
        return result;
        
	}

	private RowMapper<User> userMapper = (r,n) -> {
		try {
			return User.builder()
					.userId(r.getString("user_id"))
					.userNm(r.getString("user_nm"))
					.phone(r.getString("phone"))
					.comment(r.getString("comment"))
					.build();
		} catch (SQLException e) {
			return null;
		}
	};
}