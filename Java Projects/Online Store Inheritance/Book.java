public class Book extends Item {// book class
    private String authors = " ";// all variables instanitated to avoid null
    private String edition = " ";
    private String publisher = " ";
    private int pubYear;

    public Book(String inputTitle, double inputPrice, String inputAuthor, String inputEdition, String inputPublisher,
            int inputYear) {// constructor with all variables
        super(inputTitle, inputPrice);
        authors = inputAuthor;
        edition = inputEdition;
        publisher = inputPublisher;
        pubYear = inputYear;
    }

    public String getAuthor() {// all getters and setter methods
        return authors;
    }

    public void setAuthor(String inputAuthor) {
        authors = inputAuthor;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String inputEdition) {
        edition = inputEdition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String inputPublisher) {
        publisher = inputPublisher;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int inputYear) {
        pubYear = inputYear;
    }

    public String getType() {// returns book type
        return "Book";
    }
}
