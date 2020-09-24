package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviesList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    ru.netology.manager.MovieManager manager = new ru.netology.manager.MovieManager();

    // movieNumber default
    @Test
    public void shouldAddMovieAfterLimit() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");
        MoviesList add8 = new MoviesList(8, "Film8", "horror");
        MoviesList add9 = new MoviesList(9, "Film9", "horror");
        MoviesList add10 = new MoviesList(10, "Film10", "horror");
        MoviesList add11 = new MoviesList(11, "Film11", "horror");
        MoviesList add12 = new MoviesList(12, "Film12", "horror");
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

        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{add12, add11, add10, add9, add8, add7, add6, add5, add4, add3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitUp() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");
        MoviesList add8 = new MoviesList(8, "Film8", "horror");
        MoviesList add9 = new MoviesList(9, "Film9", "horror");

        manager.add(add1);
        manager.add(add2);
        manager.add(add3);
        manager.add(add4);
        manager.add(add5);
        manager.add(add6);
        manager.add(add7);
        manager.add(add8);
        manager.add(add9);

        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{add9, add8, add7, add6, add5, add4, add3, add2, add1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitDown() {
        MoviesList add1 = new MoviesList(1, "Film1", "horror");


        manager.add(add1);


        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{add1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieZero() {

        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{};

        assertArrayEquals(expected, actual);
    }

    //movieNumber = 5

    @Test
    public void shouldAddMovieUnderLimitUpNum5() {
        manager.movieNumber = 5;
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        MoviesList add2 = new MoviesList(2, "Film2", "horror");
        MoviesList add3 = new MoviesList(3, "Film3", "horror");
        MoviesList add4 = new MoviesList(4, "Film4", "horror");
        MoviesList add5 = new MoviesList(5, "Film5", "horror");
        MoviesList add6 = new MoviesList(6, "Film6", "horror");
        MoviesList add7 = new MoviesList(7, "Film7", "horror");
        MoviesList add8 = new MoviesList(8, "Film8", "horror");
        MoviesList add9 = new MoviesList(9, "Film9", "horror");

        manager.add(add1);
        manager.add(add2);
        manager.add(add3);
        manager.add(add4);
        manager.add(add5);
        manager.add(add6);
        manager.add(add7);
        manager.add(add8);
        manager.add(add9);

        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{add9, add8, add7, add6, add5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieUnderLimitDownNum5() {
        manager.movieNumber = 5;
        MoviesList add1 = new MoviesList(1, "Film1", "horror");
        manager.add(add1);

        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{add1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieZeroNum5() {
        manager.movieNumber = 5;
        MoviesList[] actual = manager.getLastTenMovies();
        MoviesList[] expected = new MoviesList[]{};

        assertArrayEquals(expected, actual);
    }
}
