<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/MENU/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>(판매부)주문서 목록</title>
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
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="/team_one/resources/css/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="/team_one/resources/css/images/favicon.png" />
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
<script type="text/javascript">
   $(function(){
      $('#order_print').click(function() {
    	  
          window.print();
       });
      
      $('.order_confirm').click(function() {
          var my = $(this);
          var tr = my.parent().parent();
          var td = tr.children();
          swal("적요를 입력해주세요.", {
             content: "input",
          }).then((value) => {
        	   if(value != null){
                   window.location="${path}/order_update.jh?request_id="+td.eq(0).text()+"&abst="+value; 
                } else{
                swal("적요를 입력해주세요!", {
                 icon: "error" 
              	})
              }
           });
       });
      
      $('.outbound').click(function(){
          var my = $(this);
          var tr = my.parent().parent();
          var td = tr.children();
          var url = "${path}/outbound_insert.jh?request_id="+td.eq(0).text()
          window.open(url, "outbound","menubar=no, width=700px, height=700px");
       })      
      
   });
</script>
<script type="text/javascript">
/* 페이징처리 S */
function pagination(){
	var req_num_row=8;
	var $tr=$('tbody tr');
	var total_num_row=$tr.length;
	var num_pages=0;
	if(total_num_row % req_num_row ==0){
		num_pages=total_num_row / req_num_row;
	      }
	      if(total_num_row % req_num_row >=1){
	          num_pages=total_num_row / req_num_row;
	          num_pages++;
	          num_pages=Math.floor(num_pages++);
	      }

	  $('.pagination').append("<li style='margin:10px'><a class='prev'><i class='mdi mdi-step-backward'></i></a></li>");

	      for(var i=1; i<=num_pages; i++){
	          $('.pagination').append("<li style='margin:10px'><a>"+i+"</a></li>");
	    $('.pagination li:nth-child(2)').addClass("active");
	    $('.pagination a').addClass("pagination-link2");
	      }

	  $('.pagination').append("<li style='margin:10px'><a class='next'><i class='mdi mdi-step-forward'></i></a></li>");

	      $tr.each(function(i){
	    $(this).hide();
	    if(i+1 <= req_num_row){
	              $tr.eq(i).show();
	          }
	      });

	      $('.pagination a').click('.pagination-link2', function(e){
	          e.preventDefault();
	          $tr.hide();
	          var page=$(this).text();
	          var temp=page-1;
	          var start=temp*req_num_row;
	    var current_link = temp;
	    
	    $('.pagination li').removeClass("active");
	          $(this).parent().addClass("active");
	  
	          for(var i=0; i< req_num_row; i++){
	              $tr.eq(start+i).show();
	          }
	    
	    if(temp >= 1){
	      $('.pagination li:first-child').removeClass("disabled");
	    }
	    else {
	      $('.pagination li:first-child').addClass("disabled");
	    }
	          
	      });

	  $('.prev').click(function(e){
	      e.preventDefault();
	      $('.pagination li:first-child').removeClass("active");
	  });

	  $('.next').click(function(e){
	      e.preventDefault();
	      $('.pagination li:last-child').removeClass("active");
	  });

	  }

	$('document').ready(function(){
	  pagination();

	$('.pagination li:first-child').addClass("disabled");

	});
/* 페이징처리 E */
    
    var initBodyHtml;

    function beforePrint() {
        initBodyHtml = document.body.innerHTML;
        document.body.innerHTML = document.getElementById('print').innerHTML;
    }
    function afterPrint() {
        document.body.innerHTML = initBodyHtml;
        location.reload()
    }

    window.onbeforeprint = beforePrint;
    window.onafterprint = afterPrint;

   $(function(){
	      
	      // tr태그 클릭 시 거래처 상세페이지 접근 이벤트 생성
	      $('#order_list tr td').click(function(){
	         var td = $(this);   // 현재 클릭한 tr
	         var tr = td.parent();   // 클릭한 tr의 요소(td)
	         var tdd = tr.children();
	          
	         window.location="${path}/order_detail.jh?request_id="+ tdd.eq(0).text();
	      });
	   });   
</script>
<script>
    
    var initBodyHtml;

    function beforePrint() {
        initBodyHtml = document.body.innerHTML;
        document.body.innerHTML = document.getElementById('print').innerHTML;
    }
    function afterPrint() {
        document.body.innerHTML = initBodyHtml;
        location.reload()
    }

    window.onbeforeprint = beforePrint;
    window.onafterprint = afterPrint;
    
</script>
<style type="text/css">
	@media print {
	  #print{
	
	    width: 210mm;
	    height: 297mm;
	    margin: 30mm 45mm 30mm 45mm;
	}
	@page {
	
	 size: A4 landscape;
	  margin:0;
	}
	@media print
	{
		.btn,.card-title,.form-control, .icon-search, .todo-list-rounded, .mdi-check
       {
           display: none !important;
       }
	}
</style>
<style>
/* 페이징 css S */	
	.pagination {display:flex; padding-left:0; list-style:none; justify-content: center;}
	a {color: black;text-decoration: none;cursor: pointer;}
	.disabled{display :none;}
	li.active a{
	    color:#6E7FC5;
	}
	th.hover{
	    color:#6E7FC5;
	}
	a:hover{
		color:#A7AECB;
	}
	/* 페이징 css E */	
</style>
<script>

