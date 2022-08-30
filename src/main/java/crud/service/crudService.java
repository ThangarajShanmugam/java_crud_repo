package crud.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dao.crudDao;
import crud.model.crudModel;

@Service
public class crudService {

	@Autowired
	crudDao dao;

	public boolean insertRecord(crudModel model) {

		try {
			return dao.insert(model);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateRecord(int number, String username) {
		try {
			return dao.update(number, username);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public JSONObject displayRecord() {
		try {
			return dao.display();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteRecord(String username) {
		try {
			return dao.delete(username);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
