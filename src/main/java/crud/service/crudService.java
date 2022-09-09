package crud.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dao.crudDao;

@Service
public class crudService {

	@Autowired
	crudDao dao;

	public String insertRecord(String model) {

		System.out.println("---------------------------------Service");
		return dao.insert(model);
	}

	public String updateRecord(String model) {
		System.out.println(".................service........");
		return dao.update(model);
	}

	public JSONObject displayRecord() {
		try {
			return dao.display();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String deleteRecord(String userId) {
		System.out.println("---------------------------------Service");
		return dao.delete(userId);
	}

	public String validateRecord(String email) {
		System.out.println(".........service");
		return dao.validateRecord(email);
	}

}
