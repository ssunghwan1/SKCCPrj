package com.skcc.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParcelController {
	@Resource(name = "sampleService")
	private SampleService sampleService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/RegPet.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject RegPet(@RequestBody JSONObject oJSONRequest) throws Exception {
		//insertPet
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();

		commandMap.put("Id", oJSONRequest.get("Id"));
		commandMap.put("PetName",oJSONRequest.get("PetName"));
		commandMap.put("Age", oJSONRequest.get("Age"));
		commandMap.put("Gender", oJSONRequest.get("Gender"));
		commandMap.put("Neutral",oJSONRequest.get("Neutral"));
		commandMap.put("Deposit", oJSONRequest.get("Deposit"));
		commandMap.put("StartDate", oJSONRequest.get("StartDate"));
		commandMap.put("EndDate",oJSONRequest.get("EndDate"));
		commandMap.put("ImgPath1",oJSONRequest.get("ImgPath1"));
		commandMap.put("ImgPath2",oJSONRequest.get("ImgPath2"));
		commandMap.put("ImgPath3",oJSONRequest.get("ImgPath3"));
		commandMap.put("Description",oJSONRequest.get("Description"));
		commandMap.put("RegDate",oJSONRequest.get("RegDate"));
		commandMap.put("StatusValue",oJSONRequest.get("StatusValue"));
		commandMap.put("Breeds",oJSONRequest.get("Breeds"));
		commandMap.put("Address1", oJSONRequest.get("Address1"));
		commandMap.put("Address2", oJSONRequest.get("Address2"));
		int result = sampleService.insertPet(commandMap);
		System.out.println("result : " + result);
		if (result == 1) {
			jsonObj.put("result", "true");
		}else {
			jsonObj.put("result", "false");
		}
		return jsonObj;
	}
	
	@RequestMapping(value = "/selectPetList.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONArray selectPetList(@RequestBody JSONObject oJSONRequest) throws Exception {
		//selectPetList
		JSONObject jsonObj;
		JSONArray jsonArr = new JSONArray();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("Id", oJSONRequest.get("Id"));
		commandMap.put("Address1", oJSONRequest.get("Address1"));
		commandMap.put("Address2", oJSONRequest.get("Address2"));
		commandMap.put("Seq", oJSONRequest.get("Seq"));
		List<Map<String, Object>> list = sampleService.selectPetList(commandMap);
		System.out.println("result : " + list);
		for(int i=0; i<list.size(); i++) {
			jsonObj = new JSONObject();
			jsonObj.put("Id", list.get(i).get("ID"));
			jsonObj.put("PetName", list.get(i).get("PETNAME"));
			jsonObj.put("Age", list.get(i).get("AGE"));
			jsonObj.put("Gender", list.get(i).get("GENDER"));
			jsonObj.put("Neutral", list.get(i).get("NEUTRAL"));
			jsonObj.put("Deposit", list.get(i).get("DEPOSIT"));
			jsonObj.put("StartDate", list.get(i).get("STARTDATE"));
			jsonObj.put("EndDate", list.get(i).get("ENDDATE"));
			jsonObj.put("ImgPath1", list.get(i).get("IMGPATH1"));
			jsonObj.put("ImgPath2", list.get(i).get("IMGPATH2"));
			jsonObj.put("ImgPath3", list.get(i).get("IMGPATH3"));
			jsonObj.put("Description", list.get(i).get("DESCRIPTION"));
			jsonObj.put("StatusValue", list.get(i).get("STATUSVALUE"));
			jsonObj.put("RequestCnt", list.get(i).get("REQUESTCNT"));
			jsonObj.put("Seq", list.get(i).get("SEQ"));
			jsonObj.put("Breeds", list.get(i).get("BREEDS"));
			jsonObj.put("Address1", list.get(i).get("ADDRESS1"));
			jsonObj.put("Address2", list.get(i).get("ADDRESS2"));
			jsonArr.add(jsonObj);
		}
		return jsonArr;
	}
	
	@RequestMapping(value = "/updatePetDetail.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject updatePetDetail(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("seq", oJSONRequest.get("seq"));
		commandMap.put("statusvalue", oJSONRequest.get("statusvalue").toString());
		int result = sampleService.updatePetDetail(commandMap);
		System.out.println("result : " + result);
		if(result > 0) {
			jsonObj.put("Result", "true");
		}else {
			jsonObj.put("Result", "false");
		}
		return jsonObj;
	}
	
	
	@RequestMapping(value = "/selectPetDetail.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONArray selectPetDetail(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj;
		JSONArray jsonArr = new JSONArray();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("seq", oJSONRequest.get("seq"));
		List<Map<String, Object>> list = sampleService.selectPetDetail(commandMap);
		System.out.println("result : " + list);
	 
		for(int i=0; i<list.size(); i++) {
			jsonObj = new JSONObject();
			jsonObj.put("id", list.get(i).get("id"));
			jsonObj.put("title", list.get(i).get("title"));
			jsonObj.put("seq", list.get(i).get("seq"));
			jsonObj.put("statusvalue", list.get(i).get("statusvalue"));
			jsonArr.add(jsonObj);
		}
		return jsonArr;
	}
	

	@RequestMapping(value = "/insertReqPet.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject requestPet(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("Id", oJSONRequest.get("Id"));
		commandMap.put("PetSeq", oJSONRequest.get("PetSeq"));
		commandMap.put("ReqName", oJSONRequest.get("ReqName"));
		commandMap.put("PhoneNum", oJSONRequest.get("PhoneNum"));
		commandMap.put("Job", oJSONRequest.get("Job"));
		commandMap.put("FamilyNum", oJSONRequest.get("FamilyNum"));
		commandMap.put("CommentDesc", oJSONRequest.get("CommentDesc"));
		commandMap.put("Experience", oJSONRequest.get("Experience"));
		int result = sampleService.insertReqPet(commandMap);
		System.out.println("result : " + result);
		if(result > 0) {
			jsonObj.put("Result", "true");
		}else {
			jsonObj.put("Result", "false");
		}
		return jsonObj;
	}
	@RequestMapping(value = "/insertContract.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject insertContract(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("PetSeq", oJSONRequest.get("PetSeq"));
		commandMap.put("OwnerId", oJSONRequest.get("OwnerId"));
		commandMap.put("PreOwnerId", oJSONRequest.get("PreOwnerId"));
	
		int result = sampleService.insertContract(commandMap);
		System.out.println("result : " + result);
		if(result > 0) {
			jsonObj.put("Result", "true");
		}else {
			jsonObj.put("Result", "false");
		}
		return jsonObj;
	}
	@RequestMapping(value = "/selectReqPet.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONArray selectReqPet(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		Map<String, Object> commandMap = new HashMap();
		String type = oJSONRequest.get("Type").toString();
		commandMap.put("Id", oJSONRequest.get("Id"));
		commandMap.put("Type", oJSONRequest.get("Type"));
		commandMap.put("Seq", oJSONRequest.get("Seq"));
		if(type.equals("2")) {
			List<Map<String, Object>> list = sampleService.selectReqPet2(commandMap);
			System.out.println("result : " + list);
			if(list.size() > 0) {
				System.out.println("result : " + list);
				for(int i=0; i<list.size(); i++) {
					jsonObj = new JSONObject();
					jsonObj.put("Id", list.get(i).get("ID"));
					jsonObj.put("PetName", list.get(i).get("PETNAME"));
					jsonObj.put("Age", list.get(i).get("AGE"));
					jsonObj.put("Gender", list.get(i).get("GENDER"));
					jsonObj.put("Neutral", list.get(i).get("NEUTRAL"));
					jsonObj.put("Deposit", list.get(i).get("DEPOSIT"));
					jsonObj.put("StartDate", list.get(i).get("STARTDATE"));
					jsonObj.put("EndDate", list.get(i).get("ENDDATE"));
					jsonObj.put("ImgPath1", list.get(i).get("IMGPATH1"));
					jsonObj.put("ImgPath2", list.get(i).get("IMGPATH2"));
					jsonObj.put("ImgPath3", list.get(i).get("IMGPATH3"));
					jsonObj.put("Description", list.get(i).get("DESCRIPTION"));
					jsonObj.put("StatusValue", list.get(i).get("STATUSVALUE"));
					jsonObj.put("RequestCnt", list.get(i).get("REQUESTCNT"));
					jsonObj.put("Seq", list.get(i).get("SEQ"));
					jsonObj.put("Breeds", list.get(i).get("BREEDS"));
					jsonObj.put("Address1", list.get(i).get("ADDRESS1"));
					jsonObj.put("Address2", list.get(i).get("ADDRESS2"));
					jsonArr.add(jsonObj);
				}
			}else {
				jsonObj.put("Result", "false");
				jsonArr.add(jsonObj);
			}
			
		}else {
			
			List<Map<String, Object>> list = sampleService.selectReqPet(commandMap);	
			System.out.println("result : " + list);
			if(list.size() > 0) {
				for(int i=0; i<list.size(); i++) {
					jsonObj = new JSONObject();
					jsonObj.put("Seq", list.get(i).get("SEQ"));
					jsonObj.put("Id", list.get(i).get("ID"));
					jsonObj.put("Location1", list.get(i).get("LOCATION1"));
					jsonObj.put("Location2", list.get(i).get("LOCATION2"));
					jsonObj.put("PhoneNum", list.get(i).get("PHONENUM"));
					jsonObj.put("RegDate", list.get(i).get("REGDATE").toString());
					jsonObj.put("Experience", list.get(i).get("EXPERIENCE"));
					jsonObj.put("CommentDesc", list.get(i).get("COMMENTDESC"));
					jsonObj.put("Job", list.get(i).get("JOB"));
					jsonObj.put("ReqName", list.get(i).get("REQNAME"));
					jsonObj.put("FamilyNum", list.get(i).get("FAMILYNUM"));
					jsonObj.put("PetSeq", list.get(i).get("PETSEQ"));
					jsonArr.add(jsonObj);
				}
			}else {
				jsonObj.put("Result", "false");
				jsonArr.add(jsonObj);
			}
		}
		return jsonArr;
	}
	
	
	@RequestMapping(value = "/updateRequestCnt.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject updateRequestCnt(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("seq", oJSONRequest.get("Seq"));
		int result = sampleService.updateRequestCnt(commandMap);
		System.out.println("result : " + result);
		if(result > 0) {
			jsonObj.put("Result", "true");
		}else {
			jsonObj.put("Result", "false");
		}
		return jsonObj;
	}
	
	@RequestMapping(value = "/selectContract.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONArray selectContract(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		Map<String, Object> commandMap = new HashMap();
		commandMap.put("Id", oJSONRequest.get("Id"));
		List<Map<String, Object>> list = sampleService.selectContract(commandMap);
		System.out.println("result : " + list);
		if(list.size() > 0) {
			for(int i=0; i<list.size(); i++) {
				jsonObj.put("PetName", list.get(i).get("PETNAME"));
				jsonObj.put("Age", list.get(i).get("AGE"));
				jsonObj.put("Gender", list.get(i).get("GENDER"));
				jsonObj.put("Neutral", list.get(i).get("NEUTRAL"));
				jsonObj.put("Deposit", list.get(i).get("DEPOSIT"));
				jsonObj.put("StartDate", list.get(i).get("STARTDATE"));
				jsonObj.put("EndDate", list.get(i).get("ENDDATE"));
				jsonObj.put("ImgPath1", list.get(i).get("IMGPATH1"));
				jsonObj.put("ImgPath2", list.get(i).get("IMGPATH2"));
				jsonObj.put("ImgPath3", list.get(i).get("IMGPATH3"));
				jsonObj.put("Description", list.get(i).get("DESCRIPTION"));
				jsonObj.put("StatusValue", list.get(i).get("STATUSVALUE"));
				jsonObj.put("RequestCnt", list.get(i).get("REQUESTCNT"));
				jsonObj.put("Seq", list.get(i).get("SEQ"));
				jsonObj.put("Breeds", list.get(i).get("BREEDS"));
				jsonObj.put("Address1", list.get(i).get("ADDRESS1"));
				jsonObj.put("Address2", list.get(i).get("ADDRESS2"));
				jsonArr.add(jsonObj);
			}
		}else {
			jsonObj.put("Result", "false");
			jsonArr.add(jsonObj);
		}
		return jsonArr;
	}

}
