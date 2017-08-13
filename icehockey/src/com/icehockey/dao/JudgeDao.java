package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.Judge;
import com.icehockey.util.DBUtil;

public class JudgeDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private Judge judge = null;
	private PreparedStatement preparedStatement = null;

	public List<Judge> getJudges() {
		List<Judge> judges = new ArrayList<Judge>();

		String sql = "select * from judge";

		try {
			conn = util.openConnection();// 获取链接
			rs = statement.executeQuery(sql);// 执行sql语句
			while (rs.next()) {

				judges.add(judge);
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

		return judges;
	}

	public Judge getJudgeById(int id) {

		String sql = "select * from judge where judgeId =?";

		try {
			conn = util.openConnection();// 获取链接
			rs = preparedStatement.executeQuery(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
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
		return judge;
	}

	public Judge getJudgeByUserId(int userId) {
		String sql = "select * from judge,user where user.userId =judge.userId AND judge.userId=?";

		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int judgeId = rs.getInt("judgeId");// '裁判员编号',
				int degreeId = rs.getInt("degreeId");// '等级编号',
				int workYear = rs.getInt("workYear");// '执法年限',
				int supremeOrganizationId = rs.getInt("supremeOrganizationId");// '执法最高赛事编号'
				int mostImportantGameId = rs.getInt("mostImportantGameId");// '执法最重要赛事编号'

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

				judge = new Judge(judgeId, degreeId, workYear, supremeOrganizationId, mostImportantGameId, userId,
						weChatId, telephone, userName, sex, password, birthday, country, city, height, weight, play,
						ice_player, snow_play, roleId, handingId, image);
				System.out.println(judge);
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
		return judge;
	}

	public Judge insertJudge(int userId) {
		judge = getJudgeByUserId(userId);
		if (judge == null) {
			String sql = "INSERT INTO judge (userId) VALUES (?)";
			try {

				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					judge = getJudgeByUserId(userId);
					System.out.println(judge);
					System.out.println("插入成功");
					return judge;
				} else {
					System.out.println("插入失败");
					judge=null;
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
			return judge;

		} else {
			System.out.println("裁判表中该用户已存在");
			return judge;
		}
	}
}
