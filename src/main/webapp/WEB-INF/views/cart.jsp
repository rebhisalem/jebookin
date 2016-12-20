<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../layout/header.jsp"></jsp:include>
<script src="/project/resources/js/services/cart/controller.js"></script>
<script src="/project/resources/js/services/cart/service.js"></script>
</head>
<body ng-app="myApp" class="ng-cloak">
<!-- Main Wrapper Start -->
<div id="wrapper" class="wrapper"> 
  
  <!-- Header Start -->
 <jsp:include page="../layout/menu.jsp"></jsp:include>
  <!-- Header End -->
  
  <!-- Main Content Start -->
  
  <div class="main-content cp-no-margin"> 
    
    <div class="cp-contactus">
    
    <!-- Contact Info -->
    <div class="container"  data-ng-controller="CartController as cart" >
      <div class="row">
        <div class="col-md-12">
        	<table class="table table-bordered table-striped">
               <thead>
                <tr>
                  <th>Produit</th>
                  <th>Titre</th>
                  <th>Quantité</th>
                  <th>Prix</th>
                </tr>
               </thead>
               <tbody data-ng-init="cart.init();cart.getItems()">
                <tr ng-repeat="book in cart.books">
                  <td><img src="{{book.image}}" class="img-cart" style="width: 50px;"></td>
                  <td><strong>{{book.title}}</strong></td>
                  <td>
                    <form class="form-inline cp-add2cart">
                  	  <input type="number" size="10" value="{{book.quantity}}" data-ng-model="book.quantity">
                      <button rel="tooltip" title="" class="btn btn-default" data-original-title="Update" ng-click="cart.updateQuantity($index)"><i class="fa fa-pencil"></i></button>
                      <button class="btn btn-primary" rel="tooltip" title="" data-original-title="Delete"  ng-click="cart.removeItem($index)"><i class="fa fa-trash-o"></i></a>
                    </form>
                  </td>
                  <td>\${{book.price}}</td>
                </tr>
                
                <tr>
                  <td colspan="4">&nbsp;</td>
                </tr>
                <tr>
                  <td colspan="3" class="text-right"><strong>Total</strong></td>
                  <td>\${{cart.getTotal()}}</td>
                </tr>
               </tbody>
              </table>
              <%
   Cookie cookie = null;
   Cookie[] cookies = null;
   String str ="";
   cookies = request.getCookies();
    if( cookies != null)
      {
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         String b = cookie.getName();
     	if(b.equals("username")) str = "yes"; 
     }
     }
%>
              <%if(str.equals("yes")) out.print("<button class='btn btn-submit waves-effect waves-button' type='submit' ng-click='cart.checkout()' style='float: right;'>Passer au paiement <i class='fa fa-angle-right'></i></button>"); %>
        </div>
      </div>
    </div>
    <!-- Contact Info End -->

    
<div class="toggle-map"> <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
  <i class="fa fa-map-marker"></i>Catch us on the Google Map</a></div>
   

<div class="collapse" id="collapseExample">
  <div class="map_canvas"><iframe src="https://www.google.com/maps/embed?pb=!1m23!1m12!1m3!1d48017.06136075545!2d-73.91451093738752!3d41.220324869199096!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m8!3e6!4m0!4m5!1s0x89c2c7af73d9f113%3A0x989d7a27d4e11134!2s98-100+S+Mt+Airy+Rd%2C+Croton-on-Hudson%2C+NY+10520%2C+USA!3m2!1d41.2202662!2d-73.8776032!5e0!3m2!1sen!2s!4v1439804205954" width="600" height="550" frameborder="0" style="border:0" allowfullscreen></iframe></div>
</div>
    
</div>
    
  </div>
  
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
  <jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
<!-- Main Wrapper End --> 

</body>
</html>