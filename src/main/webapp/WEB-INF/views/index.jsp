<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
  <!-- Header End --> 
  <!-- Main Content Start -->
  <div class="main-content">
    <div class="container">
      <div class="row"> 
        
        <!-- Left Content Area Start -->
        <div class="col-md-8"> 
          
          <!-- Featured Start -->
          
          <div class="cp-news-grid-style-1">
            <div class="section-title blue-border">
              <h2>Populaires</h2>
              <small>Livres les plus vendus</small> </div>
            <div class="row" data-ng-controller="BookController as ctrl" data-ng-init="ctrl.fetchFeaturedBooks()">
              <ul class="grid">
                <li class="col-md-6 col-sm-6" ng-repeat="book in ctrl.books">
                  <div class="cp-news-post-excerpt">
                    <div class="cp-thumb"><img src="{{book.url}}" alt=""></div>
                    <div class="cp-post-content">
                      <div class="catname"><a class="catname-btn btn-purple waves-effect waves-button" href="/project/books/cat/{{book.theme}}">{{book.theme}}</a></div>
                      <h3><a href="/project/books/{{book.bookID}}">{{book.title}}</a></h3>
                      <ul class="cp-post-tools">
                        <li><i class="icon-1"></i> {{book.publish_date}}</li>
                        <li data-ng-controller="AuthorController as actrl" data-ng-init="actrl.fetchAllAuthors($parent.book.bookID)"><i class="icon-2" ng-repeat="author in actrl.authors">{{author.firstname}} {{author.lastname}}</i></li>
                      </ul>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          
          <!-- Featured End --> 
          
          <!-- Latest Start -->
          <div class="cp-news-grid-style-1">
            <div class="section-title blue-border">
              <h2>Nouveautés</h2>
              <small>Livres les plus récents</small> </div>
            <div class="row" data-ng-controller="BookController as ctrl" data-ng-init="ctrl.fetchRecentBooks()">
              <ul class="grid">
                <li class="col-md-6 col-sm-6" ng-repeat="book in ctrl.books">
                  <div class="cp-news-post-excerpt">
                    <div class="cp-thumb"><img src="{{book.url}}" alt=""></div>
                    <div class="cp-post-content">
                      <div class="catname"><a class="catname-btn btn-purple waves-effect waves-button" href="/project/books/cat/{{book.theme}}">{{book.theme}}</a></div>
                      <h3><a href="/project/books/{{book.bookID}}">{{book.title}}</a></h3>
                      <ul class="cp-post-tools">
                        <li><i class="icon-1"></i> {{book.publish_date}}</li>
                        <li data-ng-controller="AuthorController as actrl" data-ng-init="actrl.fetchAllAuthors($parent.book.bookID)"><i class="icon-2" ng-repeat="author in actrl.authors">{{author.firstname}} {{author.lastname}}</i></li>
                      </ul>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- Latest End --> 
          
        </div>
        <!-- Left Content Area End --> 
        
        <!-- Right Sidebar -->
        <div class="col-md-4">
          <div class="sidebar side-bar right-sidebar"> 
            
            <!--Video Widget Start -->
            
            <div class="widget sidebar-video">
              <h3 class="side-title">Video Widget</h3>
              <div class="cp-sidebar-content">
                <iframe src="https://player.vimeo.com/video/4238052"></iframe>
              </div>
            </div>
            
            <!--Video Widget End --> 
            
            <!--Most Commented Start -->
            <!-- 
            <div class="widget most-commented">
              <h3 class="side-title">Most Commented</h3>
              <div class="cp-sidebar-content">
                <ul>
                  <li><a href="#">Donec aliquam odio ac tempor semper.</a> <i>20</i></li>
                  <li><a href="#">Nulla ut lectus in dui egestas rhoncus...</a> <i>17</i></li>
                  <li><a href="#">Aenean blandit neque egestas sagittis...</a> <i>15</i></li>
                  <li><a href="#">In id dolor facilisis dui tempor euismod...</a> <i>11</i></li>
                </ul>
              </div>
            </div>
            -->
            <!--Most Commented End --> 
            
            <!--Top Authors Start -->
            <!--
            <div class="widget top-authors">
              <h3 class="side-title">Top Authors</h3>
              <div class="cp-sidebar-content">
                <ul class="authors">
                  <li><a href="#"><img src="/resources/images/ta-1.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-2.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-3.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-4.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-5.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-6.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-7.jpg" alt=""></a></li>
                  <li><a href="#"><img src="/resources/images/ta-8.jpg" alt=""></a></li>
                </ul>
              </div>
            </div>
            -->
            <!--Top Authors End --> 
            
            <!--latest Reviews Start -->
            <!--
            <div class="widget latest-reviews">
              <h3 class="side-title">Latest Reviews</h3>
              <div class="cp-sidebar-content">
                <ul class="reviews">
                  <li>
                    <h4><a href="#">Donec consequat diam ut pharetra auctor</a></h4>
                    <div class="cp-rating"><a href="#"><i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-10"></i></a></div>
                    <i class="tag">8.2</i> </li>
                  <li>
                    <h4><a href="#">Morbi vel metus vitae nunc fermentum </a></h4>
                    <div class="cp-rating"><a href="#"><i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-10"></i></a></div>
                    <i class="tag">9.2</i> </li>
                  <li>
                    <h4><a href="#">Proin ut sapien tempor laoreet mauris</a></h4>
                    <div class="cp-rating"><a href="#"><i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-10"></i></a></div>
                    <i class="tag">7.2</i> </li>
                  <li>
                    <h4><a href="#">Vivamus feugiat lacus vitae aliquet</a></h4>
                    <div class="cp-rating"><a href="#"><i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-9"></i> <i class="icon-10"></i></a></div>
                    <i class="tag">5.2</i> </li>
                </ul>
              </div>
            </div>
            -->
            <!--latest Reviews End --> 
            
            <!-- Advertisement Start -->
            <!--
            <div class="widget advertisement">
              <div class="ad-holder"><img src="/resources/images/sidebarad.jpg" alt=""></div>
            </div>
            -->
            <!-- Advertisement End --> 
          </div>
        </div>
        <!-- Right Sidebar --> 
        
      </div>
    </div>
  </div>
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
<jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
<!-- Main Wrapper End --> 

<!-- Js Files--> 
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script> 
<script src="<c:url value="/resources/js/jquery-migrate-1.2.1.min.js" />"></script> 
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> 
<script src="<c:url value="/resources/js/materialize.min.js" />"></script> 
<script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/resources/js/custom.js" />"></script>


</body>
</html>