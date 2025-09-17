import java.util.*;

class FoodRatings {

    private static class Food {
        String name;
        int rating;
        Food(String n, int r) { name = n; rating = r; }
    }

    // comparators: higher rating first, if tie → lexicographically smaller name first
    private static final Comparator<Food> cmp = (a, b) -> {
        if (a.rating != b.rating) return b.rating - a.rating;
        return a.name.compareTo(b.name);
    };

    Map<String, String> foodToCuisine;
    Map<String, Integer> foodToRating;
    Map<String, TreeSet<Food>> cuisineToSet;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToSet = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);

            cuisineToSet
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>(cmp))
                .add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // remove old
        cuisineToSet.get(cuisine).remove(new Food(food, oldRating));

        // add new
        cuisineToSet.get(cuisine).add(new Food(food, newRating));

        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineToSet.get(cuisine).first().name;
    }
}
