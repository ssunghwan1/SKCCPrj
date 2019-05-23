package com.skcc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

@Controller
public class DataController {
	@RequestMapping(value = "/getDeposit.sk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void selectReqPet(@RequestBody JSONObject oJSONRequest) throws Exception {
		try{

			   PythonInterpreter python = new PythonInterpreter();
		        int number1 = 10;
		        int number2 = 32;
		        python.set("number1", new PyInteger(number1));
		        python.set("number2", new PyInteger(number2));
		        python.exec("number3 = number1+number2");
		        
		        PyObject number3 = python.get("number3");
		        System.out.println("val : "+number3.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
