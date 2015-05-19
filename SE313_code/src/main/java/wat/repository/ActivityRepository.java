package wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.entity.Activity;

import java.util.List;


/**
 * Created by Punjasin on 5/13/2015.
 */
public interface ActivityRepository extends JpaRepository<Activity,Long> {
List<Activity> findByLang(String lang);
}
