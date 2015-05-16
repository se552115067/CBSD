package wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.entity.History;


/**
 * Created by Punjasin on 5/13/2015.
 */
public interface HistoryRepository extends JpaRepository<History,Long> {

}
