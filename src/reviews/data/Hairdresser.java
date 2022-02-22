//Uno de los subtipos de negocio
package reviews.data;

public class Hairdresser extends Business {

    private boolean unisex;

    public Hairdresser(String name, String city, Review[] reviews, boolean unisex) {
        super(name, city, reviews);
        this.unisex = unisex;
    }

    public Hairdresser(String name) {
        super(name);
    }

    public Hairdresser() {

    }

    public boolean isUnisex() {
        return unisex;
    }

    public void setUnisex(boolean unisex) {
        this.unisex = unisex;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + ((unisex)?"unisex":"not unisex") + "\n\tReview average: " + reviewAverage();
    }
}
