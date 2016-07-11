 
(function() {
	app.controller('SignUpController', [ '$rootScope', 
	                                    '$scope', 
	                                    '$http', 
	                                    '$location', 
	                                    '$log', 
	                                    '$timeout', 
	                                    'userService',
	                                    function($rootScope, $scope, $http, $location, $log, $timeout,userService) {

		$log.log("Inside the SignUp Controller");

		$scope.userSignUpDetails = {
				
				"organisation":{
					"base_organisation_id":"2"
				}
		};

		$scope.doSignUp = function(loginform,userSignUpDetails) {
			$log.log("Inside the doSignUp");
			if (loginform.$valid) {
				if (userSignUpDetails.email != null || userSignUpDetails.email != "" &&  
						userSignUpDetails.passWord != null || userSignUpDetails.passWord != "" &&
						userSignUpDetails.firstName != null || userSignUpDetails.firstName != "" &&
						userSignUpDetails.lastName != null || userSignUpDetails.lastName != "" &&
						userSignUpDetails.phoneNumber != null || userSignUpDetails.phoneNumber != "") {
					//var signUp = "http://localhost:8080/sloan_test/signup/create"
					//var signUp = "http://45.55.156.148:8080/sloan_test/signup/create"
					
					$log.log("Inside the doSignUp() Details cheking---",angular.toJson(userSignUpDetails));
					
					userService.UserObject=userSignUpDetails;
					console.log("user object in service ---",userService.UserObject);
					
					if(userSignUpDetails.userType =="CUSTOMER"){
						$location.url('/en-US/customer');
					}else if(userSignUpDetails.userType=="CAREGIVER"){
						$location.url('/en-US/careGiver');
					}
				}
			} else {
				alert('You must Enter all the field')
			}
		}
	} ]); 

})(); 
