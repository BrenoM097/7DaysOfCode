package DaysOfCode.demo;

public class Filme implements Content {
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
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getImage() {
        return image;
    }
    @Override
    public String getRating() {
        return rating;
    }
    @Override
    public String getYear() {
        return year;
    }


}
