//Esta clase sirve para que hereden los distintos tipos de negocios
package reviews.data;

public abstract class Business implements Comparable<Business> {

    private String name;
    private String city;
    private Review[] reviews;

    public Business() {

    }

    public Business(String name) {
        this.name = name;
    }

    public Business(String name, String city, Review[] reviews) {
        this.name = name;
        this.city = city;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return name + " (" + city + ")";
    }

    public int reviewAverage() {
        int sum = 0;

        for (int i = 0; i < reviews.length; i++) {
            sum += reviews[i].getRating();
        }

        return (sum == 0)?sum:sum/reviews.length;
    }

    @Override
    public int compareTo(Business b) {
        return this.name.compareTo(b.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }




}
