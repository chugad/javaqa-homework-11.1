package ru.netology.manager;

import ru.netology.domain.MoviesList;

public class AfishaManager {
    int movieNumber = 10;

    private AfishaRepository repository;

    public  AfishaManager (AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager (int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public void add(MoviesList index) {
        repository.save(index);
    }

    public MoviesList[] getAll() {
        MoviesList[] movies = repository.findAll();
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