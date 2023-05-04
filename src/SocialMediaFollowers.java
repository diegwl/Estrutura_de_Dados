import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SocialMediaFollowers {
    private Set<String> followers;

    public SocialMediaFollowers() {
        followers = new HashSet<String>();
    }

    public void addFollower(String follower) {
        followers.add(follower);
    }

    public void removeFollower(String follower) {
        followers.remove(follower);
    }

    public boolean hasFollower(String follower) {
        return followers.contains(follower);
    }

    public int countFollowers() {
        return followers.size();
    }

    public void displayFollowers() {
        System.out.println(followers);
    }
    public static void main(String[] args) {
        SocialMediaFollowers socialMediaFollowers = new SocialMediaFollowers();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true){
            System.out.println("Enter a command (add, remove, has, count, or display): ");
            String command = scanner.nextLine();
            switch (command) {
                case "add": {
                    System.out.println("Enter a follower name: ");
                    String follower = scanner.nextLine();
                    socialMediaFollowers.addFollower(follower);
                    break;
                }
                case "remove": {
                    System.out.println("Enter a follower name: ");
                    String follower = scanner.nextLine();
                    socialMediaFollowers.removeFollower(follower);
                    break;
                }
                case "has":
                    System.out.println("Enter a search term: ");
                    String has = scanner.nextLine();
                    boolean result_has = socialMediaFollowers.hasFollower(has);
                    System.out.println(result_has);
                    break;
                case "count":
                    int result_count = socialMediaFollowers.countFollowers();
                    System.out.printf("You have %d followers", result_count);
                    break;
                case "display":
                    socialMediaFollowers.displayFollowers();
                case "quit":
                    break label;
            }
        }
        scanner.close();
    }
}
