package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.Coach;
import com.icehockey.util.DBUtil;

public class CoachDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private Coach coach = null;
	private PreparedStatement preparedStatement = null;

	public List<Coach> getCoachs() {
		List<Coach> coachs = new ArrayList<Coach>();

		String sql = "select * from coach";

		try {
			conn = util.openConnection();// 获取链接
			rs = statement.executeQuery(sql);// 执行sql语句
			while (rs.next()) {

				coachs.add(coach);

			}
		} catch (SQLException e) {
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
		return coachs;
	}

	public Coach getCoachBycoachId(int id) {

		String sql = "select * from coach where coachId =?";

		try {
			conn = util.openConnection();// 获取链接
			rs = preparedStatement.executeQuery(sql);
			preparedStatement.setInt(1, id);
			if (rs.next()) {

			} else {
				return null;
			}
		} catch (SQLException e) {
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

		return coach;
	}

	public Coach getCoachByUserId(int userId) {

		String sql = "select * from coach,user where user.userId =coach.userId and coach.userId=?";

		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int coachId = rs.getInt("coachId");// '教练员编号',

				int catagoryId = rs.getInt("catagoryId");// '类别编号',
				int degreeId = rs.getInt("degreeId");// '等级编号',
				int workYear = rs.getInt("workYear");// '执法年限',
				int nowTeachClubId = rs.getInt("nowTeachClubId");// '现执教俱乐部',
				int everTeachCloudId = rs.getInt("everTeachCloudId");// '曾执教俱乐部',
				int nowTeachTeamId = rs.getInt("nowTeachTeamId");// '现执教球队',
				int everTeachTeamId = rs.getInt("everTeachTeamId");// '曾执教球队',
				int nowTeachTeamScore = rs.getInt("nowTeachTeamScore");// '现执教球队最佳战绩',
				int everTeachTeamScore = rs.getInt("everTeachTeamScore");// '曾执教球队最佳战绩',

				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_play");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handlingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				coach = new Coach(coachId, catagoryId, degreeId, workYear, nowTeachClubId, everTeachCloudId,
						nowTeachTeamId, everTeachTeamId, nowTeachTeamScore, everTeachTeamScore, userId, weChatId,
						telephone, userName, sex, password, birthday, country, city, height, weight, play, ice_player,
						snow_play, roleId, handingId, image);
				System.out.println(coach.toString());
			} else {
				System.out.println("CoachDao未找到Coach");
				return null;
			}
		} catch (SQLException e) {
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

		return coach;
	}

	public Coach getCoachByCoachName(String coachName) {

		String sql = "select * from coach where coachName =?";

		try {
			conn = util.openConnection();// 获取链接
			rs = preparedStatement.executeQuery(sql);
			preparedStatement.setString(1, coachName);
			if (rs.next()) {

			} else {
				return null;
			}
		} catch (SQLException e) {
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

		return coach;
	}

	public Coach insertCoach(int userId) {
		coach = getCoachByUserId(userId);
		if (coach == null) {
			String sql = "INSERT INTO coach (userId) VALUES (?)";
			try {

				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					coach = getCoachByUserId(userId);
					System.out.println(coach);
					System.out.println("插入成功");
					return coach;
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

			return coach;
		} else {
			System.out.println("该用户在教练表中已存在");
			return null;
		}
	}

	public Coach updateCoach(int userId, int nowTeachClubId, int nowTeachTeamId) {
		coach = getCoachByUserId(userId);
		if (coach != null) {
			String sql = "UPDATE coach SET nowTeachClubId=?, nowTeachTeamId=? WHERE userId=?";
			try {
				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, nowTeachClubId);
				preparedStatement.setInt(2, nowTeachTeamId);
				preparedStatement.setInt(3, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					coach = getCoachByUserId(userId);
					System.out.println(coach);
					System.out.println("插入成功");
					return coach;
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

			return coach;
		} else {
			System.out.println("该用户在教练表中不存在");
			return null;
		}
	}

}
