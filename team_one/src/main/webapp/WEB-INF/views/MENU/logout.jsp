<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/MENU/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <title>logOut</title>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script type="text/javascript">
  $(function(){
		swal("로그아웃이 정상적으로 완료됐습니다!", {
		    icon: "success" 
		  })
		  .then((willDelete) => {
			  window.location = "${path}/login.one";
		  });
  });

</script>
</head>
<body>
</body>

</html>
