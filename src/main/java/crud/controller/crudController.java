package crud.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crud.model.crudModel;
import crud.service.crudService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class crudController {

	@Autowired
	crudService service;

	@PostMapping("/insert")
	public String insertRecord(@RequestBody String model) {
		System.out.println("model : " + model);
		return service.insertRecord(model);

	}

	@PutMapping("/update")
	public String updateController(@RequestBody String model) {
		System.out.println("...............controller.....");

		service.updateRecord(model);
		return "updated";

	}

	@GetMapping("/display")
	public JSONObject displayController() {
//		JSONArray jsonArray = new JSONArray();
		try {
			if (service.displayRecord() != null) {

				// return jsonArray = service.displayRecord();
				return new JSONObject(service.displayRecord());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@DeleteMapping("/delete")
	public String deleteController(@RequestParam String userId) {
		System.out.println("...............controller....." + userId);
		service.deleteRecord(userId);
		return "deleted";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/insert/validate-email")
	public ResponseEntity<crudModel> validateController(@RequestParam String email) {
		crudModel model = new crudModel();
		try {
			JSONObject toRet = new JSONObject();
			if (service.validateRecord(email).equalsIgnoreCase("success")) {
				toRet.put("isAvailable", true);
				model.setjData(toRet);
				model.setResponseDescription("Email already exist in datatbase");
				model.setResponseMessage("Email already exist in datatbase");
				model.setResponseCode(HttpStatus.ALREADY_REPORTED);
				model.setStatusCode(208);
				model.setValidation(false);
				return new ResponseEntity<crudModel>(model, HttpStatus.OK);
			} else {
				toRet.put("isAvailable", false);
				model.setjData(toRet);
				model.setResponseDescription("Successfully validated");
				model.setResponseMessage("Successfully validated");
				model.setResponseCode(HttpStatus.OK);
				model.setStatusCode(200);
				model.setValidation(true);
				return new ResponseEntity<crudModel>(model, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<crudModel>(model, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
