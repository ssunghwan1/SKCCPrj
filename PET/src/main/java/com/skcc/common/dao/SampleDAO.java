package com.skcc.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skcc.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectBoardList", map);
	}
	public List<Map<String, Object>> selectPetList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectPetList", map);
	}
	
	public List<Map<String, Object>> selectPetDetail(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectPetDetail", map);
	}
	
	public List<Map<String, Object>> selectReqPet(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectReqPet", map);
	}
	public List<Map<String, Object>> selectReqPet2(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectReqPet2", map);
	}
	public List<Map<String, Object>> selectContract(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectContract", map);
	}
	@SuppressWarnings("unchecked")
	public int insertPet(Map<String, Object> map) throws Exception {
		System.out.println(map);
		return (Integer) insert("sample.insertPet", map);
	}
	public int updatePetDetail(Map<String, Object> map) throws Exception {
		System.out.println(map);
		return (Integer) update("sample.updatePet", map);
	}
	public int insertReqPet(Map<String, Object> map) throws Exception {
		System.out.println(map);
		return (Integer) insert("sample.insertReqPet", map);
	}
	public int updateRequestCnt(Map<String, Object> map) throws Exception {
		System.out.println(map);
		return (Integer) update("sample.updateRequestCnt", map);
	}
	public int insertContract(Map<String, Object> map) throws Exception {
		System.out.println(map);
		return (Integer) insert("sample.insertContract", map);
	}
}
