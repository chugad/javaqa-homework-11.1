package ru.netology.manager;

import ru.netology.domain.MoviesList;

public class MovieManager {
    int movieNumber = 10;

    private MoviesList[] movies = new MoviesList[0]; //массив с фильмами которые мы будем добавлять, сначала длина 0

    public MovieManager() {
        this.movieNumber = movieNumber;
    }

    public void add(MoviesList index) { //добавляем новые фильмы
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

    public MoviesList[] getLastTenMovies() {
        int length = movies.length;
        if (length < this.movieNumber) {
            MoviesList[] result = new MoviesList[movies.length];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
            return result;
        } else {
            MoviesList[] result = new MoviesList[this.movieNumber];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
            return result;
        }
    }
}