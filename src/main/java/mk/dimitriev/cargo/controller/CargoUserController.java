package mk.dimitriev.cargo.controller;

import java.util.List;

import mk.dimitriev.cargo.model.CargoUser;
import mk.dimitriev.cargo.service.CargoUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CargoUserController {

	@Autowired
    private CargoUserService userService;
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<CargoUser>> listAllUsers() {
        final List<CargoUser> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<CargoUser>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CargoUser>>(users, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CargoUser> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        CargoUser user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<CargoUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CargoUser>(user, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody CargoUser user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CargoUser> updateUser(@PathVariable("id") long id, @RequestBody CargoUser user) {
        System.out.println("Updating User " + id);
         
        final CargoUser currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<CargoUser>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<CargoUser>(currentUser, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CargoUser> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        final CargoUser user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<CargoUser>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<CargoUser>(HttpStatus.NO_CONTENT);
    }
 
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<CargoUser> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<CargoUser>(HttpStatus.NO_CONTENT);
    }
}
