package com.skcc.main;

import java.util.List;
import java.util.Map;

public interface SampleService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectPetList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectPetDetail(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectReqPet(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectReqPet2(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectContract(Map<String, Object> map) throws Exception;
	int updatePetDetail(Map<String, Object> map) throws Exception;
	int updateRequestCnt(Map<String, Object> map) throws Exception;
	int insertPet(Map<String, Object> map) throws Exception;
	int insertReqPet(Map<String, Object> map) throws Exception;
	int insertContract(Map<String, Object> map) throws Exception;
	

}
