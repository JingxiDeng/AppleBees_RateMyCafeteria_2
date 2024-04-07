package FoodRatingList;
class Main {
    public static void main(String[] args) {
        FoodRatingList usfCafeRatingList = new FoodRatingList();

        // creating fictional menu items for USF's cafe menu
        usfCafeRatingList.addFoodItem("cheeseburger");
        usfCafeRatingList.addFoodItem("pasta");
        usfCafeRatingList.addFoodItem("pineapple pizza");

        // entering some example ratings from fictional student users
        usfCafeRatingList.addRating(); // enter samuel, cheeseburger, 5, yes, it's good
        usfCafeRatingList.addRating("samuel", "pineapple pizza", 4, "It's wholesome", true);
        usfCafeRatingList.addRating("mike", "cheeseburger", 3, "The fries were soggy", false);
        usfCafeRatingList.addRating("mike", "pineapple pizza", 4, "I love pineapple on pizza!", true);
        usfCafeRatingList.addRating("kelly", "cheeseburger", 5, "Not too shabby!", true);
        usfCafeRatingList.addRating("kelly", "pasta", 4, "Can get a little sour at times though", true);

        // finding the highest rated food item
        System.out.println();
        System.out.println(usfCafeRatingList.findMostPopularItem());

        // find the average rating of a particular item
        System.out.println();
        System.out.println(usfCafeRatingList.printRatingOf("pineapple pizza"));

        // find the rating of a particular food item
        System.out.println("\nPrinting out the reviews for menu item cheeseburger:");
        usfCafeRatingList.printReviewsFor("cheeseburger");

        // print out reviews and average ratings for all food items in the cafeteria
        System.out.println();
        System.out.println("PRINTING OUT ALL RATINGS AND REVIEWS FOR ALL ITEMS IN THE CAFETERIA:");
        usfCafeRatingList.printAllReviewsAndRatings();
    }
}
