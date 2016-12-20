'use strict';
 
App.controller('CommentController', ['$scope', 'CommentService', function($scope, CommentService) {
          var self = this;
		  $scope.items = null;
          self.comment={commentId:null,commentDate:'',contenu:'',commenterName:''};
          self.comments=[];
          
          self.fetchAllBookComments = function(id){
			   CommentService.fetchAllBookComments(id)
					  .then(
							   function(d) {
									self.comments = d;
							   },
							   function(errResponse){
									console.error('Error while fetching comments');
								}
						);
          };
		  
		  self.postComment = function(id){
			  var name = $scope.name;
			  var email = $scope.email;
			  var content = $scope.content;
			  //alert(self.date_and_time());
			  if(name == "" || name == undefined){alert('Merci de saisir votre nom'); return;}
			  else if(email == "" || email == undefined){ alert('Merci de saisir votre email'); return;}
			  else if(content == "" || content == undefined){ alert('Merci de saisir un commentaire'); return;}
			  else{
					CommentService.postComment(id, name, email, content);
					var d = self.date_and_time();
					self.comments.push({commentId:null,commentDate:d,contenu:content,commenterName:name});
			  }
		  };
		  
		  self.date_and_time = function() {
			var date = new Date();
			//zero-pad a single zero if needed
			var zp = function (val){
				return (val <= 9 ? '0' + val : '' + val);
			}

			//zero-pad up to two zeroes if needed
			var zp2 = function(val){
				return val <= 99? (val <=9? '00' + val : '0' + val) : ('' + val ) ;
			}

			var d = date.getDate();
			var m = date.getMonth() + 1;
			var y = date.getFullYear();
			var h = date.getHours();
			var min = date.getMinutes();
			var s = date.getSeconds();
			var ms = date.getMilliseconds();
			return '' + y + '-' + zp(m) + '-' + zp(d) + ' @ ' + zp(h) + ':' + zp(min) + ':' + zp(s);
		}
		 
      }]);