package com.kudiukin.notebooks.repository;

import com.kudiukin.notebooks.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    @Query("SELECT b from Buyer b inner join Notebook no on b.id = no.mainBuyer.id where no.id = :id")
    Buyer getBuyerByNotebook_Id (Integer id);

}
