'use strict';

App.controller('CargoUserController', ['$scope', 'CargoUserService', function($scope, CargoUserService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.users=[];
              
          self.fetchAllUsers = function(){
        	  CargoUserService.fetchAllUsers()
                  .then(
	  					       function(d) {
	  						        self.users = d;
	  					       },
	  					       
	        				   function(errResponse){
	        						console.error('Error while fetching Currencies');
	        				   }
      			       );
          };
           
          self.createUser = function(user){
        	  CargoUserService.createUser(user)
		              .then(
		            		  self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };

         self.updateUser = function(user, id){
        	 CargoUserService.updateUser(user, id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
                  );
          };

         self.deleteUser = function(id){
        	 CargoUserService.deleteUser(id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
                  );
          };

          self.fetchAllUsers();

          self.submit = function() {
              if(self.user.id==null){
                  console.log('Saving New User', self.user);    
                  self.createUser(self.user);
              }else{
                  self.updateUser(self.user, self.user.id);
                  console.log('User updated with id ', self.user.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].id == id) {
                     self.user = angular.copy(self.users[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.users.length; i++){//clean form if the user to be deleted is shown there.
                  if(self.users[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteUser(id);
          };

          
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);