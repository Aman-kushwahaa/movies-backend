package dev.aman.movies.models.service;

import dev.aman.movies.models.Movie;
import dev.aman.movies.repo.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService  {

    @Autowired
    private MovieRepository movieRepository;

//    private MovieService(MovieRepository movieRepository){
//        movieRepository=this.movieRepository;
//    }

    public List<Movie> allMovie(){
        return  movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> singleMovieByImdbId(String id){
        return movieRepository.findByImdbId(id);
    }



}
