package DaysOfCodeDay2.demo;

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


    public String getAll() {
       String agroup = title + "\n" + image + "\n" + rating + "\n" + year;
        return agroup;
    }


}
