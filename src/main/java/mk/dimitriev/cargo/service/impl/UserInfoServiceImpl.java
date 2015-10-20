package mk.dimitriev.cargo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mk.dimitriev.cargo.service.UserInfoService;

@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

}
