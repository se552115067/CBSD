package wat.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import wat.entity.Activity;
import wat.entity.History;
import wat.entity.Role;
import wat.entity.User;
import wat.repository.ActivityRepository;
import wat.repository.HistoryRepository;
import wat.repository.RoleRepository;
import wat.repository.UserRepository;
import wat.service.ImageUtil;

import java.util.*;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void afterPropertiesSet() throws Exception {

        historyRepository.save(new History(1l,"en","Thi is Temple"));
        Activity[] initActivity =  {
                new Activity(1l,"Kindle","the good book reader","EN", ImageUtil.getImage("pic/1.JPG"))
        };
        activityRepository.save(Arrays.asList(initActivity));
        // add user
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");


        User admin = new User();
        admin.setName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();
        user.setName("user");
        user.setUsername("user");
        user.setEmail("punjasin@gmail.com");
        user.setPassword("123456");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);
        userRepository.save(admin);
        userRepository.save(user);
        admin.setRoles(roles);
        user.setRoles(roles2);
    }
}