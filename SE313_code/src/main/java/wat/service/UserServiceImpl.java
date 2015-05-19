package wat.service;

import wat.dao.UserDao;
import wat.entity.User;
import wat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserDao userDao;



    @Override
    public List<User> findAll() {
                     return userRepository.findAll();
                 }

    @Override
    public User getbyid(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUserName(String username) {
            return userRepository.findByUsername(username);
        }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }
}
