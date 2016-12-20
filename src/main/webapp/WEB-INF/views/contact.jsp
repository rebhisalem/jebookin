<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../layout/header.jsp"></jsp:include>
<script src="/project/resources/js/services/contact/controller.js"></script>
<script src="/project/resources/js/services/contact/service.js"></script>
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
    <div class="container">
      <div class="row">
        <div class="col-md-8">
          <div class="cp-contact-form">
            <form class="material" data-ng-controller="ContactController as ctrl">
              <ul>
              
                <li class="input-group"> <span class="input-group-addon"><i class="icon-2"></i></span>
                  <input type="text" class="form-control" placeholder="Nom" ng-model="name" required>
                </li>
              
                <li class="input-group"> <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                  <input type="email" class="form-control" placeholder="Email" ng-model="email" required>
                </li>
              
                <li class="input-group"> <span class="input-group-addon"><i class="fa fa-paperclip"></i></span>
                  <input type="text" class="form-control" placeholder="Sujet" ng-model="subject" required>
                </li>
              
                <li class="input-group"> <span class="input-group-addon"><i class="fa fa-pencil"></i></span>
                  <textarea class="form-control" placeholder="Message" ng-model="msg" required></textarea>
             
                </li>
                
             <li>
                <button type="submit" class="btn btn-submit waves-effect waves-button" ng-click="ctrl.send()">Envoyer <i class="fa fa-angle-right"></i></button>
              
              
                </li>
              </ul>
            </form>
          </div>
        </div>
        <div class="col-md-4">
        <div class="contact-info">
        <address>
        <ul>
        <li><span class="address-addon"><i class="fa fa-university"></i></span>
        <p>The Material Magazine Building,
123 South Road, Industrial Avenue,
1234 New York, U.S.A.</p>
        </li>
        <li><span class="address-addon"><i class="fa fa-phone"></i></span><p>Phone: 0123 456 7890</p></li>
        <li><span class="address-addon"><i class="fa fa-fax"></i></span><p>Fax: 0800 080 1234</p></li>
        <li><span class="address-addon"><i class="fa fa-skype"></i></span><p>Skype: +12 8564 232</p></li>
        <li><span class="address-addon"><i class="fa fa-envelope-o"></i></span><p>Email: info@materialmag.com</p></li>
        <li><span class="address-addon"><i class="fa fa-globe"></i></span><p>www.materialmag.com</p></li>
        </ul>
        </address>
        
        </div>
        
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