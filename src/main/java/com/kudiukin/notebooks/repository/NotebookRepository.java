package com.kudiukin.notebooks.repository;

import com.kudiukin.notebooks.domain.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Integer> {
    List<Notebook> findByNameBrand(String nameBrand);

    List<Notebook> findByDisplayDiagonal(int displayDiagonal);

    List<Notebook> findByOs(String os);

    List<Notebook> findByMemorySize(int memorySize);
}
