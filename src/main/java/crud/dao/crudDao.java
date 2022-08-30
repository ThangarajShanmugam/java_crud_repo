package crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class crudDao {
	public final String url = "jdbc:postgresql://localhost:5432/crudDb", uName = "postgres", pass = "admin";

	@SuppressWarnings("unchecked")
	public String insert(String model) {
		
		  System.out.println("-----------------------------DAO");



	       System.out.println("text : " + model);
	        String result = "";



	       JSONParser jsonParser = new JSONParser();
	        JSONArray Array = new JSONArray();
	        JSONObject jsonObject = new JSONObject();
	        JSONObject jsonObject2 = new JSONObject();



	       try {
	            jsonObject = (JSONObject) jsonParser.parse(model);
	            System.out.println("jsonObject : " + jsonObject.get("userdetails"));
	            Array = (JSONArray) jsonParser.parse(jsonObject.get("userdetails").toString());
	            System.out.println("Array : " + Array.get(0));
	            for (int i = 0; i < Array.size(); i++) {
	                jsonObject2 = (JSONObject) jsonParser.parse(Array.get(i).toString());



	               System.out.println("username : " + jsonObject2.get("username"));
	                System.out.println("number : " + jsonObject2.get("number"));
	                System.out.println("email :"+jsonObject2.get("email"));
	                String sql = "INSERT INTO crud(username,number,\"userId\",email)" + "VALUES('" + jsonObject2.get("username")
	                        + "', " + jsonObject2.get("number") + ",gen_random_uuid(),'"+ jsonObject2.get("email") +"')";
	                try (Connection connection = DriverManager.getConnection(url, uName, pass);
	                        PreparedStatement pst = connection.prepareStatement(sql);) {
	                    int count = pst.executeUpdate();
	                    System.out.println(count);



	                   if (count == 1) {
	                        result = "inserted data";
	                        System.out.println("success");
	                    } else {
	                        result = "not inserted data";
	                        System.out.println("failure");
	                    }



	               } catch (Exception e) {
	                    e.printStackTrace();
	                    return "connection error";
	                }
	            }



	           System.out.println("Inserted records into the table...");
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	             return "Failure";
	        }
	        // return "success";



	   }
	

//		System.out.println("-----------------------------DAO");
//
//		System.out.println("text : " + model);
//		String result = "";
//
//		JSONParser jsonParser = new JSONParser();
//		JSONArray Array = new JSONArray();
//		JSONObject jsonObject = new JSONObject();
//		JSONObject jsonObject2 = new JSONObject();
//		try {
//			jsonObject = (JSONObject) jsonParser.parse(model);
//			System.out.println("jsonObject : " + jsonObject.get("userdetails"));
//			Array = (JSONArray) jsonParser.parse(jsonObject.get("userdetails").toString());
//			System.out.println("Array : " + Array.get(0));
//			for (int i = 0; i < Array.size(); i++) {
//				jsonObject2 = (JSONObject) jsonParser.parse(Array.get(i).toString());
//
//				System.out.println("username : " + jsonObject2.get("username"));
//				System.out.println("number : " + jsonObject2.get("number"));
//				System.out.println("email :" + jsonObject2.get("email"));
//			
//			Array.add(jsonObject2);
////			jsonObject.put("userdetails", Array);
//
//			String sql = "INSERT INTO crud(username,number,\"userId\",email)" + "VALUES('" + jsonObject2.get("username")
//					+ "', " + jsonObject2.get("number") + ",gen_random_uuid(),'" + jsonObject2.get("email") + "')";
//			try (Connection connection = DriverManager.getConnection(url, uName, pass);
//					PreparedStatement pst = connection.prepareStatement(sql);) {
//				int count = pst.executeUpdate();
//				System.out.println(count);
//
//				if (count == 1) {
//					result = "inserted data";
//					System.out.println("success");
//				} else {
//					result = "not inserted data";
//					System.out.println("failure");
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "connection error";
//			}
//			}
//			System.out.println("Inserted records into the table...");
//			return result;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return "fail";
//		}
//		// return jsonObject;
//		
//
//
//	}

	public String update(String model) {
		System.out.println("-----------------------------DAO");
		JSONParser jsonParser = new JSONParser();
		JSONArray Array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObj = new JSONObject();

		try {
			jsonObject = (JSONObject) jsonParser.parse(model);
			System.out.println("jsonObject : " + jsonObject.get("userdetails"));
			Array = (JSONArray) jsonParser.parse(jsonObject.get("userdetails").toString());
			System.out.println("Array : " + Array.get(0));

			for (int i = 0; i < Array.size(); i++) {
				jsonObj = (JSONObject) jsonParser.parse(Array.get(i).toString());
				System.out.println("username : " + jsonObj.get("username"));
				System.out.println("number : " + jsonObj.get("number"));

				String sql = "update crud set username= '" + jsonObj.get("username") + "'where number= '"
						+ jsonObj.get("number") + "'";
				Connection con = DriverManager.getConnection(url, uName, pass);
				PreparedStatement pst = con.prepareStatement(sql);
				pst.executeUpdate();
				con.close();
				System.out.println("updated record of username:" + jsonObject.get("username") + " in the table...");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "success";
	}

	@SuppressWarnings("unchecked")
	public JSONObject display() {
		String query = "select * from crud";
		// JSONObject resultObjectData = new JSONObject();
		JSONObject resultData = new JSONObject();
		// JSONObject resultObjectData = new JSONObject();

		JSONArray resultArray = new JSONArray();
		try (Connection connection = DriverManager.getConnection(url, uName, pass);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);) {
			while (rs.next()) {
				JSONObject resultObject = new JSONObject();
				resultObject.put("username", rs.getString("username"));
				resultObject.put("number", rs.getInt("number"));
				resultObject.put("userId", rs.getString("userId"));
				resultObject.put("email", rs.getString("email"));
				resultArray.add(resultObject);
			}
			// return new JSONObject(resultArray);
			resultData.put("userdetails", resultArray);
			// resultObjectData.put("JData", resultData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;

	}

	public String delete(String userId) {
		System.out.println("-----------------------------DAO" + userId);

		try {
			String sql = "delete from crud where \"userId\" = '" + userId + "' ";
			System.out.println(sql);
			Connection con = DriverManager.getConnection(url, uName, pass);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			con.close();
			System.out.println("delete record of userId:" + userId + " in the table...");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

}
