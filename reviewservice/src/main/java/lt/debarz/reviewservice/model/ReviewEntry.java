package lt.debarz.reviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * A review entry. An entry is a user's review of a product and is contained in a Review document.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewEntry {

    /**
     * The username of the reviewer.
     */
    private String username;

    /**
     * The date that the review was written.
     */
    private Date date;

    /**
     * The textual review content.
     */
    private String review;

    public ReviewEntry(String username, String review) {
        this.username = username;
        this.review = review;
    }
}
