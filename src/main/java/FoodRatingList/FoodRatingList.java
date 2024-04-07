package FoodRatingList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FoodRatingList {
    private HashMap <String, RatingList> foodRatingList;

    public FoodRatingList(){
        foodRatingList = new HashMap<String, RatingList>();
    }
    /**
     * A user will leave a review using keyboard inputs
     * **/
    void addRating(){
        try {
            Scanner sc = new Scanner(System.in);
            // The user enters his/her username
            System.out.println("Please enter your username:");
            String username = sc.next();
            sc.nextLine();

            // The user enters which item the user would like to review
            System.out.println("Which food item are you reviewing?");
            String foodItemName = sc.nextLine();
            // check if the food item exists
            if(foodRatingList.get(foodItemName) == null) {
                System.out.println("ERROR: food item does not exist");
                return;
            }

            // the user gives the dish a rating out of five
            System.out.println("What would you rate this item out of 5?\nPlease enter a whole number between 1 and 5:");
            int rating = sc.nextInt();

            // check if the user would like to see the food item more in the future
            System.out.println("Would you like to see this menu item more often in the future?\nPlease type either yes or no");
            String wouldLikeToSeeAgain = sc.next();
            boolean wouldLikeToSeeMoreOften;
            while(!wouldLikeToSeeAgain.equals("yes") && !wouldLikeToSeeAgain.equals("no")){
                System.out.println("Oops, looks like you entered an invalid response.\nPlease only type either yes or no");
                wouldLikeToSeeAgain = sc.next();
            }
            if(wouldLikeToSeeAgain.equals("yes"))
                wouldLikeToSeeMoreOften = true;
            else
                wouldLikeToSeeMoreOften = false;
            sc.nextLine();


            // user leaves the written review
            System.out.println("Please leave your review here:");
            String review = sc.nextLine();

            // create the review
            foodRatingList.get(foodItemName).addRating(username, rating, review, wouldLikeToSeeMoreOften);
            System.out.println("\nThank you for your input!\nYour review has been created successfully.");
            //System.out.println(foodRatingList.get(foodItemName).head().toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }

    void addRating(String username, String foodItemName, int rating, String review, boolean wouldLikeToSeeMoreOf){
        if(foodRatingList.get(foodItemName) == null){
            System.out.println("ERROR: food item does not exist");
            return;
        }

        foodRatingList.get(foodItemName).addRating(username, rating, review, wouldLikeToSeeMoreOf);
    }

    void addFoodItem(String itemName){
        if(foodRatingList.get(itemName) == null){
            foodRatingList.put(itemName, new RatingList());
        }
    }
    /**
     * prints out the average rating and all reviews associated
     * with every single food item available in the cafeteria
     * **/
    void printAllReviewsAndRatings(){
        for(Map.Entry<String, RatingList> set : foodRatingList.entrySet()){
            // print average rating
            System.out.println(set.getKey() + " has an average rating of " + set.getValue().getAverageRating() + " stars");
            // print reviews
            set.getValue().printUserRatings();
            System.out.println();
        }
    }
    /**
     * finds the most popular food item out of all food items and prints out that item's rating
     * **/
    String findMostPopularItem(){
        double highestAverageRating = 0;
        String mostPopularItemName = "";
        for(Map.Entry<String, RatingList> set : foodRatingList.entrySet()){
            double averageRatingOfCurrentItem = set.getValue().getAverageRating();
            if(averageRatingOfCurrentItem > highestAverageRating){
                highestAverageRating = averageRatingOfCurrentItem;
                mostPopularItemName = set.getKey();
            }
        }
        return "The most popular item in USF's cafe is: " + mostPopularItemName + " with an average rating of " + highestAverageRating;
    }
    /**
     * finds the rating of the food item with the name foodItemName
     * @param foodItemName is the name of the item that the method will print the rating of
     * @returns the average rating of that food item
     * **/
    String printRatingOf(String foodItemName){
        if(foodRatingList.get(foodItemName) == null){
            System.out.println("ERROR: food item " + foodItemName + " does not exist.");
            return "";
        }

        return foodItemName + " has an average rating of " + foodRatingList.get(foodItemName).getAverageRating() + " stars";
    }

    void printReviewsFor(String foodItemName){
        foodRatingList.get(foodItemName).printUserRatings();
    }
    public static void main(String [] args){
        FoodRatingList list = new FoodRatingList();

        list.addFoodItem("bacon cheeseburger");
        list.addFoodItem("spaghetti meatballs");
        list.addFoodItem("pineapple pizza");

        list.addRating();


    }
}
