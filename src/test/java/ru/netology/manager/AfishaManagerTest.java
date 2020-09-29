package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MoviesList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private MoviesList add1 = new MoviesList(1, "Film1", "horror");
    private MoviesList add2 = new MoviesList(2, "Film2", "horror");
    private MoviesList add3 = new MoviesList(3, "Film3", "horror");
    private MoviesList add4 = new MoviesList(4, "Film4", "horror");
    private MoviesList add5 = new MoviesList(5, "Film5", "horror");
    private MoviesList add6 = new MoviesList(6, "Film6", "horror");
    private MoviesList add7 = new MoviesList(7, "Film7", "horror");
    private MoviesList add8 = new MoviesList(8, "Film8", "horror");
    private MoviesList add9 = new MoviesList(9, "Film9", "horror");
    private MoviesList add10 = new MoviesList(10, "Film10", "horror");
    private MoviesList add11 = new MoviesList(11, "Film11", "horror");
    private MoviesList add12 = new MoviesList(12, "Film12", "horror");

    // movieNumber default
    @Test
    public void shouldAddMovieAfterLimit() {
        manager.add(add1);
        manager.add(add2);
        manager.add(add3);
        manager.add(add4);
        manager.add(add5);
        manager.add(add6);
        manager.add(add7);
        manager.add(add8);
        manager.add(add9);
        manager.add(add10);
        manager.add(add11);
        manager.add(add12);
        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{add12, add11, add10, add9, add8, add7, add6, add5, add4, add3};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitUp() {

        manager.add(add1);
        manager.add(add2);
        manager.add(add3);
        manager.add(add4);
        manager.add(add5);
        manager.add(add6);
        manager.add(add7);
        manager.add(add8);
        manager.add(add9);

        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{add1, add2, add3, add4, add5, add6, add7, add8, add9};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{add9, add8, add7, add6, add5, add4, add3, add2, add1};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitDown() {

        manager.add(add1);

        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{add1};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{add1};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieZero() {

        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    //movieNumber = 5

    @Test
    public void shouldAddMovieUnderLimitUpNum5() {
        manager.movieNumber = 5;

        manager.add(add1);
        manager.add(add2);
        manager.add(add3);
        manager.add(add4);
        manager.add(add5);
        manager.add(add6);
        manager.add(add7);
        manager.add(add8);
        manager.add(add9);

        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{add1, add2, add3, add4, add5, add6, add7, add8, add9};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{add9, add8, add7, add6, add5};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitDownNum5() {
        manager.movieNumber = 5;
        manager.add(add1);

        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{add1};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{add1};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieZeroNum5() {
        manager.movieNumber = 5;
        // настройка заглушки
        MoviesList[] returned = new MoviesList[]{};
        doReturn(returned).when(repository).findAll();

        MoviesList[] expected = new MoviesList[]{};
        MoviesList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}



