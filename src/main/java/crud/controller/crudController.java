package crud.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//		public String insertController(@RequestBody String model ) throws ParseException {
//			System.out.println("text : " + model);
//			String result = "";
//			 System.out.println("text : " + model);
//	            JSONParser jsonParser = new JSONParser();
//	            JSONArray Array=new JSONArray();
//	            JSONObject jsonObject = new JSONObject();
//	            JSONObject jsonObject2 = new JSONObject();
//
//	           JSONArray jsonArray=new JSONArray();
//	            try {
//	                 
//	            	jsonObject = (JSONObject) jsonParser.parse(model);
//	                System.out.println("jsonObject : " + jsonObject.get("userdetails"));
//	                Array = (JSONArray) jsonParser.parse(jsonObject.get("userdetails").toString());
//	                System.out.println("Array : " + Array.get(0));
//	                jsonObject2 = (JSONObject) jsonParser.parse(Array.get(0).toString());
//
//	                System.out.println("username : " + jsonObject2.get("username"));
//	                System.out.println("number : " + jsonObject2.get("number"));
//	                jsonArray=service.insertRecord(jsonObject2);
//	             
//	               // return new ResponseEntity<>("Inserted",HttpStatus.OK);
//	            } catch (Exception e) {
//	            	e.printStackTrace();
//	                //return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
//	            }
//	            return "inserted";
//	        }

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

}
