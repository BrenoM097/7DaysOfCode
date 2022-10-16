package DaysOfCode.demo;

public class Filme {
    private final String title;
    private final String image;

    private final String rating;

    private final String year;

    Filme(String title, String image, String rating, String year) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }
}
