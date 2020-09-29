package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviesList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryTest {
    ru.netology.manager.AfishaRepository repository = new ru.netology.manager.AfishaRepository();


    @Test
    public void shouldRemove() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");

        repository.save(add1);
        repository.save(add2);
        repository.save(add3);
        repository.save(add4);
        repository.save(add5);
        repository.save(add6);
        repository.save(add7);

        int idToRemove = 6;
        repository.removeById(idToRemove);

        MoviesList[] actual = repository.findAll();
        MoviesList[] expected = new MoviesList[]{add1, add2, add3, add4, add5, add7};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");

        repository.save(add1);
        repository.save(add2);
        repository.save(add3);
        repository.save(add4);
        repository.save(add5);
        repository.save(add6);
        repository.save(add7);

        repository.removeAll();

        MoviesList[] actual = repository.findAll();
        MoviesList[] expected = new MoviesList[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindId() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");

        repository.save(add1);
        repository.save(add2);
        repository.save(add3);
        repository.save(add4);
        repository.save(add5);
        repository.save(add6);
        repository.save(add7);

        int idToFind = 6;

        MoviesList[] actual = new MoviesList[]{repository.findById(idToFind)};
        MoviesList[] expected = new MoviesList[]{add6};

        assertArrayEquals(expected, actual);

    }

//    @Test
//    public void shouldFindIdNull() {
//        MoviesList add1 = new MoviesList(1, "Film1", "horror");
//        MoviesList add2 = new MoviesList(2, "Film2", "horror");
//        MoviesList add3 = new MoviesList(3, "Film3", "horror");
//        MoviesList add4 = new MoviesList(4, "Film4", "horror");
//        MoviesList add5 = new MoviesList(5, "Film5", "horror");
//        MoviesList add6 = new MoviesList(6, "Film6", "horror");
//        MoviesList add7 = new MoviesList(7, "Film7", "horror");
//
//        repository.save(add1);
//        repository.save(add2);
//        repository.save(add3);
//        repository.save(add4);
//        repository.save(add5);
//        repository.save(add6);
//        repository.save(add7);
//
//        int idToFind = 15;
//
//        MoviesList[] actual = new MoviesList[]{repository.findById(idToFind)};
//        MoviesList[] expected = new MoviesList[]{};
//
//        assertArrayEquals(expected, actual);
//
//    }
}
