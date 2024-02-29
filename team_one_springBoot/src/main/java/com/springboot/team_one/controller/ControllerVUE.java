package com.springboot.team_one.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.team_one.dto.AssembleDTO;
import com.springboot.team_one.service.VUEService;

@Controller
public class ControllerVUE {
	
	@Autowired
	VUEService vueService;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerVUE.class);
	
	// 인사 VUE========================================
	// 부서목록
	@CrossOrigin
    @ResponseBody
	@RequestMapping(value="dept_list.vue")
	public List<AssembleDTO> dept_list(HttpServletRequest req, Model model){
		logger.info("[url : dept_list.vue]");
		
		return vueService.dept_list(req, model);
	}
	// 인사카드 목록
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value="emp_list.vue")
	public List<AssembleDTO> emp_list_vue(HttpServletRequest req, Model model) {
		logger.info("[url : emp_list_vue.hj]");
		
		return vueService.emp_list_vue(req, model);
	}
    
	// 회계 VUE=========================================
	// 재무상태표 접근
	// http://localhost:8086/financial_statement.vue
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="financial_statement.vue")
	public AssembleDTO financial_statement(HttpServletRequest req, Model model) {
    	logger.info("[url : financial_statement.vue]");
	      
    	return vueService.financial_statement(req, model);
	}
    // 손익계산서 접근
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="financial_income_statement.vue")
	public AssembleDTO financial_income_statement(HttpServletRequest req, Model model) {
    	logger.info("[url : financial_income_statement.vue]");
    	
    	return vueService.financial_income_statement(req, model);
	}
    
	// 구매 VUE=========================================
	// 주문서 목록
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="order_list_sc.vue")
	public List<AssembleDTO> order_list_sc_vue(HttpServletRequest req, Model model) {
		logger.info("[url : order_list_sc_vue.sc]");
		return vueService.order_list_sc_vue(req, model);
	}
	
    // 매입장 목록
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="purchase_in_list.vue")
	public List<AssembleDTO> purchase_in_list(HttpServletRequest req, Model model) {
		logger.info("[url : purchase_in_list.sc]");
		return vueService.purchase_in_list(req, model);
	}

	// 전표 승인 요청
	@CrossOrigin
	@RequestMapping(value = "order_update_sc.vue")
	@ResponseBody
	public Map<String, Object> order_update_sc_vue(@RequestBody HashMap<String, String> param, HttpServletRequest req, Model model) {
		logger.info("[url : order_update_sc_vue.sc]");
		System.out.println(param.get("id"));
		System.out.println(param.get("abstract"));
		Map<String, Object> map = new HashMap<String, Object>();
		int update = vueService.order_update_sc_vue(req, model, param);
		String resultMsg = "";
		String result = "";
		if(update == 0) {
			resultMsg = "주문서 승인 신청을 실패하셨습니다.";
			result = "erorr";
		} else {
			resultMsg = "주문서 승인 신청을 성공하셨습니다.";
			result = "success";
		}
		map.put("resultMsg", resultMsg);
		map.put("result", result);
		return map;
	}
	
	// 입고 신청
	@CrossOrigin
    @ResponseBody
	@RequestMapping(value="inbound_insert.vue", method = RequestMethod.GET)
	public List<AssembleDTO> inbound_insert_vue(@RequestParam String request_id, HttpServletRequest req, Model model) {
		logger.info("[url : inbound_insert_vue.sc]");

        return vueService.inbound_insert_vue(req, model, request_id);
	}

	// 창고 목록
	@CrossOrigin
    @ResponseBody
	@RequestMapping(value="warehouse_list_sc.vue", method = RequestMethod.GET)
	public List<AssembleDTO> warehouse_list_sc_vue(HttpServletRequest req, Model model) {
		logger.info("[url : warehouse_list_sc_vue.sc]");

        return vueService.warehouse_list_sc_vue(req, model);
	}
	
	// 주문서 승인 신청
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "inbound_insert_action.vue", method = RequestMethod.POST)	
	public Map<String, Object> inbound_insert_action_vue(@RequestBody HashMap<String, String> param, Model model) {  

		Map<String, Object> map = new HashMap<String, Object>();
		
		String resultMsg = "";
		String result = "";
		
		try {
			int a = vueService.inbound_insert_action_vue(param);
			if(a != 0) {
				resultMsg = "입고 요청에 성공하였습니다.";
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg = "입고 요청에 실패했습니다.";
			result = "fail";
		}

		map.put("result", result);
		map.put("resultMsg", resultMsg);
		return map;
	}

 	
	// 판매 VUE=========================================
	// 판매 주문서 목록
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value="order_list.vue")
    public List<AssembleDTO> order_list_vue(HttpServletRequest req, Model model) {
        logger.info("[url : order_list_vue.jh]");
        
        return vueService.order_list_vue(req, model);
    }
	
	// 매출장 목록
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value="purchase_out_list.vue")
	public List<AssembleDTO> purchase_out_list_vue(HttpServletRequest req, Model model) {
		logger.info("[url : purchase_out_list_vue.jh]");
	
		return vueService.purchase_out_list_vue(req, model);
	}
	
	// 출고 요청
	@CrossOrigin
    @ResponseBody
    @RequestMapping(value="outbound_insert.vue", method = RequestMethod.GET)
    public List<AssembleDTO> outbound_insert_vue(@RequestParam String request_id, HttpServletRequest req, Model model) {
        logger.info("[url : outbound_insert_vue.jh]");
        
        return vueService.outbound_insert_vue(req, model, request_id);
    }

	// 출고 요청 액션
	@CrossOrigin
	@RequestMapping(value = "outbound_insert_action.vue", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> outbound_insert_action_vue(@RequestBody AssembleDTO param, Model model) {  
		// vueJS - create.js/ createProduct의 payload 값이 param으로 전달된다.
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//AssembleDTO resultVo = null;
		String resultMsg = "";
		String result = "";
		
		try {
			//resultVo = vueService.outbound_insert_action_vue(param);
			if(1 != 0) {
				resultMsg = "출고 요청에 성공하였습니다.";
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg = "출고 요청에 실패했습니다.";
			result = "fail";
		}

		map.put("result", result);
		//map.put("resultId", resultVo.getRequest_id());
		map.put("resultMsg", resultMsg);
		return map;
	}
	
	   // 전표 수정
	   @CrossOrigin
	   @RequestMapping(value = "order_update.vue")
	   @ResponseBody
	   public Map<String, Object> order_update_vue(@RequestBody HashMap<String, String> param, HttpServletRequest req, Model model) {
	      logger.info("[url : order_update_vue.jh]");
	      
	      System.out.println(param.get("id"));
	      System.out.println(param.get("abst"));
	      
	      Map<String, Object> map = new HashMap<String, Object>();
	      
	      int update = vueService.order_update_vue(req, model, param);
	      
	      String resultMsg = "";
	      String result = "";
	      
	      if(update == 0) {
	         resultMsg = "주문서 승인 신청을 실패하셨습니다.";
	         result = "erorr";
	      } else {
	         resultMsg = "주문서 승인 신청을 성공하셨습니다.";
	         result = "success";
	      }
	      map.put("resultMsg", resultMsg);
	      map.put("result", result);
	      
	      return map;
	   }

   	
	// 물류 VUE=========================================
		// 창고 목록
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="warehouse_list.vue")
		public List<AssembleDTO> warehouse_list_vue(HttpServletRequest req, Model model) {
			logger.info("[url : warehouse_list_vue.dh]");
			return vueService.warehouseList_vue(req, model);
		}
		
		// 입하  내역
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="arrival_history_list.vue")
		public List<AssembleDTO> arrival_History_list_vue(HttpServletRequest req, Model model) {
			logger.info("[url : arrival_history_list.dh]");
			return vueService.arrival_History_list_vue(req, model);
		}
		
		// 출고 내역
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="release_history_list.vue")
		public List<AssembleDTO> release_history_list_vue(HttpServletRequest req, Model model) {
			logger.info("[url : release_history_list.dh]");
			return vueService.release_history_list_vue(req, model);
		}
	
		// 입고 내역
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="warehousing_list.vue")
		public List<AssembleDTO> warehousing_list_vue(HttpServletRequest req, Model model) {
			logger.info("[url : warehousing_list.dh]");
			return vueService.warehousing_list_vue(req, model);
		}

	// 출/퇴근 VUE=========================================
		// 출/퇴근 목록
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="vue_per_attend_list_call.vue")
		public List<AssembleDTO> vue_per_attend_list_call(HttpServletRequest req, Model model) {
			logger.info("[url : vue_per_attend_list_call.sc]");
			return vueService.vue_per_attend_list_call(req, model);
		}
	
}
