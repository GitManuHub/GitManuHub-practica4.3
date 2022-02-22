//La clase management que tiene la mayoría de métodos

package reviews.main;
import reviews.data.*;
import java.util.Arrays;

public class Management {

    private User[] users;
    private Business[] businesses;

    public Management() {
        this.users = new User[10];
        this.businesses = new Business[6];
    }

    public void initialize() {
        this.users[0] = new User("LuisN", "1234");
        this.users[1] = new User("SusanaA", "4321");
        this.users[2] = new User("PiedadV", "9783");
        this.users[3] = new User("ManuelV", "5432");
        this.users[4] = new User("JavierA", "1565");
        this.users[5] = new User("EvaP", "5383");
        this.users[6] = new User("RodrigoG", "8489");
        this.users[7] = new User("JohannA", "5343");
        this.users[8] = new User("PepeS", "4864");
        this.users[9] = new User("SaraZ", "1563");


        Review[] rvs = {new Review(this.users[0], "Moyyy rico", 5), new Review(this.users[1], "Bastante rico", 4)};

        this.businesses[0] = new Restaurant("Pizzería Giovanni", "Londres", rvs, "Italian");

        Review[] rvs1 = {new Review(this.users[2], "Nos atendieron mal y la comida sosa", 1), new Review(this.users[3], "Si el dueño no fuese mi primo le daba un 2", 4)};

        this.businesses[1] = new Restaurant("Como en casa", "Algeciras", rvs1, "Tapas");

        Review[] rvs2 = {new Review(this.users[4], "Le pedí que me cortase sólo las puntas y ahora estoy calva", 1), new Review(this.users[5], "El único peluquero de la ciudad que entiende mi pelo afro", 5)};

        this.businesses[2] = new Hairdresser("La pelu de Pepelu", "Alicante", rvs2, false);

        Review[] rvs3 = {new Review(this.users[6], "Le pedí mechas rojas y me las puso azules pero me quedan bien la verdad", 4), new Review(this.users[7], "Soy calvo pero las revistas que tienen para leer están muy bien", 4)};

        this.businesses[3] = new Hairdresser("Pelados", "Madrid", rvs3, true);

        Review[] rvs4 = {new Review(this.users[8], "Me cobró una pasta y el coche se me paró a los 10 minutos de salir del taller", 2), new Review(this.users[9], "Mi sobrino tiene el mejor taller del mundo", 5)};

        this.businesses[4] = new Garage("Sobre ruedas", "Palencia", rvs4, 42.6f);

        Review[] rvs5 = {new Review(this.users[3], "Juan es un makinote" , 5), new Review(this.users[7], "Me han dicho que si ponía 5 estrellas me hacían descuento pero no sé usar el móvil muy bien", 3)};

        this.businesses[5] = new Garage("Juan es el mejor", "Badajoz", rvs5, 60.33f);
    }

    public User login(String login, String password) {
        User target = null;

        for (int i = 0; i < this.users.length; i++) {
            if (login.equals(users[i].getLogin()) && password.equals(users[i].getPassword()))
                target = users[i];
        }

        return target;
    }

    public void showReviews(String login) {
        for (int i = 0; i < this.businesses.length; i++) {
            for (int j = 0; j < businesses[i].getReviews().length; j++) {
                if (businesses[i].getReviews()[j].getUser().getLogin().equals(login)) {
                    System.out.println(businesses[i].getReviews()[j] + "\n");
                }
            }
        }
    }

    public void sortBusinessesByName() {
        int num = 1;
        Arrays.sort(this.getBusinesses());
        for (Business b: this.getBusinesses()) {
            System.out.println(num++ + ". " + b);
        }

        System.out.println();
    }

    public void sortBusinessesByRating(int type) {
        Business mostRatedByType;
        if (type == 1) {
            mostRatedByType = new Restaurant("prueba");
        } else if (type == 2) {
            mostRatedByType = new Hairdresser("prueba");
        } else
            mostRatedByType = new Garage("prueba");

        Arrays.sort(this.businesses, new BusinessRatingComparator());

        for (int i = 0; i < this.businesses.length; i++) {
            if (mostRatedByType instanceof Restaurant && businesses[i] instanceof Restaurant
                    && (mostRatedByType.getName().equals("prueba"))) {
                mostRatedByType = businesses[i];
            }

            if (mostRatedByType instanceof Hairdresser && businesses[i] instanceof Hairdresser
                    && (mostRatedByType.getName().equals("prueba"))) {
                System.out.println("Entra");
                mostRatedByType = businesses[i];
            }

            if (mostRatedByType instanceof Garage && businesses[i] instanceof Garage
                    && (mostRatedByType.getName().equals("prueba"))) {
                mostRatedByType = businesses[i];
            }
        }

        System.out.println("The business of that type with the highest rating average is\n" + mostRatedByType);
    }

    public Review findReview(User user, Business business) {
        Review userReview = null;

        for (int i = 0; i < business.getReviews().length; i++) {
            if (business.getReviews()[i].getUser() == user) {
                userReview = business.getReviews()[i];
            }
        }

        return userReview;
    }

    public static void changeReview(Review r, String comment, int rating) {
        r.setComment(comment);
        r.setRating(rating);

        System.out.println("Review updated. Your review now is:\n" + r);
    }

    public Business[] getBusinesses() {
        return businesses;
    }

    public void setBusinesses(Business[] businesses) {
        this.businesses = businesses;
    }
}
