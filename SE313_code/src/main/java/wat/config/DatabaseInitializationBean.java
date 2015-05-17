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

        historyRepository.save(new History(1l,"en","The temple houses an important Buddha statue: the Phra Buddha Sihing which gives the temple its name. The origins of this statue are unknown but, according to legend, it was based on the lion of Shakya, a statue since lost which used to be housed in the Mahabodhi Temple of Bodh Gaya (India). \n" +
                "The Phra Buddha Sihing statue is supposed to have been brought, via Ceylon (present day Sri Lanka), to Ligor (present day Nakhon Si Thammarat and from there, via Ayutthaya, to Chiang Mai.\n" +
                "\n" +
                "There are two more Buddha statues in Thailand which are claimed to be the Phra Buddha Sihing: one is housed in Wat Phra Mahathat in the city of Nakhon Si Thammarat and another in the Bangkok National Museum.\n" +
                "\n" +
                "It is alleged that the head of the statue had been stolen in 1922. The possibility remains that the present statue (or maybe only the head) is a copy.\n" +
                "\n" +
                "Every year, during the Songkran festival, the statue is taken from wihan Lai Kham and carried through the streets of Chiang Mai in a religious procession during which the spectators honour the statue by sprinkling water over it."));

        historyRepository.save(new History(2l,"th","พญาผายู กษัตริย์เชียงใหม่ราชวงศ์มังราย โปรดเกล้าฯ ให้สร้างขึ้นในปี พ.ศ. 1888 ขั้นแรกให้ก่อสร้างเจดีย์สูง 23 วา เพื่อบรรจุพระอัฐิของพญาคำฟู พระราชบิดา ต่อมาอีก 2 ปี จึงได้สร้างพระอาราม เสนาสนวิหาร ศาลาการเปรียญ หอไตร และกุฏิสงฆ์ เมื่อเสร็จเรียบร้อย ทรงตั้งชื่อว่า \"วัดลีเชียงพระ\" สมัยพระเจ้าแสนเมืองมา ขึ้นครองนครเชียงใหม่ โปรดให้อัญเชิญพระพุทธสิหิงค์มาจากเมืองเชียงราย เมื่อขบวนช้างอัญเชิญมาถึง \n พระพุทธสิหิงค์ หรือ พระสิงห์ เป็นพระพุทธรูปโบราณหล่อด้วยสำริดหุ้มทอง ปางมารวิชัย สูง 79 เซนติเมตร หน้าตักกว้าง 63 เซนติเมตร [2]เป็นศิลปะแบบลังกา ตามประวัติกล่าวว่า พระเจ้าสีหฬะ พระมหากษัตริย์แห่งลังกาทวีป ทรงสร้างขึ้น เมื่อ พ.ศ. 700 ต่อมา เจ้านครศรีธรรมราชได้ไปขอมาถวายพระร่วงแห่งกรุงสุโขทัย เมื่อสมเด็จพระบรมราชาธิราชที่ 1 แห่งกรุงศรีอยุธยาได้กรุงสุโขทัยเป็นเมืองขึ้น จึงได้อัญเชิญพระพุทธสิหิงค์มาประดิษฐานที่กรุงศรีอยุธยา"));

        Activity[] initActivity =  {
                new Activity(1l,"บายศรีสู่ขวัญ","บายศรีสู่ขวัญ กุฏิพระหอคำแปง สีหฬารามสามิกวัดพระสิงห์หลวง","th", ImageUtil.getImage("pic/1.JPG"))
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