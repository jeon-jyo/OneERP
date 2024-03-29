<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/MENU/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>estimate_insert</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="/team_one/resources/css/vendors/feather/feather.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/typicons/typicons.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/simple-line-icons/css/simple-line-icons.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="/team_one/resources/css/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="/team_one/resources/css/js/select.dataTables.min.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/select2/select2.min.css">
  <link rel="stylesheet" href="/team_one/resources/css/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="/team_one/resources/css/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="/team_one/resources/css/images/favicon.png" />
  
<script src="https://unpkg.com/vue@2.6.6/dist/vue.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

  <style type="text/css">
     h2 { text-align: center; padding: 2% 0;}
     
     input::-webkit-inner-spin-button{
       display: none;
     }
  </style>
<script type="text/javascript">
// 상품 추가
function rowAdd(name, cost, qty, id) {
    var trCnt = $('#estimate_table tr').length;
    if(trCnt < 11) {
        var innerHtml = "";
        innerHtml += '<tr>';
        innerHtml += '    <td><input type="text" class="form-control" size="auto" id="product_name" name="product_name" value="' +name+ '" required readonly /><input type="hidden" name="product_id" value="' +id+ '"</td>';
        innerHtml += '    <td><input type="text" class="form-control" size="auto" id="product_cost" name="product_cost" value="' +cost+ '" required readonly /></td>';
        innerHtml += '    <td><input type="text" class="form-control" size="auto" id="product_qty" name="product_qty" value="' +qty+ '" required readonly /></td>';
        innerHtml += '    <td><input type="text" class="form-control" size="auto" id="product_price" name="product_price" required /></td>';
        innerHtml += '    <td><input type="text" class="form-control" size="auto" id="product_quantity" name="product_quantity" required /></td>';
        innerHtml += '</tr>';
        
        $('#estimate_table > tbody:last').append(innerHtml);
    }else{
        alert("최대 10개까지만 가능합니다.");
        return false;
    }
}

// 거래처 불러오기
$(function() {
   $("#client_list").click(function(){
 	  var url = "${path}/client_list_select.jh"
 	  window.open(url, "client_list_select","menubar=no, width=700px, height=700px");
    });
});

// 거래처 상품 불러오기
function rowAddd() {
	var id = document.getElementById('client_id').value;
	if(!id){
		swal("거래처를 선택해주세요!", {
		       icon: "error" 
		     })
		     .then((willDelete) => {
		     });
		return;
	}
	var url = "${path}/client_product_list.jh?client_id="+id;
  	  window.open(url, "client_product_list","menubar=no, width=700px, height=700px");
}

// 모든 상품 불러오기
function rowAdddd() {
	var id = document.getElementById('client_id').value;
	if(!id){
		swal("거래처를 선택해주세요!", {
		       icon: "error" 
		     })
		     .then((willDelete) => {
		     });
		return;
	}
	var url = "${path}/product_list.jh";
  	  window.open(url, "product_list","menubar=no, width=700px, height=700px");
}
 
// 상품 목록
function rowDelete() {
    var trCnt = $('#estimate_table tr').length;
    if(trCnt>1){
        $('#estimate_table > tbody:last > tr:last').remove();
    }else{
        return false;
    }
}

function allDelete() {
	   $('#estimate_table > tbody').empty();
	}
 
</script>
</head>
<body>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<c:if test="${insertCnt == 1}">
   <script type="text/javascript">
      swal("신규 견적서 등록이 정상적으로 완료됐습니다!", {
          icon: "success" 
        })
        .then((willDelete) => {
           opener.document.location.reload();
           self.close();
        });
   </script>
