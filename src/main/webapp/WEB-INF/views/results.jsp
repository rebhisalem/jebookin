<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
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
  
  <div class="main-content" data-ng-controller="BookController as ctrl"> 
    <div align="left" data-ng-init="ctrl.fetchBooksbyTitle('<% request.setCharacterEncoding("UTF-8"); out.print(URLDecoder.decode(request.getParameter("search"))); %>')">
    <!-- Post Details -->
    <div class="cp-authors">
      <div class="container">
        <div class="row">
          <ul class="cp-authors-grid" ng-repeat="book in ctrl.books">
            
            <!-- Author Box -->
            <li class="col-md-4 col-sm-6">
              <div class="cp-author-box">
                <div class="cp-thumb"><img src="{{book.url}}" alt=""></div>
                <h3><a href="/project/books/{{book.bookID}}">{{book.title}}</a></h3>
                <ul class="cp-post-tools">
                	<li><i class="icon-1"></i> {{book.publish_date}}</li>
                	<li data-ng-controller="AuthorController as actrl" data-ng-init="actrl.fetchAllAuthors($parent.book.bookID)"><i class="icon-2" ng-repeat="author in actrl.authors">{{author.firstname}} {{author.lastname}}</i></li>
                </ul>
                <p>\${{book.prix}}</p>
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