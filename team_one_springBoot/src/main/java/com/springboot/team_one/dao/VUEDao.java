package com.springboot.team_one.dao;

import java.util.List;
import java.util.Map;

import com.springboot.team_one.dto.AssembleDTO;

public interface VUEDao {
	
	// ======================인사=======================
	// 부서목록
	public List<AssembleDTO> dept_list();
	
	// 인사카드목록
	public List<AssembleDTO> emp_list();
	
	// ======================회계=======================
	// ======= 재무상태표 =======
	// 보통예금
	public int bank_assets();
	
	// 매출채권
	public int trade_receivable();
	
	// 부가세대급금
	public int vat_payment();
	
	// 매입채무
	public int trade_payable();
	
	// 부가세예수금
	public int vat_deposit();
	
	// ======= 손익계산서 =======
	// 매출총액
	public int take_sales();
	
	// 기초상품 재고 입력일 조회
	public int beg_inven_select();
	
	// 기초상품 재고 입력일 조회
	public int beg_inven_insert(int cost);
	
	// 기초상품 재고액
	public int beginning_inventory();
	
	// 당기상품 재고액
	public int current_inventory();
	
	// 기말상품 재고액
	public int ending_inventory();
	
	// 급여총액
	public int total_salary();
	
	// 비용 계정별 검색
	public int all_expense_lookup(String subject);
	
	// 비과세 소득 합계
	public int non_tax_sum();
	
	// ======================구매=======================
	// 주문서 목록
	List<AssembleDTO> order_list_sc();
	
	List<AssembleDTO> purchase_in_list();
	
	// 전표 승인요청
	int slip_update_sc(String id);
	
	// 매입매출전표 승인요청
	int sales_slip_update_sc(Map<String,Object> map);
	
	// 견적 신청서 상세정보의 상품 리스트
	List<AssembleDTO> estimate_application_detail_list(String id);
	
	// 창고 목록 
	List<AssembleDTO> warehouse_list_sc();
	
	int request_update_sc(String request_id);
	
	// 입하 요청
	int inbound_insert(Map<String, Object> map);
	
	// ======================판매=======================
	
	// 견적서 상세 상품
	List<AssembleDTO> request_product(String request_id);
	
	// 주문서 조회
	List<AssembleDTO> order_list(Map<String, Object> map);

	// 전표 승인
	int slip_update(String request_id);

	// 적요 추가
	int sales_slip_update(Map<String, Object> map);

	// 창고 목록
	AssembleDTO warehouse_list(int product_id);

	// 주문서 출고 요청
	int request_update(String request_id);

	// 출고 대기
	int outbound_insert(Map<String, Object> map);

	// 매출장 목록
	List<AssembleDTO> purchase_out_list_vue();

	
	// ======================물류=======================
	// 창고 목록
	public List<AssembleDTO> warehouseList();

	// 입하 내역
	List<AssembleDTO> arrival_history_list();

	// 출고 내역
    List<AssembleDTO> release_history_list();
    
    // 입고내역
    List<AssembleDTO> warehousing_list();
	
    
	// ======================출/퇴근=======================
	public  List<AssembleDTO> vue_per_attdance_list();
}
