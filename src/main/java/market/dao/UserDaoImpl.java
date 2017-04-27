package market.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import market.model.User;

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
                    new UserMapper());
                    
        //new BeanPropertyRowMapper(Customer.class));
        
        return result;
        
	}

	@Override
	public List<User> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM user";
		
        List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());
        
        return result;
        
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserNm(rs.getString("user_nm"));
			user.setPhone(rs.getString("phone"));
			user.setComment(rs.getString("comment"));
			return user;
		}
	}

}