</c:if>

		<div class="card">
          <div class="card-body">
            <h4 class="card-title">견적서 등록</h4>
            
            <form class="forms-sample" name= "estimate_form" method="post" action="estimate_insert_action.jh?${_csrf.parameterName}=${_csrf.token}">
            <div id="result">
            <input type="hidden" name="client_id" id="client_id">
		    <input type="hidden" name="employee_id" id="employee_id" value="${dto.employee_id}">
		    <input type="hidden" name="department_id" value="${dto.department_id}">
		    
	          <!-- 이름 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;거래처명</label>
                <div class="input-group">
                <input type="text" class="form-control" id="cl_name" name="cl_name" required readonly /><br>
              	<div class="input-group-append">
                    &nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-outline-warning btn-sm" id="client_list" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight: bold">거래처 불러오기</button>
                </div>
                </div>
              </div>
              
	          <!-- 이름 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;대표자</label>
                <input type="text" class="form-control" id="exampleInputName1" name="ceo_name" required readonly />
              </div>   
              
              <!-- 이메일 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;거래처 이메일</label>
                <input type="email" class="form-control" id="exampleInputName1" name="cl_email" required readonly />
              </div>
              
              <!-- 우편번호 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;우편번호</label>
                	<div class="col-sm-2 row ms-3" style="flex-wrap: nowrap; padding-left: 1%; width: 40%;">
		                <input type="text" class="form-control" id="zip_code" name="cl_zip_code" required readonly />
		                
		                <div style="width:20% padding:10px" >
		                <button type="button" onclick="execDaumPostcode()" class="button btn btn-secondary" style="padding:7px 7px"><i class="icon-search"></i></button>
		                </div>
              		</div>
              </div>
              
              <!-- 주소 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;거래처 주소</label>
                <input type="text" class="form-control" size="auto" id="address" name="cl_address" required readonly />
              </div>
              
              <!-- 상세주소 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;상세주소</label>
                <input type="text" class="form-control" size="auto" id="detail_address" name="cl_detail_address" required readonly />
              </div>
              
              <!-- 연락처 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;거래처 연락처</label>
                <div class="col-sm-3 row ms-3" style="flex-wrap: nowrap; padding-left: 1%;">
	                <input type="text" class="form-control" size="3" name="phone1" required readonly /> 
	       			&nbsp;&nbsp;-&nbsp;&nbsp;
	          		<input type="text" class="form-control" size="4" name="phone2" required readonly />
	          		&nbsp;&nbsp;-&nbsp;&nbsp;
	          		<input type="text" class="form-control" size="4" name="phone3" required readonly />
          		</div>
              </div>               
              
	          <!-- 이름 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;담당자</label>
                <input type="text" class="form-control" id="exampleInputName1" name="em_name" value="${dto.em_name }" required readonly />
              </div>              
              
              <!-- 연락처 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;담당자 연락처</label>
                <div class="col-sm-3 row ms-3" style="flex-wrap: nowrap; padding-left: 1%;">
	                <input type="text" class="form-control" size="3" name="em_phone1" value= "${fn:substring(dto.em_phone,0,3)}" required readonly /> 
	       			&nbsp;&nbsp;-&nbsp;&nbsp;
	          		<input type="text" class="form-control" size="4" name="em_phone2" value= "${fn:substring(dto.em_phone,3,7)}" required readonly />
	          		&nbsp;&nbsp;-&nbsp;&nbsp;
	          		<input type="text" class="form-control" size="4" name="em_phone3" value= "${fn:substring(dto.em_phone,7,11)}" required readonly />
          		</div>
              </div>
              
			<!-- 권한 -->
			<div class="form-group">
			  <label><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;담당자 부서</label>
 			  <input type="text" class="form-control" id="exampleInputName1" name="de_name" value="${dto.de_name }" required readonly />
			</div>
	           
              <!-- 이메일 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;담당자 이메일</label>
                <input type="email" class="form-control" id="exampleInputName1" name="em_email" value="${dto.em_email }" required readonly />
              </div>
              
              <div class ="d-sm-flex justify-content-end btn-group me-3">
              <button type="button" class="btn btn-outline-info"  onclick="rowAddd();" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">빠른 항목 추가</button>
              <button type="button" class="btn btn-outline-facebook"  onclick="rowAdddd();" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">다른 항목 추가</button>
			  <button type="button" class="btn btn-outline-google" onclick="rowDelete();" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">항목 삭제</button>
              </div>
              
              <div class="form-group">
              <table class="table" id="estimate_table" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">
              		<tr>
              			<th align="center">품목명</th>
              			<th align="center">상품단가</th>
              			<th align="center">재고수량</th>
              			<th align="center">판매가</th>
              			<th align="center">판매수량</th>
              		</tr>
              	</table>
              </div>
              
              <br>
              
	          <!-- 메모 -->  
              <div class="form-group">
                <label for="exampleInputName1"><i class="mdi mdi-checkbox-marked-circle"></i>&nbsp;메모</label>
                <input type="text" class="form-control" id="exampleInputName1" name="re_memo" required />
              </div>
              <div class="d-sm-flex justify-content-end mt-3 mb-3">
              <button type="reset" class="btn btn-light btn-rounded" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;" onclick="allDelete()">초기화</button>
              <button type="submit" class="btn btn-outline-twitter me-2 btn-rounded" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">견적서 등록</button>
              </div>
            </div>
            </form>
          </div>
        </div>
      <%@ include file="/WEB-INF/views/MENU/footer.jsp" %>
    <!-- page-body-wrapper ends -->

  <!-- plugins:js -->
  <script src="/team_one/resources/css/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="/team_one/resources/css/vendors/chart.js/Chart.min.js"></script>
  <script src="/team_one/resources/css/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
  <script src="/team_one/resources/css/vendors/progressbar.js/progressbar.min.js"></script>

  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="/team_one/resources/css/js/off-canvas.js"></script>
  <script src="/team_one/resources/css/js/hoverable-collapse.js"></script>
  <script src="/team_one/resources/css/js/template.js"></script>
  <script src="/team_one/resources/css/js/settings.js"></script>
  <script src="/team_one/resources/css/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="/team_one/resources/css/js/dashboard.js"></script>
  <script src="/team_one/resources/css/js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
