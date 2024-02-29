<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
</head>
<body>
      <!-- 여기서부터 작성 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<c:if test="${updateCnt == 2}">
<script type="text/javascript">
swal("물품이  재고조정되었습니다.", {
    icon: "success" 
  })
  .then((willDelete) => {
     opener.document.location.reload();
     self.close();
  });
</script>
</c:if>
<c:if test="${updateCnt != 2}">
<script type="text/javascript">
swal("재고조정중에 오류가 발생하였습니다. 다시 확인해주세요.", {
    icon: "warning" 
  })
  .then((willDelete) => {
     window.history.back();
  });
</script>
</c:if>
<!-- 신규 계좌 등록처리-->
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
