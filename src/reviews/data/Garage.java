package reviews.data;

public class Garage extends Business {

    private float priceHour;

    public Garage() {

    }

    public Garage(String name) {
        super(name);
    }

    public Garage(String name, String city, Review[] reviews, float priceHour) {
        super(name, city, reviews);
        this.priceHour = priceHour;
    }

    public float getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(float priceHour) {
        this.priceHour = priceHour;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + priceHour + "eur/h" + "\n\tReview average: " + reviewAverage();
    }
}
