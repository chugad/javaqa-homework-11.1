package ru.netology.manager;

import ru.netology.domain.MoviesList;

public class AfishaRepository {
    int movieNumber = 10;

    private MoviesList[] movies = new MoviesList[0]; //массив с фильмами которые мы будем добавлять, сначала длина 0

    public AfishaRepository() {
        this.movieNumber = movieNumber;
    }

    public void save(MoviesList index) { //добавляем новые фильмы
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        MoviesList[] tmp = new MoviesList[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = index;
        movies = tmp;
    }

    public MoviesList[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MoviesList[] tmp = new MoviesList[length];
        int i = 0;
        for (MoviesList index : movies) {
            if (index.getMovieId() != id) {
                tmp[i] = index;
                i++;
            }
        }
        // меняем наши элементы
        movies = tmp;
    }

    public MoviesList[] removeAll() {
        int length = 0;
        MoviesList[] tmp = new MoviesList[length];
        movies = tmp;
        return movies;
    }


    public MoviesList findById(int id) {
        for (MoviesList movie : movies) {
            if (movie.getMovieId() == id) {
                return movie;
            }
        }
        return null;
    }

}