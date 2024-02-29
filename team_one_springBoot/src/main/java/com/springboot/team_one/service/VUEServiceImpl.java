package com.springboot.team_one.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springboot.team_one.dao.VUEDaoImpl;
import com.springboot.team_one.dto.AssembleDTO;

import page.Paging;
@Service
public class VUEServiceImpl implements VUEService {

	@Autowired
	VUEDaoImpl dao;
	
	// ===================인사=======================
	// 부서목록
	@Override
	public List<AssembleDTO> dept_list(HttpServletRequest req, Model model) {
		return dao.dept_list();
	}
	
	// 인사카드목록
	@Override
	public List<AssembleDTO> emp_list_vue(HttpServletRequest req, Model model) {
		
		System.out.println("service - 인사카드목록 뷰");

		List<AssembleDTO> list = dao.emp_list();
		
		return list;
	}

	
	// ===================회계=======================
	// 재무상태표
	@Override
	public AssembleDTO financial_statement(HttpServletRequest req, Model model) {
		AssembleDTO financial_statement = new AssembleDTO();
		
		// ===========================================
		// 자산정보
		// 보통예금
		financial_statement.setBank_assets(dao.bank_assets());
		
		// 매출채권
		financial_statement.setTrade_receivable(dao.trade_receivable());
		
		// 부가세대급금
		financial_statement.setVat_payment(dao.vat_payment());
		
		// 재고자산
		financial_statement.setCurrent_inventory(dao.ending_inventory());
		// ===========================================
		// 부채정보
		// 매입채무Liabilities
		financial_statement.setTrade_payable(dao.trade_payable());
		
		// 부가세예수금
		financial_statement.setVat_deposit(dao.vat_deposit());
		
		model.addAttribute("financial_statement", financial_statement);
		return financial_statement;
	}
	
	// 손익계산서
	@Override
	public AssembleDTO financial_income_statement(HttpServletRequest req, Model model) {
		AssembleDTO financial_income = new AssembleDTO();
		
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMM");
		// 포맷 적용
		int time = Integer.parseInt(now.format(format));
		
		// 현재재고액 조회
		int now_inven = dao.ending_inventory();
		// 기초상품재고 입력일 조회
		int beg_time = dao.beg_inven_select();
		
		// 기초상품재고 입력일 비교
		if((time - 1) > beg_time) {
			int beg_result = dao.beg_inven_insert(now_inven);
			System.out.println("기초상품재고 입력일 비교 : " + beg_result);
		}
		
		// 매출총액
		financial_income.setTake_sales(dao.take_sales());
		
		// 기초상품 재고액
		financial_income.setBeginning_inventory(dao.beginning_inventory());
		
		// 당기상품 재고액
		financial_income.setCurrent_inventory(dao.current_inventory());
		
		// 기말상품 재고액
		financial_income.setEnding_inventory(dao.ending_inventory());
		
		// ===========================================
		// 각 계정별 비용저장
		// 급여총액
		financial_income.setTotal_salary(dao.total_salary());
		
		// 여비교통비
		financial_income.setTravel_expense(dao.all_expense_lookup("여비교통비"));
		
		// 소모품비
		financial_income.setConsumable_expense(dao.all_expense_lookup("소모품비"));
		
		// 통신비
		financial_income.setCommunication_expense(dao.all_expense_lookup("통신비"));
		
		// 접대비
		financial_income.setEntertainment_expense(dao.all_expense_lookup("접대비"));
		
		// 수도광열비
		financial_income.setAdministrative_expense(dao.all_expense_lookup("수도광열비"));
		
		// 창고관리비
		financial_income.setWarehouse_expense(dao.all_expense_lookup("창고관리비"));
		
		// 비과세소득 합계
		financial_income.setNon_tax_sum(dao.non_tax_sum());
		
		model.addAttribute("financial_income", financial_income);
		return financial_income;
	}
	
	// ===================구매=======================
	@Override
	public List<AssembleDTO> order_list_sc_vue(HttpServletRequest req, Model model) {
		List<AssembleDTO> list = dao.order_list_sc();
		return list;
	}

	@Override
	public List<AssembleDTO> purchase_in_list(HttpServletRequest req, Model model) {
		return dao.purchase_in_list();
	}

