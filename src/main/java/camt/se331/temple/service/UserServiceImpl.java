package camt.se331.temple.service;

import camt.se331.temple.entity.QA;
import camt.se331.temple.entity.User;
import camt.se331.temple.repository.QARepository;
import camt.se331.temple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    QARepository QARepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String username) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public QA addQA(User user, QA QA) {
        User currentUser = userRepository.findOne(user.getId());
        currentUser.getQAs().add(QA);
        QA.setUser(currentUser);
        QARepository.save(QA);
        return QA;
    }
}
