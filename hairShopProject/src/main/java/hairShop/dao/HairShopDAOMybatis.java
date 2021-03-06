package hairShop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hairShop.bean.HairShopReviewDTO;

@Transactional
@Component
public class HairShopDAOMybatis implements HairShopDAO {
	@Autowired
	private SqlSession sqlSession;
   
	@Override
	public List<Map<String, Object>> getSearchList(Map<String, Object> map) {
		System.out.println("search DAO 들어왔어용!");
		return sqlSession.selectList("hairShopSQL.getSearchList", map);
	}

	@Override
	public Map<String, Object> getHairShopInfo(String hairShopId) {
		System.out.println("DAO mybatis"+hairShopId);
		
		return sqlSession.selectOne("hairShopSQL.getHairShopInfo", hairShopId);
	}
	@Override
	public List<Map<String, Object>> getDesignerSchedule(Map<String, String> map) {		
		return sqlSession.selectList("hairShopSQL.getDesignerSchedule", map);
	}

	@Override
	public List<Map<String, Object>> timeBtnCheck(Map<String, Object> map) {
		return sqlSession.selectList("hairShopSQL.timeBtnCheck", map);
	}
   @Override
   public List<Map<String, Object>> getServiceList(Map<String, String> map) {
      return sqlSession.selectList("hairShopSQL.getServiceList", map);
   }
   @Override
	public List<Map<String, Object>> getDesignerInfo(String hairShopId) {
		System.out.println("DAO mybatis"+hairShopId);
		return sqlSession.selectList("hairShopSQL.getDesignerInfo", hairShopId);
	}

	@Override
	public int confirmedReservation(Map<String, String> map) {
		return sqlSession.insert("hairShopSQL.confirmedReservation", map);
	}

	@Override
	public List<HairShopReviewDTO> hairShopReviewList() {
		return sqlSession.selectList("hairShopSQL.hairShopReviewList");
	}

	
	//리뷰작성
	@Override
	public void hairShopReviewWrite(Map<String, String> map) {
		sqlSession.insert("hairShopSQL.hairShopReviewWrite", map);
	}

	@Override
	public Map<String, Object> getTel(String memEmail) {
		return sqlSession.selectOne("hairShopSQL.getTel", memEmail);

	}
	
	@Override
	public Map<String, Object> getHeartBtn(Map<String, String> map){
		return sqlSession.selectOne("hairShopSQL.getHeartBtn",map);
	}

	@Override
	public void insertHeart(Map<String, String> map) {
		sqlSession.insert("hairShopSQL.insertHeart", map);
	}

	@Override
	public void deleteHeart(Map<String, String> map) {
		sqlSession.delete("hairShopSQL.deleteHeart", map);
	}

	@Override
	public List<Map<String, Object>> getSearchHairShopList(String hairShopName) {
		return sqlSession.selectList("hairShopSQL.getSearchHairShopList", hairShopName);
	}
}