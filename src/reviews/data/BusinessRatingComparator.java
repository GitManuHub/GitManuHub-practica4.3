//La clase para ordenar
package reviews.data;

import java.util.Comparator;

public class BusinessRatingComparator implements Comparator<Business> {
    @Override
    public int compare(Business b1, Business b2) {
        return Integer.compare(b2.reviewAverage(), b1.reviewAverage());
    }
}