	@Override
	public int order_update_sc_vue(HttpServletRequest req, Model model, HashMap<String, String> param) {
		String request_id = param.get("id");
		String good = param.get("abstract");
		dao.slip_update_sc(request_id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("request_id", request_id);
		map.put("good", good);
		int updateCnt = dao.sales_slip_update_sc(map);
		return updateCnt;
	}
	
	@Override
	public List<AssembleDTO> inbound_insert_vue(HttpServletRequest req, Model model, String request_id) {

		System.out.println("Service - inbound_insert_vue 입고 요청");

		// 주문서 상품
		List<AssembleDTO> list = dao.estimate_application_detail_list(request_id);

		return list;
	}
	
	@Override
	public List<AssembleDTO> warehouse_list_sc_vue(HttpServletRequest req, Model model) {

		System.out.println("Service - warehouse_list_sc_vue 창고 목록");
		
		List<AssembleDTO> list = dao.warehouse_list_sc();
		
		return list;
	}

	@Override
	public int inbound_insert_action_vue(HashMap<String, String> param) {
		
		System.out.println("Service - inbound_insert_action_vue 입고 요청 액션");
		String wh_id = param.get("wa_name");
		String request_id = param.get("request_id");
		System.out.println(wh_id);
		System.out.println(request_id);
		// REQUEST 주문서 출고 요청
		
		// OUTBOUND 출고 대기
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("request_id", request_id);
	    map.put("wh_id", wh_id);
		
	    dao.request_update_sc(request_id);
	    
		return dao.inbound_insert(map);
	}
	
	// ===================판매=======================
	// 판매 주문서 목록
	@Override
	public List<AssembleDTO> order_list_vue(HttpServletRequest req, Model model) {
		
		System.out.println("Service - order_list_vue 주문서 조회 !뷰!");

		String pageNum = req.getParameter("pageNum");

		Paging paging = new Paging(pageNum);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		List<AssembleDTO> list = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		list = dao.order_list(map);

		return list;
	}

	// 매출장 목록
	@Override
	public List<AssembleDTO> purchase_out_list_vue(HttpServletRequest req, Model model) {

		System.out.println("Service - purchase_out_list_vue 매출장 목록 !뷰!");
		
		List<AssembleDTO> list = dao.purchase_out_list_vue();
		
		return list;
	}
	
	// 출고 요청
	@Override
	public List<AssembleDTO> outbound_insert_vue(HttpServletRequest req, Model model, String request_id) {
		
		// 주문서 상품
		List<AssembleDTO> list = dao.request_product(request_id);
		
		// WAREHOUSE 창고 목록
        for(int i = 0; i<list.size(); i++) {
        	AssembleDTO dto = dao.warehouse_list(list.get(i).getProduct_id());
        	list.get(i).setWh_id(dto.getWh_id());
        	list.get(i).setWa_name(dto.getWa_name());
        	list.get(i).setPr_name(dto.getPr_name());
        	list.get(i).setLa_qty(dto.getLa_qty());
        }
		return list;
	}

	// 출고 요청 액션
	@Override
	public AssembleDTO outbound_insert_action_vue(AssembleDTO param) {

		System.out.println("Service - outbound_insert_action_vue 출고 요청 액션");
		
		String request_id =  Integer.toString(param.getRequest_id());
		
		// REQUEST 주문서 출고 요청
		dao.request_update(request_id);
		
		// OUTBOUND 출고 대기
		String wh_id = Integer.toString(param.getWh_id());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("request_id", request_id);
	    map.put("wh_id", wh_id);
		
		dao.outbound_insert(map);
		
		return param;
	}

	// 전표 수정
	@Override
	public int order_update_vue(HttpServletRequest req, Model model, HashMap<String, String> param) {
		
		System.out.println("Service - order_update_vue 전표 수정 !뷰!");
		
		// SLIP 전표 승인
		String request_id = param.get("id");
		String abst = param.get("abst");
		
		int updateCnt = dao.slip_update(request_id);
		
		// SALES_SLIP 적요 추가
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("request_id", request_id);
	    map.put("abst", abst);
	    
	    int updateCnt2 = dao.sales_slip_update(map);
	    
	    System.out.println("Cnt : " + updateCnt + updateCnt2);
	    
	    return updateCnt2;
	}
	
	// ===================물류=======================
	   //창고 목록
	   @Override
	   public List<AssembleDTO>  warehouseList_vue(HttpServletRequest req, Model model) {

			// 5-2 warehouseList 가져오기
			List<AssembleDTO> list = dao.warehouseList();
			model.addAttribute("list", list);

			return list;
		}
	   
	    // 입하 내역
		@Override
		public List<AssembleDTO> arrival_History_list_vue(HttpServletRequest req, Model model) {

			// 5-2 arrival_History_list 가져오기
			List<AssembleDTO> list = dao.arrival_history_list();

			model.addAttribute("list", list);

			return list;
		}
		
	    // 출고내역
		@Override
		public List<AssembleDTO> release_history_list_vue(HttpServletRequest req, Model model) {
			List<AssembleDTO> list = dao.release_history_list();
			model.addAttribute(list);
			return list;
		}
		
		// 입고 내역
		@Override
		public List<AssembleDTO> warehousing_list_vue(HttpServletRequest req, Model model) {
			List<AssembleDTO> list = dao.warehousing_list();

			model.addAttribute("list",list);

			return list;
		}

	// ===================출/퇴근=======================
		@Override
		public List<AssembleDTO> vue_per_attend_list_call(HttpServletRequest req, Model model) {
			List<AssembleDTO> list = dao.vue_per_attdance_list();
			return list;
		}

}
