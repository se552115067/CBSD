package wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.entity.QuestionAnswer;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface QuestionRepository extends JpaRepository<QuestionAnswer,Long> {

}
