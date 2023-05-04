import java.util.*;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> movieRatings = new HashMap<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("-------------------------");
            System.out.println("Movie Ratings Menu");
            System.out.println("1. Add new movie rating");
            System.out.println("2. Update rating for existing movie");
            System.out.println("3. Calculate average rating for a movie");
            System.out.println("4. Display top-rated movies");
            System.out.println("5. Exit");
            System.out.println("-------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    scanner.nextLine();
                    String movieTitle = scanner.nextLine();
                    System.out.print("Enter movie rating: ");
                    int rating = scanner.nextInt();
                    addRating(movieRatings, movieTitle, rating);
                    break;
                case 2:
                    System.out.print("Enter movie title: ");
                    scanner.nextLine();
                    movieTitle = scanner.nextLine();
                    System.out.print("Enter new rating: ");
                    int newRating = scanner.nextInt();
                    updateRating(movieRatings, movieTitle, newRating);
                    break;
                case 3:
                    System.out.print("Enter movie title: ");
                    scanner.nextLine();
                    movieTitle = scanner.nextLine();
                    double averageRating = calculateAverageRating(movieRatings, movieTitle);
                    if (averageRating == 0) {
                        System.out.println("No ratings found for " + movieTitle);
                    } else {
                        System.out.println("Average rating for " + movieTitle + ": " + averageRating);
                    }
                    break;
                case 4:
                    System.out.print("Enter number of top-rated movies to display: ");
                    int n = scanner.nextInt();
                    displayTopRatedMovies(movieRatings, n);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void addRating(Map<String, List<Integer>> movieRatings, String movieTitle, int rating) {
        if (!movieRatings.containsKey(movieTitle)) {
            movieRatings.put(movieTitle, new ArrayList<Integer>());
        }
        movieRatings.get(movieTitle).add(rating);
    }

    public static void updateRating(Map<String, List<Integer>> movieRatings, String movieTitle, int newRating) {
        if (movieRatings.containsKey(movieTitle)) {
            movieRatings.get(movieTitle).add(newRating);
        }
    }

    public static double calculateAverageRating(Map<String, List<Integer>> movieRatings, String movieTitle) {
        if (!movieRatings.containsKey(movieTitle)) {
            return 0;
        }
        List<Integer> ratings = movieRatings.get(movieTitle);
        double sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    public static void displayTopRatedMovies(Map<String, List<Integer>> movieRatings, int n) {
        List<Map.Entry<String, Double>> movieAverages = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            String movieTitle = entry.getKey();
            double averageRating = calculateAverageRating(movieRatings, movieTitle);
            movieAverages.add(new AbstractMap.SimpleEntry<>(movieTitle, averageRating));
        }
        movieAverages.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        System.out.printf("Top %d rated movies:\n", n);
        for (int i = 0; i < n && i < movieAverages.size(); i++) {
            System.out.println((i + 1) + ". " + movieAverages.get(i).getKey() + " (" + movieAverages.get(i).getValue() + ")");
        }
    }
}