$(document).ready(function() {
	/* 오름-내림차룬 정렬 기능 S */
	$('th').each(function (column) {
	      $(this).click(function() {
              if($(this).is('.asc')) {
                  $(this).removeClass('asc');
                  $(this).addClass('desc');
                  sortdir=-1;                
              } else {
                 $(this).addClass('asc');
                 $(this).removeClass('desc'); 
                 sortdir=1;
              }
              $(this).siblings().removeClass('asc');
              $(this).siblings().removeClass('desc');
             var rec = $('table').find('tbody>tr').get();
             rec.sort(function (a, b) {
                  var val1 = $(a).children('td').eq(column).text().toUpperCase();
                  var val2 = $(b).children('td').eq(column).text().toUpperCase();
                  return (val1 < val2)?-sortdir:(val1>val2)?sortdir:0;
             });
             $.each(rec, function(index, row) {
                  $('tbody').append(row);
               });
         });
	});
	/* 오름-내림차룬 정렬 기능 E */

	/* 검색기능 S */
 	$("#keyword").keyup(function() {
        var k = $(this).val();
        console.log(k);
        $("#info_table > tbody > tr").hide();
        var temp = $("#info_table > tbody > tr > td:contains('" + k + "')");
        $(temp).parent().show();
	}); 
	/* 검색기능 E */
	
	/* 페이징처리 S */
	/* 페이징처리 E */
});
</script>
</head>
<body>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<c:if test="${updateCnt == 1}">
   <script type="text/javascript">
      swal("적요 추가가 정상적으로 완료됐습니다!", {
          icon: "success" 
        })
        .then((willDelete) => {
           opener.document.location.reload();
           self.close();
        });
   </script>
</c:if>

  <div class="container-scroller"> 
  <!-- 헤더 -->
  <%@ include file="/WEB-INF/views/MENU/header.jsp" %>
  
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
    <!-- 레프트메뉴 -->
      <%@ include file="/WEB-INF/views/MENU/leftMenu.jsp" %>
      
       <!-- 여기서부터 작성 -->
    <div class="main-panel">
        <div class="content-wrapper" style="padding-top:0;">
        <div class="d-flex flex-row align-items-center">
         <i class="menu-icon mdi mdi-briefcase icon-lg text-twitter me-2"></i>
            <h2 style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;  padding: 2% 0;">
                 영업/판매 관리
           </h2>
       </div>
          <div class="row col-lg-11">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body" id="print">
	                  <h3 class="card-title">주문서 관리</h3>
                  <div class="d-sm-flex justify-content-between mt-2 mb-4">
                     <p class="card-description">
                       		주문서 목록
                     </p>
                     <div id="input-form">
	                     <div class="d-sm-flex">
	                        <i class="icon-search text-primary pt-1 pe-2 fw-bold fs-5"></i>
	                    <input type="text" id="keyword" class="form-control" placeholder="SEARCH" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;" />
		              	</div>
		              </div>
              </div>
              <div class="table-responsive">
                    <table class="table table-hover" id="order_list2" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">
                      <thead>
                        <tr class="table-secondary">
                          <th>주문 번호 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>판매처 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>대표자 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>판매처 연락처 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>담당자 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>판매일자 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>납기요청일자 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>승인상태 <i class="mdi mdi-swap-vertical"></i></th>
                          <th>입고상태 <i class="mdi mdi-swap-vertical"></i></th>
                        </tr>
                      </thead>
                      <tbody id="order_list">
                      	<c:forEach var="dto" items="${list}">
                        <tr>
                          <td>${dto.request_id }</td>
                          <td>${dto.cl_name }</td>
                          <td>${dto.ceo_name }</td>
                          <td>
                          	  ${fn:substring(dto.cl_phone,0,3)} - 
                              ${fn:substring(dto.cl_phone,3,7)} - 
                              ${fn:substring(dto.cl_phone,7,11)}
                          </td> 
                          <td>${dto.em_name }</td>
                          <td><fmt:formatDate value="${dto.begin_date}" pattern="yyyy-MM-dd" /></td>
                          <td><fmt:formatDate value="${dto.end_date}" pattern="yyyy-MM-dd" /></td>                          
                          <th> <!-- SLIP -->
                             <c:if test="${dto.state eq'요청' }">
                            <label class="badge badge-warning order_confirm">승인요청</label>
                             </c:if>
                             <c:if test="${dto.state eq'신청' }">
                             <label class="badge badge-dark">승인대기</label>
                             </c:if>
                             <c:if test="${dto.state eq'승인' }">
                             <label class="badge badge-success">승인완료</label>
                             </c:if>
                          </th>
                          <th> <!-- REQUEST -->
                             <c:if test="${dto.re_status eq'요청대기' }">
                             <label class="badge badge-warning outbound">출고요청</label>
                             </c:if>
                             <c:if test="${dto.re_status eq'요청' }">
                             <label class="badge badge-dark">출고대기</label>
                             </c:if>
                             <c:if test="${dto.re_status eq'승인' }">
                             <label class="badge badge-success">출고완료</label>
                             </c:if>
                          </th>                        
                        </tr>
                        </c:forEach>
                      </tbody>
                      <tfoot>
							<tr>
							   <th colspan="9" >
							      <ul class="pagination" style="font-size: 16px; align-content:center;"></ul>
							   </th>
							</tr>
						</tfoot> 
                    </table>  
                    <div class="d-flex justify-content-end mt-3 mb-3">  
                    <button type="button" class="btn btn-outline-facebook btn-rounded btn-icon-text" id="order_print" style="font-family: 'IBM Plex Sans KR', sans-serif; font-weight:bold;">
                      	주문서 목록 출력<i class="ti-printer btn-icon-append"></i>
                  </button> 
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      
    </div>
       <%@ include file="/WEB-INF/views/MENU/footer.jsp" %>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

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
