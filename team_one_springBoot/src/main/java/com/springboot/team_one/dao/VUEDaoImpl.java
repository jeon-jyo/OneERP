package com.springboot.team_one.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.springboot.team_one.dto.AssembleDTO;

@Primary
@Repository
public class VUEDaoImpl implements VUEDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// =====================인사=====================
	// 부서목록
	@Override
	public List<AssembleDTO> dept_list() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.dept_list();
	}
	// 인사카드목록
	@Override
	public List<AssembleDTO> emp_list() {
		
		System.out.println("dao - 인사카드목록");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.emp_list();
	}

	
	// =====================회계=====================
	// ======= 재무상태표 =======
	// 보통예금
	public int bank_assets() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.bank_assets();
	}
	
	// 매출채권
	public int trade_receivable() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.trade_receivable();
	}
	
	// 매입채무
	public int trade_payable() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.trade_payable();
	}
	
	// 부가세대급금
	public int vat_payment() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.vat_payment();
	}
	
	// 부가세예수금
	public int vat_deposit() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.vat_deposit();
	}
	
	// ======= 손익계산서 =======
	// 매출총액
	public int take_sales() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.take_sales();
	}
	
	// 기초상품 재고 입력일 조회
	public int beg_inven_select() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.beg_inven_select();
	}
	
	// 기초상품 재고 입력일 조회
	public int beg_inven_insert(int cost) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.beg_inven_insert(cost);
	}
	
	// 기초상품 재고액
	public int beginning_inventory() {
		System.out.println("기초상품 재고액");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.beginning_inventory();
	}
	
	// 당기상품 재고액
	public int current_inventory() {
		System.out.println("당기상품 재고액");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.current_inventory();
	}
	
	// 기말상품 재고액
	public int ending_inventory() {
		System.out.println("기말상품 재고액");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.ending_inventory();
	}
	
	// 급여총액
	public int total_salary() {
		System.out.println("급여총액");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.total_salary();
	}
	
	// 비용 계정별 검색
	public int all_expense_lookup(String subject) {
		System.out.println("비용 계정별 검색");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.all_expense_lookup(subject);
	}
	
	// 비과세 소득 합계
	public int non_tax_sum() {
		System.out.println("비과세 소득합계");
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.non_tax_sum();
	}
	
	// =====================구매=====================
	@Override
	public List<AssembleDTO> order_list_sc() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.order_list_sc();
	}
	
	@Override
	public List<AssembleDTO> purchase_in_list() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.purchase_in_list();
	}
	
	@Override
	public int slip_update_sc(String id) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.slip_update_sc(id);
	}

	@Override
	public int sales_slip_update_sc(Map<String, Object> map) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.sales_slip_update_sc(map);
	}
	
	// 견적 신청서 상세정보의 상품 리스트
	@Override
	public List<AssembleDTO> estimate_application_detail_list(String id) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.estimate_application_detail_list(id);
	}
	
	@Override
	public List<AssembleDTO> warehouse_list_sc() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.warehouse_list_sc();
	}
	
	@Override
	public int request_update_sc(String request_id) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.request_update_sc(request_id);
	}
	
	// 입하 요청
	@Override
	public int inbound_insert(Map<String,Object> map) {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.inbound_insert(map);
	}
	
	// =====================판매=====================
	// 주문서 조회
	@Override
	public List<AssembleDTO> order_list(Map<String, Object> map) {
		System.out.println("Dao - order_list 주문서 조회");

		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		List<AssembleDTO> list = dao.order_list(map);
		return list;	
	}
	
	// 전표 승인
	@Override
	public int slip_update(String request_id) {
		System.out.println("Dao - slip_update 전표 승인");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		int updateCnt = dao.slip_update(request_id);
		return updateCnt;
	}

	// 적요 추가
	@Override
	public int sales_slip_update(Map<String, Object> map) {
		System.out.println("Dao - sales_slip_update 적요 추가");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		int updateCnt = dao.sales_slip_update(map);
		return updateCnt;
	}
	
	// 견적서 상세 상품
	@Override
	public List<AssembleDTO> request_product(String request_id) {
		System.out.println("Dao - request_product 견적서 상세 상품");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		List<AssembleDTO> list = dao.request_product(request_id);
		return list;
	}

	// 창고 목록
	@Override
	public AssembleDTO warehouse_list(int product_id) {
		System.out.println("Dao - warehouse_list 창고 목록");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		AssembleDTO list = dao.warehouse_list(product_id);
		return list;	
	}

	// 주문서 출고 요청
	@Override
	public int request_update(String request_id) {
		System.out.println("Dao - request_update 주문서 출고 요청");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		int updateCnt = dao.request_update(request_id);
		return updateCnt;
	}

	// 출고 대기
	@Override
	public int outbound_insert(Map<String, Object> map) {
		System.out.println("Dao - outbound_insert 출고 대기");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		int insertCnt = dao.outbound_insert(map);
		return insertCnt;
	}
    
	// 매출장 목록
	@Override
	public List<AssembleDTO> purchase_out_list_vue() {
		System.out.println("Dao - purchase_out_list_vue 매출장 목록");
		
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		
		List<AssembleDTO> list = dao.purchase_out_list_vue();
		return list;
	}
	
	// =====================물류=====================
	// 창고 목록
	@Override
	public List<AssembleDTO> warehouseList() {
	  System.out.println("DAO - warehouseList()");

	  VUEDao dao = sqlSession.getMapper(VUEDao.class);
       return dao.warehouseList();

	}
	
	// 입하내역
	@Override
	public List<AssembleDTO> arrival_history_list() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
       return dao.arrival_history_list();

    }

	// 출고 내역
	@Override
	public List<AssembleDTO> release_history_list() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		return dao.release_history_list();
	}

   // 입고내역
   @Override
   public List<AssembleDTO> warehousing_list() {
	   VUEDao dao = sqlSession.getMapper(VUEDao.class);
      return dao.warehousing_list();

   }

	// =====================출/퇴근=====================
	@Override
	public List<AssembleDTO> vue_per_attdance_list() {
		VUEDao dao = sqlSession.getMapper(VUEDao.class);
		List<AssembleDTO> list = dao.vue_per_attdance_list();
	
		System.out.println("개인 출/퇴근 정보 호출 : " + list );
		return list; 
	}

	
}
