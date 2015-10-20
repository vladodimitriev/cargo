package mk.dimitriev.cargo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import mk.dimitriev.cargo.model.CargoUser;
import mk.dimitriev.cargo.service.CargoUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cargoUserService")
@Transactional
public class CargoUserServiceImpl implements CargoUserService {

private static final AtomicLong counter = new AtomicLong();
	
	private static List<CargoUser> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<CargoUser> findAllUsers() {
		return users;
	}
	
	public CargoUser findById(long id) {
		for(CargoUser user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public CargoUser findByName(String name) {
		for(CargoUser user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(CargoUser user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(CargoUser user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<CargoUser> iterator = users.iterator(); iterator.hasNext(); ) {
		    CargoUser user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(CargoUser user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<CargoUser> populateDummyUsers(){
		List<CargoUser> users = new ArrayList<CargoUser>();
		users.add(new CargoUser(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		users.add(new CargoUser(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		users.add(new CargoUser(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
		return users;
	}
}
