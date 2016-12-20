<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../layout/header.jsp"></jsp:include>

<script src="/project/resources/js/services/author/controller.js"></script>
<script src="/project/resources/js/services/author/service.js"></script>
<script src="/project/resources/js/services/comment/controller.js"></script>
<script src="/project/resources/js/services/comment/service.js"></script>
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
  
  <div class="main-content"> 
    <!-- Product Details -->
    
    <div class="cp-product-details" data-ng-controller="BookController as ctrl" data-ng-init="ctrl.getBook(<% out.print(request.getParameter("id")); %>)">
    <input type="hidden" ng-model="curbookID" value=<% out.print(request.getParameter("id")); %> />
      <div class="container" >
      
        <div class="row" >
          <div class="col-md-5 col-sm-5">
            <div class="cp-thumb"><img src="{{ctrl.book.url}}" alt=""></div>
          </div>
          <div class="col-md-7 col-sm-7">
            <div class="cp-pro-content">
              <h3>{{ctrl.book.title}}</h3>
              <div class="price"><ins>\${{ctrl.book.prix}}</ins> </div>
              <span ng-bind-html="ctrl.book.description | html"></span>
              <div class="product-tools">
                <ul class="brand-code">
                  <li><strong>ISBN:</strong> {{ctrl.book.bookID}}</li>
                  <li data-ng-controller="AuthorController as actrl" data-ng-init="actrl.fetchAllAuthors(<% out.print(request.getParameter("id")); %>)"><strong style="float:left;">Ecrivain(s):</strong><ul style="margin-left: 35px;"><li ng-repeat="author in actrl.authors">{{author.firstname}} {{author.lastname}}</li></ul></li>
                </ul>
                <ul class="pro-tags">
                  <li><strong>Quantité en stock:</strong> {{ctrl.book.stock}}</li>
                  <li><strong>Thème:</strong><a href="/project/books/cat/{{ctrl.book.theme}}"> {{ctrl.book.theme}}</a></li>
                </ul>
              </div>
              <div class="cp-add2cart" data-ng-controller="CartController as cart" ng-init="cart.init()">
                <div id="input_div">
                  <input type="button" value="-" id="moins" onclick="minus()">
                  <input type="text" size="10" value="1" id="count" ng-model="ctrl.book.quantity" ng-change="ctrl.verifQuantity()">
                  <input type="button" value="+" id="plus" onclick="plus()">
                </div>
                <script>
    var countEl = document.getElementById("count");
    function plus(){
    	var count = parseInt(document.getElementById("count").value);
        countEl.value = count+1;
        $("#count").trigger("change");
    }
    function minus(){	
      if (countEl.value>1) {
        var count = parseInt(document.getElementById("count").value);
        countEl.value = count-1;
        $("#count").trigger("change");
      }  
    }
</script>
                <div class="cp-cart-button"> <button class="cart-button waves-effect waves-button" ng-click="ctrl.verifQuantity();cart.addItem(ctrl.book)">Ajouter au panier <i class="fa fa-shopping-cart"></i></a> </div>
              </div>
            </div>
          </div>
        </div>
        <div class="cp-pro-details-tabs">
          <div class="row">
            <div class="col-md-12">
              <div role="tabpanel"> 
                
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                  <li role="presentation" class="active"><a href="#reviews" aria-controls="reviews" role="tab" data-toggle="tab" aria-expanded="true">Commentaires</a></li>
                </ul>
                
                <!-- Tab panes -->
                <div class="tab-content"  data-ng-controller="CommentController as cCtrl" data-ng-init="cCtrl.fetchAllBookComments(<% out.print(request.getParameter("id")); %>)">
                  
                  <div role="tabpanel" class="tab-pane active" id="reviews">
                   
                  <ul class="cp-reviews">
                  <li ng-repeat="comment in cCtrl.comments">
                    <div class="reviews">
                      <div class="cp-review">
                        <h4><a href="#">{{comment.commenterName}}</a></h4>
                        <div class="date-time"><i class="icon-1"></i> {{comment.commentDate | date:'dd/MM/yyyy @ h:mm:ss'}}
                        <p>{{comment.contenu}}</p>
                      </div>
                    </div>
                    
                  </li>
                </ul>
                
                
                <div class="cp-review-form">
                <h3>Ajouter un commentaire</h3>
                <form  class="row material">
                    <div class="col-md-6">
                      <div class="input-group">
                        <div class="material-input input">
                          <div class="material-input input"><input type="text" id="name" name="name" placeholder="Nom" required ng-model="name"><span class="material-bar"></span></div>
                          <span class="material-bar"></span></div>
                        <div class="material-input input">
                          <div class="material-input input"><input type="email" id="email" name="email" placeholder="Email" required ng-model="email"><span class="material-bar"></span></div>
                          <span class="material-bar"></span></div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="input-group">
                        <div class="material-input textarea">
                          <div class="material-input textarea"><textarea id="review" name="reviews" placeholder="Commentaire" ng-model="content" required></textarea><span class="material-bar"></span></div>
                          <span class="material-bar"></span></div>
                      </div>
                      <button class="btn btn-submit waves-effect waves-button" type="submit" ng-click="cCtrl.postComment(ctrl.book.bookID)">Poster <i class="fa fa-angle-right"></i></button>
                    </div>
                  </form>
                 </div>

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Product Details End --> 
    
  </div>
  
  <!-- Main Content End --> 
  
  <!-- Footer Start -->
 <jsp:include page="../layout/footer.jsp"></jsp:include>
  <!-- Footer End --> 
  
</div>
<!-- Main Wrapper End --> 
</body>
</html>