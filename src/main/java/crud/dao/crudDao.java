package crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import crud.model.crudModel;

@Component
public class crudDao {
	public final String url = "jdbc:postgresql://localhost:5432/crudDb", uName = "postgres", pass = "admin";

	public boolean insert(crudModel model) {
		try {

			String sql = "INSERT INTO crud" + "(username,number)" + "VALUES ('raj', 101)";

			sql = sql.replace(":username", model.getUsername()).replace(":number", String.valueOf(model.getNumber()));
			System.out.println("query::" + sql);
			Connection con = DriverManager.getConnection(url, uName, pass);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
			con.close();
			System.out.println("Inserted records into the table...");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(int number, String username) {
		try {
			String sql = "update crud set number= '" + number + "'where username= '" + username + "'";
			Connection con = DriverManager.getConnection(url, uName, pass);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
			con.close();
			System.out.println("updated record of username:" + username + "in the table...");
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	@SuppressWarnings("unchecked")
	public JSONObject display() {
		JSONObject result = new JSONObject();
		try {
			String sql = "Select * from crud ";
			// + "where number = '" + number + "'";
			Connection con = DriverManager.getConnection(url, uName, pass);
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			// System.out.println("Records of number : " + number);
			while (rs.next()) {

				result.put("userName", rs.getString("username"));
				result.put("number", rs.getString("number"));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(String username) {
		try {
			String sql = "delete from crud where username ='" + username + "'";
			Connection con = DriverManager.getConnection(url, uName, pass);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
			con.close();
			System.out.println("delete record of username:" + username + "in the table...");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
