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
  
  <div class="main-content"> 
    
    <!-- Login Page Start -->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="cp-login-box">
            <div class="cp-login-form" data-ng-controller="CustomerController as ctrl" data-ng-init="ctrl.verif()">
              <form class="material">
                <ul>
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-2"></i></span>
                    <input type="text" class="form-control" placeholder="User Name" ng-model="login" required>
                  </li>
                  <li class="input-group"> <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" placeholder="Password" ng-model="passwd" required>
                  </li>
                  <li>
                    <button type="submit" class="btn btn-submit waves-effect waves-button" ng-click="ctrl.login()">Login <i class="fa fa-angle-right"></i></button>
                  </li>
                </ul>
              </form>
              
              <div class="signup">
              <a href="/project/register">Vous n'avez pas de compte? Inscrivez-vous</a>
              
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Login Page End --> 
    
  </div>
  
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
  <jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
<!-- Main Wrapper End --> 

</body>
</html>