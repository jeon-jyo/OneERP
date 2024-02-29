package com.springboot.team_one.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springboot.team_one.dto.AssembleDTO;

public interface VUEService {
	
	// ================ 인사 ====================
	// 부서목록
	public List<AssembleDTO> dept_list(HttpServletRequest req, Model model);
	
	// 인사카드목록
	public List<AssembleDTO> emp_list_vue(HttpServletRequest req, Model model);
	
	// ================ 회계 ====================
	// 재무상태표
	public AssembleDTO financial_statement(HttpServletRequest req, Model model);
	
	// 손익계산서
	public AssembleDTO financial_income_statement(HttpServletRequest req, Model model);
	
	// ================ 구매 ====================
	List<AssembleDTO> order_list_sc_vue(HttpServletRequest req, Model model);

	List<AssembleDTO> purchase_in_list(HttpServletRequest req, Model model);

	int order_update_sc_vue(HttpServletRequest req, Model model, HashMap<String, String> param);

	List<AssembleDTO> inbound_insert_vue(HttpServletRequest req, Model model, String request_id);
	
	List<AssembleDTO> warehouse_list_sc_vue(HttpServletRequest req, Model model);

	int inbound_insert_action_vue(HashMap<String, String> param);

	// ================ 판매 ====================
	// 판매 주문서 목록
	List<AssembleDTO> order_list_vue(HttpServletRequest req, Model model);

	// 매출장 목록
	List<AssembleDTO> purchase_out_list_vue(HttpServletRequest req, Model model);

	// 출고 요청
	List<AssembleDTO> outbound_insert_vue(HttpServletRequest req, Model model, String request_id);
	
	// 출고 요청 액션
	AssembleDTO outbound_insert_action_vue(AssembleDTO param);

	// 전표 수정
	int order_update_vue(HttpServletRequest req, Model model, HashMap<String, String> param);

	
	// ================ 물류 ====================
	// 창고 목록
	List<AssembleDTO> warehouseList_vue(HttpServletRequest req, Model model);

	// 입하 내역
	List<AssembleDTO> arrival_History_list_vue(HttpServletRequest req, Model model);

	// 출고 내역
	List<AssembleDTO> release_history_list_vue(HttpServletRequest req, Model model);

	// 입고 내역
	List<AssembleDTO> warehousing_list_vue(HttpServletRequest req, Model model);

	// ================ 출/퇴근 ====================
	List<AssembleDTO> vue_per_attend_list_call(HttpServletRequest req, Model model);
	
}
