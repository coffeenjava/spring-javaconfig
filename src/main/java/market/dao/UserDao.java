package market.dao;

import java.util.List;

import market.model.User;

/**
 * Created by lcrapper on 2017. 4. 25..
 */
public interface UserDao {

	User findById(String id);
	
	List<User> findAll();

}