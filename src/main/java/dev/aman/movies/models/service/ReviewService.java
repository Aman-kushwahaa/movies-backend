package dev.aman.movies.models.service;


import dev.aman.movies.models.Movie;
import dev.aman.movies.models.Review;
import dev.aman.movies.repo.ReviewRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String imdbId, String body){

        Review review = reviewRepo.insert(new Review(body)); ;
//        Optional<Movie> getMovie= movieService.singleMovieByImdbId(imdbId);



        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();//finds the first matching document and returns it

        return review;


    }
}
