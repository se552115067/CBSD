package camt.se331.temple.config;

import camt.se331.temple.entity.*;
import camt.se331.temple.repository.ActivityRepository;
import camt.se331.temple.repository.RoleRepository;
import camt.se331.temple.repository.QARepository;
import camt.se331.temple.repository.UserRepository;
import camt.se331.temple.service.ImageUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    QARepository qaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Activity[] initActivity =  {
                new Activity(1l,"Kindle","the good book reader","en", ImageUtil.getImage("pic/x.png")),
                new Activity(2l,"Surface Pro","The unknow computer","en",ImageUtil.getImage("pic/x.png")),
                new Activity(3l,"Mac pro"," Mac book interim","en",ImageUtil.getImage("pic/x.png")),
                new Activity(4l,"Candle","use for lightenup the world","en",ImageUtil.getImage("pic/x.png")),
                new Activity(5l,"Bin","User for what ?","en",ImageUtil.getImage("pic/x.png")),
                new Activity(6l,"Telephone", "Call the others","en",ImageUtil.getImage("pic/x.png")),
                new Activity(7l,"iPhone","What is it?","en",ImageUtil.getImage("pic/x.png")),
                new Activity(8l,"Galaxy Note 4","Who still use this ?","en",ImageUtil.getImage("pic/x.png")),
                new Activity(9l,"AngularJS","we hate it","en",ImageUtil.getImage("pic/x.png")),
                new Activity(10l,"Mazda 3","Very handsome guy use this","en",ImageUtil.getImage("pic/x.png"))
        };

        activityRepository.save(Arrays.asList(initActivity));
        activityRepository.save(new Activity(1l,"Kindle","the good book reader","en"));

        QA qa = new QA();
        List<SelectedProduct> selectedProducts = new ArrayList<>();
        SelectedProduct[] initSelectedProduct = {
                new SelectedProduct(initActivity[2], 5),
                new SelectedProduct(initActivity[4], 2),
                new SelectedProduct(initActivity[1], 1),
        };
        selectedProducts.addAll(Arrays.asList(initSelectedProduct));
        Calendar calendar = new GregorianCalendar(2015,4,7);
        qa.setSelectedProducts(selectedProducts);
        qa.setPurchaseDate(calendar.getTime());
        qa.setId(1L);
        qaRepository.save(qa);

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
        user.setEmail("user@yahoo.com");
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
