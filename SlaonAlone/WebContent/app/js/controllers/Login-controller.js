/**
 * Login Controller is used to check whether the given input is right or wrong
 * in DB.
 * 
 */
(function() {
	/*var app = angular.module('Sloan_test_1');*/
	app.controller('LoginController', [ '$rootScope', 
	                                    '$scope', 
	                                    '$http', 
	                                    '$location', 
	                                    '$log', 
	                                    '$timeout', 
	                                    'Facebook',
	                                    function($rootScope, $scope, $http, $location, $log, $timeout,Facebook) {

		$log.log("Inside the Login Controller");

		$scope.userDetails = {};

		$scope.signUpLocation = function(){
			console.log('Inside The signUpLocation()')
			$location.url('/en-US/signup/');
		}
		
		$scope.doLogin = function(loginform,userDetails) {
			$log.log("Inside the doLogin()");
			if (loginform.$valid) {
				if (userDetails.email != null || userDetails.email != "" && userDetails.passWord != null || userDetails.passWord != "") {
					var login = "http://localhost:8080/SlaonAlone/login/loginValidation"
					//var login = "http://45.55.156.148:8080/sloan_test/login/loginValidation"
					$log.log("Inside the doLogin() Details cheking",angular.toJson(userDetails));
					
					$http({
						url : login,
						method:"POST",
						data :angular.toJson($scope.userDetails),
						headers : {
							"content-type":"application/json",
					        'Accept': 'application/json'
						}
					}).success (function(data) {
							if(data.responseSuccess == "success"){
								$log.log("User SuccessFully Logged In ",angular.toJson( data));
								alert("Login Sucess");
							}
							else if(data.responseError == "error"){
								$log.log("Invalid Logged In ",angular.toJson( data));
								alert("Invalid Login");
							}
						}).error(function(data) {
							$log.log("Internal Server Error", angular.toJson( data));
					});	
				}
			} else {
				//alert('You must Enter all the field')
				console.log("You must Enter all the field")
			}
		}
		
	
		/**
		 * Facebook Login implementation
		 */
        
        $scope.fbLogin=function(){
            Facebook.login(function(response) {
                if (response.status == 'connected') {
                	alert("FB connected");
                	$scope.me(response.authResponse.accessToken);
                }else{
                	console.log("FB not connected");
                }
            },{
            	scope: 'email,user_website,user_photos', 
            	   return_scopes: true,
            });
        }

        /**
         * fetch FB user email and name
         */
        $scope.me = function(accessToken) {
            Facebook.api('/me?fields=email,name', function(authResponse) {
           	$scope.fbuser = authResponse;
            console.debug("$scope.user.name"+angular.toJson($scope.fbuser));
            checkEmail($scope.fbuser.email,$scope.fbuser.name,'fb');
           });
        };

        /**
         * G+ login implementation
         */
        $scope.gplusLogin = function(callback)
			{
				 $scope.clientId = "24932703999-ve2oh92tsibhau5j0du6skunvi29g7og.apps.googleusercontent.com";
				 gapi.auth.signIn({
		    	      'callback': function(authResult){
		    	    	  $scope.signinCallback(authResult, callback);
		    	      },
		    	      'clientid': $scope.clientId,
		    	      'cookiepolicy': 'single_host_origin',
		    	      'data-accesstype':'offline',
		    	      'scope': 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.email',
		    	      'data-requestvisibleactions': 'http://schemas.google.com/AddActivity'
		    	    });
			}
			
			$scope.signinCallback= function(authResult, callback) {
				
				if (authResult['status']['signed_in']) {
					gapi.client.load('plus','v1', function(){ 
		                var request = gapi.client.plus.people.get({'userId' : 'me'});
		                request.execute(function(response) {
		                    var email = '';
		                    
						    if(response['emails'])
						    {
						        for(i = 0; i < response['emails'].length; i++)
						        {
						            if(response['emails'][i]['type'] == 'account')
						            {
						                email = response['emails'][i]['value'];
						            }
						        }
						    }
						    alert('gplus connected: '+email);
		                    //send response to server
							// TODO create new user ie. call signup if not exist else login
		                });
		            });

				} else if (authResult['error']) {
					console.log("G+ NOT CONNECTED");
				  }
			}

			/**
			 * This method checks if email address of signed in FB user exists or not,
			 * if not then it will ask for the same in a modal window.
			 */
			$scope.modalData ={};
			$scope.fb={};
			function checkEmail(email,name,type){
				$scope.$apply(function() {
					if(email == null || email == undefined){
					    	var tempdata = {"name":name,"type":type};
					    	var modalInstance = $modal.open({
					            animation: true,
					            templateUrl: 'app/views/en-US/templates/modals/social/get_email.html',
					            controller: 'FBLoginModalCtrl',
					            resolve: {
					                data: function () {
					                  return angular.copy(tempdata); // deep copy
					                },
					              }
					        });
					    	
					    modalInstance.result.then(function (dataFromModal) {
					    	$scope.modalData = dataFromModal;
					    	$scope.fb.email = $scope.modalData.email;
							$scope.fb.name = $scope.modalData.name;
							$scope.fb.type= $scope.modalData.type;
							// TODO create new user ie. call signup if not exist else login
							
					      }, function () {
					        $log.info('Modal dismissed at: ' + new Date());
					      });
					   
					} else {
						// create new user if not exist and login
					}
	              });
				
			}

			
			
	} ]); 

})(); 
