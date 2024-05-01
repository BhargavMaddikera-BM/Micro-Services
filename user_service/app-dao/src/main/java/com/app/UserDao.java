package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.app.common.BaseDao;
import com.app.user.UserVo;

@Repository
public class UserDao extends BaseDao {

	private Logger logger = Logger.getLogger(UserDao.class);
	
	public UserVo createUser(UserVo userVo)throws ApplicationException {
		logger.info("Entry into method:createUser");
		return userVo;
	}

	public UserVo updateUser(UserVo userVo)throws ApplicationException {	
		logger.info("Entry into method:updateUser");
		return userVo;
	}

	public UserVo deleteUser(int id)throws ApplicationException {	
		logger.info("Entry into method:deleteUser");
		return null;
	}
	
	public List<UserVo>getAllUsers()throws ApplicationException{
		logger.info("Entry into method:getAllUsers");
		return null;
	}
	

	public UserVo getUserDetails(int id)throws ApplicationException {	
		logger.info("Entry into method:getUserDetails");
		return null;
	}


}
