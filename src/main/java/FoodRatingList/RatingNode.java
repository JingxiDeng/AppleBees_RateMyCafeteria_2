package FoodRatingList;

/**
 * Contains a single review from a user.
 * Each RatingNode contains:
 * - The username of the user who gave this review
 * - The rating out of 5 that the user gave to the food item
 * - A String containing the written review that the user gave to the food item
 * - A boolean that records whether the user would like to see the food item more often in the cafeteria
 * **/
public class RatingNode {
    private String username; // the id of the user who rated this dish
    private int rating; // a rating of the dish out of 5
    private String review; // the review of the user
    private boolean wouldLikeToSeeMoreOften;
    private RatingNode next;
    public RatingNode (String name, int rating){
        username = name;
        this.rating = rating;
    }

    public RatingNode (String name, int rating, String review, boolean wouldLikeToSeeMoreOften){
        username = name;
        this.rating = rating;
        this.review = review;
        this.wouldLikeToSeeMoreOften = wouldLikeToSeeMoreOften;
    }

    int getRating(){return rating;}

    public RatingNode next() {
        return next;
    }

    /** Point next to the given node
     **
     * @param anotherNode given MovieRatingNode
     */
    public void setNext(RatingNode anotherNode) {
        this.next = anotherNode;
    }

    public String toString() {
        return username + " has a left a " + rating + " star review: "  + review;
    }
}
