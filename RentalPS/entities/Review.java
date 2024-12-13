package RentalPS.entities;

public class Review {
    private int rentalId;
    private String username;
    private String reviewText;

    public Review(int rentalId, String username, String reviewText) {
        this.rentalId = rentalId;
        this.username = username;
        this.reviewText = reviewText;
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getUsername() {
        return username;
    }

    public String getReviewText() {
        return reviewText;
    }

    @Override
    public String toString() {
        return + rentalId + ": " + reviewText;
    }
}