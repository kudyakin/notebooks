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

        Notebook notebook = Notebook.builder().nameBrand("Lenovo").model("t100").memorySize(8).displayDiagonal(15).os("Win10").isDeleted(Boolean.FALSE).build();

        notebookRepository.save(notebook);

        Notebook notebook2 = Notebook.builder().nameBrand("MacBookPro").memorySize(8).displayDiagonal(13).os("MacOS").isDeleted(Boolean.FALSE).build();

        notebookRepository.save(notebook2);

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
    public void findByNameBrandTest() {

        List<Notebook> notebooksList = notebookRepository.findByNameBrand("Lenovo");

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(5)
    public void findByWinOsTest() {

        List<Notebook> notebooksList = notebookRepository.findByWinOs();

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(6)
    public void findByDisplayDiagonalTest() {

        List<Notebook> notebooksList = notebookRepository.findByDisplayDiagonal(15);

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(7)
    public void findByMemorySizeTest() {

        List<Notebook> notebooksList = notebookRepository.findByMemorySize(8);

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(8)
    public void findByMacOsTest() {

        List<Notebook> notebooksList = notebookRepository.findByMacOs();

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(9)
    public void findByOsTest() {

        List<Notebook> notebooksList = notebookRepository.findByOs("MacOS");

        Assertions.assertThat(notebooksList.size()).isGreaterThan(0);

    }

    @Test
    @Order(10)
    @Rollback(value = false)
    public void updateNotebookTest() {

        Notebook notebook = notebookRepository.findById(1).get();

        notebook.setNameBrand("Acer");
        Notebook notebookUpdated = notebookRepository.save(notebook);

        Assertions.assertThat(notebookUpdated.getNameBrand()).isEqualTo("Acer");

    }

    @Test
    @Order(11)
    @Rollback(value = false)
    public void deleteNotebookTest() {

        Notebook notebook = notebookRepository.findById(1).get();

        notebookRepository.delete(notebook);

        List<Notebook> notebook3 = null;

        Optional<List<Notebook>> optionalAuthor = Optional.ofNullable(notebookRepository.findByNameBrand("Acer"));

        if (optionalAuthor.isPresent()) {
            notebook3 = optionalAuthor.get();
        }

        Assertions.assertThat(notebook3).isEmpty();
    }
}
