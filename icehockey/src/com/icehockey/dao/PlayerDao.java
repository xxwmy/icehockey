package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.Player;
import com.icehockey.util.DBUtil;

public class PlayerDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Player player = null;
	private PreparedStatement preparedStatement = null;


	public Player getPlayerByUserId(int userId) {

		String sql = "SELECT player.playerId playerId, player.userId userId, player.firstlearningAge firstlearningAge, player.groupName groupName FROM player, USER WHERE player.userId = USER .userId AND USER .userId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				userId = rs.getInt("userId");// '登录编号',				
				String groupName = rs.getString("groupName");// '当前组别',
				player = new Player(playerId, userId, firstlearningAge, groupName);
				return player;
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
		return player;
	}


	public Player insertPlayer(int userId) {
		player = getPlayerByUserId(userId);
		if (player == null) {
			String sql = "INSERT INTO player (userId) VALUES (?)";
			try {

				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					player = getPlayerByUserId(userId);
					System.out.println(player);
					return player;
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
		} else {
			System.out.println("该用户在球员表中已存在");
			return null;
		}
	}

	public Player updatePlayer(int userId, int nowTeachClubId, int nowTeachTeamId) {
		player = getPlayerByUserId(userId);
		if (player != null) {
			String sql = "UPDATE player SET nowLearnClubId=?, nowLearnTeamId=? WHERE userId=?";
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
					player = getPlayerByUserId(userId);
					System.out.println(player);
					System.out.println("更新成功");
					return player;
				} else {
					System.out.println("更新失败");
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

			return player;
		} else {
			System.out.println("该用户在球员表中不存在");
			return null;
		}
	}

}
