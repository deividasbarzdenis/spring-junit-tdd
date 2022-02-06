package lt.debarz.reviewservice.service;

import lt.debarz.reviewservice.model.Review;
import lt.debarz.reviewservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class ReviewService {

    private ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns the review with the specified ID.
     * @param id        The ID of the review to return.
     * @return          The review with the specified ID.
     */
    public Optional<Review> findById(String id){
        return repository.findById(id);
    }

    /**
     * Returns the review with the specified product ID.
     * @param productId The product ID for which to return the review.
     * @return          The review for the specified product ID.
     */
    public Optional<Review> findByProductId(Integer productId){
        return repository.findByProductId(productId);
    }

    /**
     * Returns all reviews in the database.
     * @return          All reviews in the database.
     */
    public List<Review> findAll(){
        return repository.findAll();
    }

    /**
     * Saves the specified review to the database.
     * @param review    The review to save.
     * @return          The saved review, including a newly generated ID.
     */
    public Review save(Review review){
        review.setVersion(1);
        return repository.save(review);
    }

    /**
     * Updates the specified review in the database.
     * @param review    The review to update.
     * @return          The updated review.
     */
    public Review update(Review review){
        review.setVersion(review.getVersion()+1);
        return repository.save(review);
    }

    /**
     * Deletes the review with the specified ID.
     * @param id        The ID of the review to delete.
     */
    public void delete(String id){
        repository.deleteById(id);
    }
}
