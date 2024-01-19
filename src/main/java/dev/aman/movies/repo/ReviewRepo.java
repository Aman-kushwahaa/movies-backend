package dev.aman.movies.repo;

import dev.aman.movies.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<Review, ObjectId> {
}
