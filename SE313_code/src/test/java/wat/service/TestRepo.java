package wat.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import wat.dao.UserDao;
import wat.entity.*;
import wat.repository.HistoryRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Punjasin on 5/19/2015.
 */
public class TestRepo {
    @Before
            public void setup(){


    }
    @Test
    public void test(){

        User testuser=new User(3l,"ABC","abc","User1","abc@abcmail.com");
        UserDao u=mock(UserDao.class);
        when(u.addUser(testuser)).thenReturn(new User(3l,"ABC","abc","User1","abc@abcmail.com"));
//        when(u.addUser(testuser)).thenReturn(new User(1l,"","","abc","abc@abcmail.com"));
//        when(u.addUser(testuser)).thenReturn(new User(null,"","","",""));

    }

    @Test
    public void test1(){

        User[] testuser={new User(1l,"user","123456","User","panjasin@gmail.com"),
                        new User(2l,"admin","123456","Admin","admin@yahoo.com")};

        UserDao u=mock(UserDao.class);
        u.addUser(testuser[0]);
        u.addUser(testuser[1]);
        when(u.getUsers()).thenReturn(Arrays.asList(testuser));

    }
    @Test
    public void test2(){
        UserService u=mock(UserService.class);
        u.addUser(new User(1l,"user","123456","User","panjasin@gmail.com"));
        when(u.findByUserName("User")).thenReturn(new User(1l, "user", "123456", "User", "panjasin@gmail.com"));
        when(u.findByUserName("")).thenReturn(null);
        when(u.findByUserName("pan")).thenReturn(new User(1l, "user", "123456", "User", "panjasin@gmail.com"));
    }
    @Test
    public void test3(){


        HistoryService history=mock(HistoryService.class);
        History[] initHistory={new History(1l,"en","The temple houses an important Buddha statue: the Phra Buddha Sihing which gives the temple its name. The origins of this statue are unknown but, according to legend, it was based on the lion of Shakya, a statue since lost which used to be housed in the Mahabodhi Temple of Bodh Gaya (India). \n" +
                "The Phra Buddha Sihing statue is supposed to have been brought, via Ceylon (present day Sri Lanka), to Ligor (present day Nakhon Si Thammarat and from there, via Ayutthaya, to Chiang Mai.\n" +
                "\n" +
                "There are two more Buddha statues in Thailand which are claimed to be the Phra Buddha Sihing: one is housed in Wat Phra Mahathat in the city of Nakhon Si Thammarat and another in the Bangkok National Museum.\n" +
                "\n" +
                "It is alleged that the head of the statue had been stolen in 1922. The possibility remains that the present statue (or maybe only the head) is a copy.\n" +
                "\n" +
                "Every year, during the Songkran festival, the statue is taken from wihan Lai Kham and carried through the streets of Chiang Mai in a religious procession during which the spectators honour the statue by sprinkling water over it."),new History(2l,"th","??????? ?????????????????????????????? ?????????? ???????????????? ?.?. 1888 ??????????????????????????? 23 ?? ??????????????????????????? ?????????? ???????? 2 ?? ??????????????????? ??????????? ????????????? ????? ??????????? ??????????????????? ?????????????? \"?????????????\" ????????????????????? ???????????????????? ?????????????????????????????????????????????? ????????????????????????? \n ?????????????? ???? ???????? ??????????????????????????????????????? ??????????? ??? 79 ????????? ???????????? 63 ????????? [2]????????????????? ?????????????????? ???????????? ??????????????????????????? ???????????? ????? ?.?. 700 ????? ???????????????????????????????????????????????????? ????????????????????????????? 1 ???????????????????????????????????????????? ??????????????????????????????????????????????????????")};


        history.add(initHistory[0]);
                when(history.getHistorys()).thenReturn(Arrays.asList(initHistory[0]));


when(history.updateHistory(initHistory[1])).thenReturn(initHistory[1]);
}
    @Test
    public void test4(){
        Activity[] initActivity =  {
                new Activity(1l,"?????????????","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/1.JPG")),
                new Activity(2l,"?????????????","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/2.JPG")),
                new Activity(3l,"?????????????","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/3.JPG")),
                new Activity(4l,"?????????????","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/1.JPG"))

        };
        ActivityService activityService=mock(ActivityService.class);
        activityService.addActivity(initActivity[0]);
        activityService.addActivity(initActivity[1]);

        when(activityService.getActivitys()).thenReturn(Arrays.asList(initActivity));
        when(activityService.updateActivity(new Activity(1l, "???", "????????????? ?????????????? ????????????????????????????", "th", ImageUtil.getImage("pic/1.JPG")))).thenReturn(new Activity(1l,"???","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/1.JPG")));
        when(activityService.addActivity(initActivity[2])).thenReturn(initActivity[2]);
        when(activityService.deleteActivity(1l)).thenReturn(new Activity(null,"?????????????","????????????? ?????????????? ????????????????????????????","th", ImageUtil.getImage("pic/1.JPG")));

        when(activityService.getbylang("th")).thenReturn(Arrays.asList(initActivity));

    }

    @Test
    public void test5(){
        QuestionAnswer[] question={new QuestionAnswer(1l,"Where are we"),new QuestionAnswer(2l,"What Time is it")};
QuestionAnswer q=new QuestionAnswer(1l,"Where are we","Earth");
        QuestionService questionService=mock(QuestionService.class);
        questionService.addQuestionAnswer(question[0]);
        questionService.addQuestionAnswer(question[1]);
        when(questionService.getQuestionAnswers()).thenReturn(Arrays.asList(question));
        when(questionService.deleteQuestionAnswer(1l)).thenReturn(new QuestionAnswer(null,"Where are we"));
    when(questionService.updateQuestionAnswer(q)).thenReturn(q);
        when(questionService.addQuestionAnswer(new QuestionAnswer(3l,"What on your mind"))).thenReturn(new QuestionAnswer(3l,"What on your mind"));
    }

    }
