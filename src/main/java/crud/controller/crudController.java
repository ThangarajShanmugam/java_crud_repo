package crud.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin(origins="*")
@RequestMapping("/user")
public class crudController {

	@Autowired
	crudService service;

	@PostMapping("/insert")
	public ResponseEntity<String> insertController(@RequestBody crudModel model) {
		try {
			if (service.insertRecord(model)) {
				return new ResponseEntity<String>("Inserted", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
		return null;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateController(@RequestParam int number, String username) {
		try {
			if (service.updateRecord(number, username))
				return new ResponseEntity<String>("Updated", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
		return null;
	}
	
	@GetMapping("/display")
	public JSONObject displayController() {
		try {
			if (service.displayRecord() != null) {

				return new JSONObject(service.displayRecord());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteController(@RequestParam String username) {
		try {
			if (service.deleteRecord(username))
				return new ResponseEntity<String>("Deleted", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
		}
		return null;
	}

}
