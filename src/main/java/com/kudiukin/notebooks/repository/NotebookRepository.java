package com.kudiukin.notebooks.repository;

import com.kudiukin.notebooks.domain.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Integer> {

    List<Notebook> findByNameBrand(String nameBrand);

    List<Notebook> findByDisplayDiagonal(int displayDiagonal);

    List<Notebook> findByOs(String os);

    @Query("select n from Notebook n where n.os = 'MacOS' and n.isDeleted=false")
    List<Notebook>findByMacOs();

    @Query("select n from Notebook n where (n.os = 'Win10' and n.isDeleted=false) or (n.os = 'Win7' and n.isDeleted=false)")
    List<Notebook>findByWinOs();

    List<Notebook> findByMemorySize(int memorySize);

    @Query("select n from Notebook n where n.isDeleted=false")
    List<Notebook>findAllByDeletedIsFalse();
}
