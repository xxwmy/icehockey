package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.HandlingDao;
import com.icehockey.dao.RoleDao;
import com.icehockey.dao.UserDao;
import com.icehockey.entity.Coach;
import com.icehockey.entity.Handling;
import com.icehockey.entity.Judge;
import com.icehockey.entity.Player;
import com.icehockey.entity.Role;
import com.icehockey.entity.User;

public class UserService {

	UserDao dao = new UserDao();
	RoleDao roleDao = new RoleDao();
	HandlingDao handlingDao = new HandlingDao();

	PlayerService playerService = new PlayerService();
	CoachService coachService = new CoachService();
	JudgeService judgeService = new JudgeService();

	List<User> users = null;

	User user = null;
	Player player = null;
	Coach coach = null;
	Judge judge = null;
	Role role = null;
	Handling handling = null;

	public User queryByTelepone(String telephone) {
		user = dao.getUsersByTelephone(telephone);
		return user;
	}

	public User insertUser(String telephone, String userName, String password) {
		user = dao.insertUser(telephone, userName, password);
		user = queryByTelepone(telephone);
		if (user != null) {
			System.out.println(user);
			System.out.println("用户表插入成功");
			/*
			 * player=pService.insertPlayer(user.getUserId()); if(player!=null){
			 * System.out.println(player); System.out.println("球员表插入成功"); }
			 */
		}
		return user;
	}

	
	public User loginByTelepone(String telephone, String password) {
		user = dao.getUsersByTelephone(telephone);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				System.out.println("登陆成功");
				return user;
			} else {
				System.out.println("密码错误");
				user = new User();
				user.setUserId(-1);
			}
		} else {
			System.out.println("该用户不存在");
			user = null;
		}
		return user;
	}

	public User queryUserByUserId(int userId) {
		user = dao.getUserByUserId(userId);
		return user;
	}

	public User updateUserNameAndImage(int userId, String userName, String imageUrl) {
		user = queryUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserNameAndImageByUserId(userId, userName, imageUrl);
			if (user != null) {
				System.out.println("第一次登录页面更新成功.....userName:" + userName + "  imageUrl: " + imageUrl);
			}
		}
		return user;
	}

	public User updateUserHeight(int userId, double height) {
		user = queryUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserByUserIdHM(userId, height, user.getWeight());
			if (user != null) {
				System.out.println("第一次登录页面更新成功height....." + height);
			}
		}
		return user;
	}

	public User updateUserWeight(int userId, double weight) {
		user = queryUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserByUserIdHM(userId, user.getHeight(), weight);
			if (user != null) {
				System.out.println("第一次登录页面更新成功weight....." + weight);
			}
		}
		return user;
	}

	public User updateUserSex(int userId, String gender) {
		user = dao.updateUserSex(userId, gender);
		if (user != null) {
			System.out.println("第一次登录页面更新成功gender....." + gender);
		}
		return user;

	}

	public User updateUserByUserId(int userId, String playValue, String ice_playValue, String snow_playValue,
			String roleValue, String handlingValue) {
		role = roleDao.getRoleByRoleValue(roleValue);
		System.out.println(role);
		handling = handlingDao.getHandlingByHandlingValue(handlingValue);
		System.out.println(handling);
		if (role != null) {
			System.out.println(role.toString());
			if (handling != null) {
				System.out.println(handling.toString());
				user = dao.updateUser(userId, playValue, ice_playValue, snow_playValue, role.getRoleId(),
						handling.getHandlingId());
				System.out.println("第一次登录页面更新成功");

			} else {
				System.out.println(handlingValue + "该持杆方式不存在");
				user = null;
			}
		} else {
			System.out.println(roleValue + "该角色不存在");
			user = null;
		}
		return user;
	}

	public User updateUserHandling(int userId, String handlingValue) {
		handling = handlingDao.getHandlingByHandlingValue(handlingValue);
		System.out.println(handling);
		if (handling != null) {
			System.out.println(handling.toString());
			user = dao.insertHandlingUser(userId, handling.getHandlingId());
			System.out.println("持杆方式更新成功....");

		} else {
			System.out.println(handling + "该持杆方式不存在....");
			user = null;
		}
		return user;
	}

	public User updateUserRole(int userId, String roleValue) {
		role = roleDao.getRoleByRoleValue(roleValue);
		System.out.println(role);
		if (role != null) {
			System.out.println(role.toString());
			user = dao.updateUserRole(userId, role.getRoleId());
			System.out.println("第一次登录页面更新成功");

		} else {
			System.out.println(roleValue + "该角色不存在");
			user = null;
		}
		return user;
	}

	public User InsertPlayAndIceByUserId(int userId, String playValue, String ice_playValue) {

		user = dao.updateUserIce(userId, playValue, ice_playValue);
		if (user != null) {
			System.out.println("第一次登录页面更新成功ice_playValue....." + playValue);
		}
		return user;
	}

	public User InsertPlayAndSnowByUserId(int userId, String playValue, String snow_playValue) {

		user = dao.updateUserSnow(userId, playValue, snow_playValue);
		if (user != null) {
			System.out.println("第一次登录页面更新成功snow_playValue....." + playValue);
		}
		return user;
	}

	public User updateUser(int userId, String userName, double height, double weight, String country, String city) {
		user = dao.getUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserByUserId(userId, userName, height, weight, country, city);
		} else {
			System.out.println("该用户不存在user表");
			user = null;
		}
		return user;
	}

}
