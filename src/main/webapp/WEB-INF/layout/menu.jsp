<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
  
    <div id="cp-header" class="cp-header"> 
    
    <!-- Topbar Start -->
    <div class="cp-topbar">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <ul class="toplinks">
              <li class="waves-effect waves-button"><i class="fa fa-phone"></i> + 216 71 703 829</li>
              <li class="waves-effect waves-button"><i class="fa fa-envelope-o"></i> <a href="mailto:info@jebouquine.tn">info@jebouquine.tn</a></li>
            </ul>
          </div>
          <%
   Cookie cookie = null;
   Cookie[] cookies = null;
   String str = "login";
   cookies = request.getCookies();
    if( cookies != null)
      {
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         String b = cookie.getName();
     	if(b.equals("username")) str = "logout"; 
     }
     }
%>
          <div class="col-md-6">
            <div class="cp-toptools pull-right">
              <ul>
                <li class="headings"><a href="/project/<% out.print(str); %>"><i class="icon-2"></i></a></li>
                <% if(str.equals("login")) out.print("<li class=\"headings\"><a href=\"/project/register\"><i class=\"fa fa-sign-in\"></i></a></li>"); %>
                <li class="headings"><a href="/project/books/cart"><i class="fa fa-cart-arrow-down"></i></a></li>
              </ul>
            </div>
            <div class="cp-topsocial pull-right">
              <ul>
                <li class="waves-effect"><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li class="waves-effect"><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li class="waves-effect"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                <li class="waves-effect"><a href="#"><i class="fa fa-youtube"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Topbar End --> 
    
    <!-- Logo row Start -->
    <div class="cp-logo-row">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="logo"><a href="/project/index"><img src="/project/resources/images/logo.png"></a></div>
          </div>
        </div>
      </div>
    </div>
    <!-- Logo row Start --> 
    
    <!-- Mega Menu Start -->
    <div class="cp-megamenu">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="cp-mega-menu">
              <label for="mobile-button"> <i class="fa fa-bars"></i> </label>
              <!-- mobile click button to show menu -->
              <input id="mobile-button" type="checkbox">
              <ul class="collapse main-menu">
			  <li class="slogo"><a href="index.html"><img src="/project/resources/images/logo-micon.png" alt=""></a></li>
                <li>
					<a href="/project/index">Accueil</a>
                </li>
                <li data-ng-controller="BookController as ctr" data-ng-init="ctr.getAllThemes()">
					<a href="/project/books">Catalogue</a>
					<div class="drop-down full-width text-links hover-expand"> <!-- full width drop down with 4 columns -->
                    <ul ng-repeat="mythemes in ctr.themes">
                      <!-- column one -->
                      <li ng-repeat="theme in mythemes"> <a href="/project/books/cat/{{theme}}">{{theme}}</a> </li>
                    </ul>
                  </div>
                </li>
				<li>
					<a href="/project/authors">Ecrivains</a>
                </li>
                <li>
					<a href="/project/books/cart">Panier</a>
                </li>
				<li>
					<a href="/project/contact">Contacter Nous</a> 
                </li>
				<li class="search-bar"> <i class="icon-7"></i> <!-- search bar -->
                  
                  <ul class="drop-down hover-expand">
                    <li>
                      <form method="get" action="/project/books/results" >
                        <table>
                          <tr>
                            <td><input type="text" name="search" placeholder="Chercher un livre par titre"></td>
                            <td><input type="submit" value="Rechercher"></td>
                          </tr>
                        </table>
                      </form>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Mega Menu End --> 
    
  </div>
  
  <!--  Innner header bg  -->
  
  <div class="cp-inner-main-banner top-banner-bg1"></div>
  
  <!--  Innner header bg End  -->  