package mk.dimitriev.cargo.service;

import java.util.List;

import mk.dimitriev.cargo.model.CargoUser;

public interface CargoUserService {

	CargoUser findById(long id);
	
	CargoUser findByName(String name);
	
	void saveUser(CargoUser user);
	
	void updateUser(CargoUser user);
	
	void deleteUserById(long id);

	List<CargoUser> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(CargoUser user);
}
