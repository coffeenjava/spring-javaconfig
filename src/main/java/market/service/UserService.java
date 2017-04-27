package market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import market.dao.UserDao;
import market.model.User;

/**
 * Created by lcrapper on 2017. 4. 25..
 */
@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User getUser(String userId) {
		return userDao.findById(userId);
	}
}
