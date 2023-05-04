import java.util.*;

class Song{
    private final String title;
    private final String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class MusicLibrary {
    private ArrayList<Song> songs;

    public MusicLibrary() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public ArrayList<Song> searchByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();

        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                result.add(song);
            }
        }
        return result;
    }

    public ArrayList<Song> searchByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();

        for (Song song : songs) {
            if (song.getArtist().equals(artist)) {
                result.add(song);
            }
        }
        return result;
    }

    public ArrayList<Song> getAllSongs() {
        return songs;
    }
}

public class MusicLibraryProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicLibrary musicLibrary = new MusicLibrary();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song");
            System.out.println("3. Search songs by title");
            System.out.println("4. Search songs by artist");
            System.out.println("5. Display all songs");
            System.out.println("6. Quit");
            System.out.println("-------------------------");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the title of the song:");
                    String title = scanner.nextLine();
                    System.out.println("Enter the artist of the song:");
                    String artist = scanner.nextLine();
                    Song song = new Song(title, artist);
                    musicLibrary.addSong(song);
                    System.out.println("Song added.");
                    break;
                case 2:
                    System.out.println("Enter the title of the song:");
                    String titleToRemove = scanner.next();
                    ArrayList<Song> songsToRemove = musicLibrary.searchByTitle(titleToRemove);
                    if (songsToRemove.size() == 0) {
                        System.out.println("Song not found.");
                    } else if (songsToRemove.size() == 1) {
                        musicLibrary.removeSong(songsToRemove.get(0));
                        System.out.println("Song removed.");
                    } else {
                        System.out.println("Multiple songs found:");
                        for (int i = 0; i < songsToRemove.size(); i++) {
                            System.out.println((i + 1) + ". " + songsToRemove.get(i).getTitle() + " by " + songsToRemove.get(i).getArtist());
                        }
                        System.out.println("Enter the number of the song to remove:");
                        int songToRemoveIndex = scanner.nextInt() - 1;
                        Song songToRemove = songsToRemove.get(songToRemoveIndex);
                        musicLibrary.removeSong(songToRemove);
                        System.out.println("Song removed.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the title of the song:");
                    String titleToSearch = scanner.next();
                    ArrayList<Song> songsWithTitle = musicLibrary.searchByTitle(titleToSearch);
                    if (songsWithTitle.size() == 0) {
                        System.out.println("Song not found.");
                    } else {
                        System.out.println("Songs with the title '" + titleToSearch + "':");
                        for (Song s : songsWithTitle) {
                            System.out.println(s.getTitle() + " by " + s.getArtist());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the name of the artist:");
                    String artistToSearch = scanner.next();
                    ArrayList<Song> songsWithArtist = musicLibrary.searchByArtist(artistToSearch);
                    if (songsWithArtist.size() == 0) {
                        System.out.println("No songs found for the artist " + artistToSearch);
                    } else {
                        System.out.println("Songs by the artist '" + artistToSearch + "':");
                        for (Song s : songsWithArtist) {
                            System.out.println(s.getTitle() + " by " + s.getArtist());
                        }
                    }
                    break;
                case 5:
                    ArrayList<Song> allSongs = musicLibrary.getAllSongs();
                    if (allSongs.size() == 0) {
                        System.out.println("There are no songs in the library.");
                    } else {
                        System.out.println("All songs:");
                        for (Song s : allSongs) {
                            System.out.println(s.getTitle() + " by " + s.getArtist());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
