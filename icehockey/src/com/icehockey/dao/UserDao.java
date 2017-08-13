package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.User;
import com.icehockey.util.DBUtil;

public class UserDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private User user = null;
	private PreparedStatement preparedStatement = null;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT * FROM USER, role, handling WHERE USER .roleId = role.roleId AND USER .handlingId = handling.handlingId";
		try {
			conn = util.openConnection();
			rs = statement.executeQuery(sql);
			while (rs.next()) {

				int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				String sex = "man";
				if (rs.getInt("sex") == 1) {
					sex = "man";// '1代表男生0表示女生,默认为1男生',
				} else {
					sex = "lady";
				}
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_User = rs.getString("ice_play");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				String role = rs.getString("roleName");// '角色编号',
				String handing = rs.getString("handingName");// '持杆方式',
				String image = rs.getString("image");// '头像',

				user = new User(userId, weChatId, telephone, userName, sex, password, birthday, country, city, height,
						weight, play, ice_User, snow_play, role, handing, image);

				users.add(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return users;
	}


	public User getUsersByTelephone(String telephoneNumber) {
		// List<user> users=new ArrayList<user>();

		String sql = "SELECT * FROM USER, role, handling WHERE USER .roleId = role.roleId AND USER .handlingId = handling.handlingId AND USER .telephone = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, telephoneNumber);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				String sex = "man";
				if (rs.getInt("sex") == 1) {
					sex = "man";// '1代表男生0表示女生,默认为1男生',
				} else {
					sex = "lady";
				}
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_User = rs.getString("ice_play");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				String role = rs.getString("roleName");// '角色编号',
				String handling = rs.getString("handlingName");// '持杆方式',
				String image = rs.getString("image");// '头像',

				user = new User(userId, weChatId, telephone, userName, sex, password, birthday, country, city, height,
						weight, play, ice_User, snow_play, role, handling, image);

				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User getUserByUserId(int userId) {

		String sql = "SELECT * FROM USER, role, handling WHERE USER .roleId = role.roleId AND USER .handlingId = handling.handlingId and user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				// int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				String sex = "man";
				if (rs.getInt("sex") == 1) {
					sex = "man";// '1代表男生0表示女生,默认为1男生',
				} else {
					sex = "lady";
				}
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_User = rs.getString("ice_play");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				String role = rs.getString("roleName");// '角色编号',
				String handling = rs.getString("handlingName");// '持杆方式',
				String image = rs.getString("image");// '头像',

				user = new User(userId, weChatId, telephone, userName, sex, password, birthday, country, city, height,
						weight, play, ice_User, snow_play, role, handling, image);

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUser(int userId, String playRadioValue, String ice_playRadioValue, String snow_playRadioValue,
			int roleId, int HandlingId) {

		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.play=?, user.ice_play=?,user.snow_play=?, user.roleId=?,user.handlingId=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playRadioValue);
			preparedStatement.setString(2, ice_playRadioValue);
			preparedStatement.setString(3, snow_playRadioValue);
			preparedStatement.setInt(4, roleId);
			preparedStatement.setInt(5, HandlingId);
			preparedStatement.setInt(6, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User insertUser(String telephoneNumber, String UserName, String UserPassword) {
		// INSERT INTO Persons (LastName, Address) VALUES ('Wilson',
		// 'Champs-Elysees')

		String sql = "INSERT INTO User (telephone, userName,password) VALUES (?,?,?)";
		try {

			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, telephoneNumber);
			preparedStatement.setString(2, UserName);
			preparedStatement.setString(3, UserPassword);
			System.out.println(sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println(sql);
				user = getUsersByTelephone(telephoneNumber);
				System.out.println(user);
				return user;
			} else
				System.out.println("插入失败");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	public User updateUserByUserId(int userId, int sex, double height, double weight, String country, String city,
			String xianxiaolijvlebu, String xianxiaoliqiudui) {

		user = getUserByUserId(userId);
		System.out.println(user);

		String sql = "UPDATE User SET sex=?, height=?,weight=?, country=?,city=?,xianxiaolijvlebu=?,xianshuqiudui=? WHERE UserId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, sex);
			preparedStatement.setDouble(2, height);
			preparedStatement.setDouble(3, weight);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, xianxiaolijvlebu);
			preparedStatement.setString(7, xianxiaoliqiudui);

			preparedStatement.setInt(8, userId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			System.out.println("sql:" + sql);

			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserByUserId(int userId, String UserName, double height, double weight, String country,
			String city) {
		user = getUserByUserId(userId);
		System.out.println(user);

		String sql = "UPDATE user SET userName=?, height=?,weight=?, country=?,city=? WHERE UserId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, UserName);
			preparedStatement.setDouble(2, height);
			preparedStatement.setDouble(3, weight);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, city);

			preparedStatement.setInt(6, userId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserByUserId(int userId, int sex, double height, double weight, String country, String city) {
		user = getUserByUserId(userId);
		System.out.println(user);

		String sql = "UPDATE user SET sex=?, height=?,weight=?, country=?,city=? WHERE userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, sex);
			preparedStatement.setDouble(2, height);
			preparedStatement.setDouble(3, weight);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, city);

			preparedStatement.setInt(6, userId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User insertPlayUser(int userId, String playValue) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.play=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playValue);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User insertSelectIceUser(int userId, String ice_play) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.ice_play=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ice_play);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User insertSelectSnowUser(int userId, String snow_play) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.snow_play=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, snow_play);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User insertHandlingUser(int userId, int handlingId) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.handlingId=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, handlingId);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserIce(int userId, String playValue, String ice_playValue) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.play=? , user.ice_play=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playValue);
			preparedStatement.setString(2, ice_playValue);
			preparedStatement.setInt(3, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserSnow(int userId, String playValue, String snow_playValue) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.play=? , user.snow_play=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playValue);
			preparedStatement.setString(2, snow_playValue);
			preparedStatement.setInt(3, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserRole(int userId, int roleId) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.roleId=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, roleId);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserSex(int userId, String gender) {
		user = getUserByUserId(userId);

		System.out.println(user);
		int sex = 1;
		if ("man".equals(gender)) {
			sex = 1;
		} else if ("lady".equals(gender)) {
			sex = 0;
		} else {
			System.out.println("性别输入不合法");
		}
		String sql = "UPDATE user SET user.sex=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, sex);
			preparedStatement.setInt(2, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserByUserIdHM(int userId, double height, double weight) {
		user = getUserByUserId(userId);
		System.out.println(user);

		String sql = "UPDATE user SET  height=?,weight=? WHERE userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setDouble(1, height);
			preparedStatement.setDouble(2, weight);

			preparedStatement.setInt(3, userId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	public User updateUserNameAndImageByUserId(int userId, String userName, String imageUrl) {
		user = getUserByUserId(userId);

		System.out.println(user);

		String sql = "UPDATE user SET user.userName=? , user.image=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, imageUrl);
			preparedStatement.setInt(3, userId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				user = getUserByUserId(userId);
				System.out.println(user);
				return user;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

}
