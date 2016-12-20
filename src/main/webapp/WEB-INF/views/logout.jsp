<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../layout/header.jsp"></jsp:include> 
<script src="/project/resources/js/services/customer/controller.js"></script>
<script src="/project/resources/js/services/customer/service.js"></script>
</head>
<body ng-app="myApp" class="ng-cloak">

<!-- Main Wrapper Start -->
<div id="wrapper" class="wrapper"> 
  
  <!-- Header Start -->
  <jsp:include page="../layout/menu.jsp"></jsp:include> 
  <!-- Header End --> 
  
  <!-- Main Content Start -->
  
  <div class="main-content"  data-ng-controller="CustomerController as ctrl" data-ng-init="ctrl.logout()"> 
    
  </div>
  
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
  <jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
<!-- Main Wrapper End --> 

</body>
</html>