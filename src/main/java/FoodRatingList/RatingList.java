package FoodRatingList;

/**
 * Contains a list of all the reviews and ratings that is given to a particular food item.
 * Each element in the list is a RatingNode, which represents a single review from a user
 * **/
public class RatingList {
    private RatingNode head;
    private RatingNode end;

    void addRating(String username, int rating, String review, boolean wouldLikeToSeeMoreOf){
        // if the head is null, initialize the linkedlist
        if(head == null) {
            head = new RatingNode(username, rating, review, wouldLikeToSeeMoreOf);
            end = head;
            return;
        }
        // set the next node at the end of the linkedList
        end.setNext(new RatingNode(username, rating, review, wouldLikeToSeeMoreOf));
        end = end.next();
    }

    RatingNode head(){
        if(head!=null)
            return head;
        System.out.println("ERROR: Null linkedlist head, cannot return");
        return null;
    }

    double getAverageRating(){
        // check if there are any ratings in the list at all
        if(head == null)
            return -1;

        double numOfElements = 0;
        double sumOfAllRatings = 0;

        // add up all ratings in the ratinglist, and divide it by the number of ratings
        // to get the average rating
        RatingNode curr = head();
        while(curr!=null){
            numOfElements++;
            sumOfAllRatings += curr.getRating();
            curr = curr.next();
        }

        return sumOfAllRatings/numOfElements;
    }

    void printUserRatings(){
        if(head == null){
            System.out.println();
            return;
        }

        RatingNode curr = head;
        while(curr!=null){
            System.out.println(curr.toString());
            curr = curr.next();
        }
    }

}
