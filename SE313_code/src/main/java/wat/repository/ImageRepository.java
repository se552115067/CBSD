package wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import wat.entity.Image;

import javax.transaction.Transactional;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface ImageRepository extends JpaRepository<Image,Long> {



}
