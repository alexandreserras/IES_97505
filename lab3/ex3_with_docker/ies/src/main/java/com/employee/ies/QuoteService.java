package com.employee.ies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository repository;

    public Quote saveQuote(Quote movie) {
        return repository.save(movie);
    }

    public List<Quote> saveQuotes(List<Quote> movies) {
        return repository.saveAll(movies);
    }

    public List<Quote> getQuotes() {
        return repository.findAll();
    }

    public Quote getQuoteById(int id) {
        return repository.findById((int)id).orElse(null);
    }

    public Quote getQuoteByName(String title) {
        return repository.findByAvaliacao(title);
    }

    public String deleteQuote(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Quote updateQuote(Quote movie) {
        Quote existingMovie = repository.findById((int)movie.getId()).orElse(null);
        existingMovie.setAvaliacao(movie.getAvaliacao());
        return repository.save(existingMovie);
    }

    @Autowired
    private MovieRepository repository2;

    public Movie saveMovie(Movie movie) {
        return repository2.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return repository2.saveAll(movies);
    }
    /*
    public List<Quote> getQuotes() {
        return repository.find
    }
    */

    public List<Movie> getMovies() {
        return repository2.findAll();
    }

    public Movie getMovieById(long id) {
        return repository2.findById((int)id).orElse(null);
    }

    public Movie getMovieByName(String title) {
        return repository2.findByTitle(title);
    }

    public String deleteMovie(int id) {
        repository2.deleteById(id);
        return "product removed !! " + id;
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = repository2.findById((int)movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setYear(movie.getYear());
        return repository2.save(existingMovie);
    }
}
