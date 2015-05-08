package camt.se331.temple.repository;

import camt.se331.temple.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dto on 2/9/2015.
 */

public interface ActivityRepository extends JpaRepository<Activity,Long>{
    public List<Activity> findByNameLike(String name);
    public List<Activity> findByNameContaining(String name);
    public List<Activity> findByNameContainingIgnoreCase(String name);
    public List<Activity> findByNameOrDescriptionContainingIgnoreCase(String name,String description);
}
