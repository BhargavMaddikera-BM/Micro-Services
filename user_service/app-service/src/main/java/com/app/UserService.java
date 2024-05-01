package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.BaseService;
import com.app.user.UserVo;


@Service
public class UserService extends BaseService{

	@Autowired
	UserDao userDao;	

	private  Logger logger = Logger.getLogger(UserService.class);


	public UserVo createUser(UserVo userVo)throws ApplicationException {
		logger.info("Entry into method:createUser");
		return userDao.createUser(userVo);
	}

	public UserVo updateUser(UserVo userVo)throws ApplicationException {	
		logger.info("Entry into method:updateUser");
		return userDao.updateUser(userVo);
	}

	public UserVo deleteUser(int id)throws ApplicationException {	
		logger.info("Entry into method:deleteUser");
		return userDao.deleteUser(id);
	}
	
	public List<UserVo>getAllUsers()throws ApplicationException{
		logger.info("Entry into method:getAllUsers");
		return userDao.getAllUsers();
	}
	

	public UserVo getUserDetails(int id)throws ApplicationException {	
		logger.info("Entry into method:getUserDetails");
		return userDao.getUserDetails(id);
	}

	

}
