package com.skcc.main;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.skcc.common.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectBoardList(map);
	}
	@Override
	public List<Map<String, Object>> selectPetList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectPetList(map);
	}
	
	@Override
	public int insertPet(Map<String, Object> map) throws Exception {
		return (Integer)sampleDAO.insertPet(map);
	}
	@Override
	public List<Map<String, Object>> selectPetDetail(Map<String, Object> map) throws Exception {
		return sampleDAO.selectPetDetail(map);
	}
	@Override
	public int updatePetDetail(Map<String, Object> map) throws Exception {
		
		return sampleDAO.updatePetDetail(map);
	}
	@Override
	public int insertReqPet(Map<String, Object> map) throws Exception {
		
		return sampleDAO.insertReqPet(map);
	}
	@Override
	public List<Map<String, Object>> selectReqPet(Map<String, Object> map) throws Exception {
		
		return sampleDAO.selectReqPet(map);
	}
	@Override
	public int updateRequestCnt(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.updateRequestCnt(map);
	}
	@Override
	public int insertContract(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.insertContract(map);
	}
	@Override
	public List<Map<String, Object>> selectContract(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectContract(map);
	}
	@Override
	public List<Map<String, Object>> selectReqPet2(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectReqPet2(map);
	}
}
