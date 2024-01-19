package dev.aman.movies.models.controller;

import dev.aman.movies.models.Movie;
import dev.aman.movies.models.service.MovieService;
import dev.aman.movies.repo.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovie(){
        return new ResponseEntity<List<Movie>>(movieService.allMovie(), HttpStatus.OK);


    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable  ObjectId id){
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id),HttpStatus.OK);
//
//
//    }

         @GetMapping("/{imdbId}")
        public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId){
            return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
        }
    }


