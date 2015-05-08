package camt.se331.temple.repository;

import camt.se331.temple.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 4/6/2015.
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
