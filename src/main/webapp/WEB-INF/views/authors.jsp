<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../layout/header.jsp"></jsp:include>
<script src="/project/resources/js/services/author/controller.js"></script>
<script src="/project/resources/js/services/author/service.js"></script>
</head>
<body ng-app="myApp" class="ng-cloak">

<!-- Main Wrapper Start -->
<div id="wrapper" class="wrapper"> 
  
  <!-- Header Start -->
  <jsp:include page="../layout/menu.jsp"></jsp:include>
  <!-- Main Content Start -->
  
  <div class="main-content"> 
    <div align="left" data-ng-controller="AuthorController as ctrl" data-ng-init="ctrl.fetchAllAuthors()">
    <!-- Post Details -->
    <div class="cp-authors">
      <div class="container">
        <div class="row">
          <ul class="cp-authors-grid" ng-repeat="author in ctrl.authors">
            
            <!-- Author Box -->
            <li class="col-md-4 col-sm-6">
              <div class="cp-author-box">
                <div class="cp-thumb"><img src="{{author.url}}" alt=""></div>
                <h3>{{author.firstname}} {{author.lastname}}</h3>
              </div>
            </li>
            <!-- Author Box End --> 
            
          </ul>
        </div>
      </div>
    </div>
    <!-- Fashion Category  Main Post End --> 
    
  </div>
  
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
  <jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
</div>
<!-- Main Wrapper End --> 
</body>
</html>