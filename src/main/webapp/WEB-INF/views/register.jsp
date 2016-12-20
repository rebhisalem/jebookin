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
  <!--  Innner header bg End  --> 
  <!-- Header End --> 
  
  <!-- Main Content Start -->
  
 <div class="main-content"  data-ng-controller="CustomerController as ctrl" data-ng-init="ctrl.verif()"> 
    
    <!-- Login Page Start -->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="cp-login-box cp-register-form">
            <div class="cp-login-form ">
              <form class="material">
                <ul>
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-20"></i></span>
                    <input type="text" class="form-control" placeholder="First Name" ng-model="firstname" required>
                  </li>
                  
                  
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-21"></i></span>
                    <input type="text" class="form-control" placeholder="Last Name" ng-model="lastname" required>
                  </li>
                  
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-22"></i></span>
                    <input type="email" class="form-control" placeholder="Email" ng-model="email" required>
                  </li>
                  
                  
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-25"></i></span>
                    <input type="text" class="form-control" placeholder="Phone" ng-model="phone" required>
                  </li>
                  
                  
                   <li class="input-group"> <span class="input-group-addon"><i class="icon-23"></i></span>
                    <input type="text" class="form-control" placeholder="Username" ng-model="username" required>
                  </li>
                  
                  
                  <li class="input-group"> <span class="input-group-addon"><i class="icon-24"></i></span>
                    <input type="password" class="form-control" placeholder="Password" ng-model="passwd" required>
                  </li>

                 
                  <li>
                    <button type="submit" class="btn btn-submit waves-effect waves-button" ng-click="ctrl.register()">Register <i class="fa fa-angle-right"></i></button>
                  </li>
                  
                  
                </ul>
              </form>
              
              
              <div class="signup"> <a href="/project/login">Déjà membre? Se connecter</a> </div>
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