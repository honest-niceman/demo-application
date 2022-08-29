package jpa.buddy.demoapplication.repositories;

import jpa.buddy.demoapplication.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i " +
            "where i.order.id = :id " +
            "order by i.name")
    List<Item> findByOrder(@Param("id") Long id);
}