package wat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wat.entity.QuestionAnswer;
import wat.repository.ActivityRepository;
import wat.repository.QuestionRepository;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Repository
public class QuestionDAOImpl implements QuestionDAO {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public List<QuestionAnswer> getQuestionList() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionAnswer getQuestion(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public QuestionAnswer addQuestion(QuestionAnswer q) {
        return questionRepository.save(q);
    }

    @Override
    public QuestionAnswer editQuestion(QuestionAnswer q) {

        return questionRepository.save(q);
    }

    @Override
    public QuestionAnswer deleteQuestion(QuestionAnswer q) {
        questionRepository.delete(q);
        q.setId(null);
        return q;
    }
}
