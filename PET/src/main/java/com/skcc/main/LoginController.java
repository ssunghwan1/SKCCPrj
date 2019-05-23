package com.skcc.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@Controller
public class LoginController {
	@Resource(name = "sampleService")
	private SampleService sampleService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/Login.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JSONObject test(@RequestBody JSONObject oJSONRequest) throws Exception {
		JSONObject jsonObj = new JSONObject();
		Map<String, Object> commandMap = new HashMap();
		System.out.println(oJSONRequest);
		String inputId = oJSONRequest.get("Id").toString();
		String inputPw = oJSONRequest.get("Pw").toString();
		System.out.println("inputId : " + inputId);
		System.out.println("inputPw : " + inputPw);
		commandMap.put("Id", inputId);
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		System.out.println(list);
		if(list == null || list.size() ==0) {
			jsonObj.put("isLogin", "NOID");
			return jsonObj;
		}
		String id = list.get(0).get("id").toString();
		String pw = list.get(0).get("password").toString();
		
		if(inputPw.equals(pw)) {
			jsonObj.put("isLogin", "true");
		}else {
			jsonObj.put("isLogin", "false");
		}
		return jsonObj;
	}

}
