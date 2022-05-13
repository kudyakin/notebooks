package com.kudiukin.notebooks.repository;

import com.kudiukin.notebooks.domain.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Integer> {
}
