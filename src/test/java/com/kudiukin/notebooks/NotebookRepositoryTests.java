package com.kudiukin.notebooks;

import com.kudiukin.notebooks.domain.Notebook;
import com.kudiukin.notebooks.repository.NotebookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NotebookRepositoryTests {

    @Autowired
    private NotebookRepository notebookRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveNotebookTest() {

        Notebook notebook = Notebook.builder().nameBrand("Lenovo").model("t100").displayDiagonal(15).os("Win10").build();

        notebookRepository.save(notebook);

        Assertions.assertThat(notebook.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getNotebookTest() {

        Notebook notebook = notebookRepository.findById(1).orElseThrow();

        Assertions.assertThat(notebook.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getListOfNotebookTest() {

        List<Notebook> notebooksList = notebookRepository.findAll();

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateNotebookTest() {

        Notebook notebook = notebookRepository.findById(1).get();

        notebook.setNameBrand("Acer");
        Notebook notebookUpdated = notebookRepository.save(notebook);

        Assertions.assertThat(notebookUpdated.getNameBrand()).isEqualTo("Acer");

    }

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteNotebookTest() {
//
//        Notebook notebook = notebookRepository.findById(1).get();
//
//        notebookRepository.delete(notebook);
//
//        Notebook notebook1 = null;
//
//        Optional<Notebook> optionalAuthor = Optional.ofNullable(notebookRepository.findByNameBrand("Acer"));
//
//        if (optionalAuthor.isPresent()) {
//            notebook1 = optionalAuthor.get();
//        }
//
//        Assertions.assertThat(notebook1).isNull();
//    }
}
