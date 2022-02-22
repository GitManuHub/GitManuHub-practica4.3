//Uno de los subtipos de negocio
package reviews.data;

public class Restaurant extends Business {

    private String foodType;

    public Restaurant() {

    }
    public Restaurant(String name) {
        super(name);
    }

    public Restaurant(String name, String city, Review[] reviews, String foodType) {
        super(name, city, reviews);
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + foodType + "\n\tReview average: " + reviewAverage();
    }
}
