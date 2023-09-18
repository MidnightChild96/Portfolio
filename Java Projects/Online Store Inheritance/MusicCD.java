public class MusicCD extends Item {// music class
    private String artists = " ";// default variables avoiding nulls
    private String releaseDate;
    private String label = " ";
    private String recordCompany = " ";
    private int totalLength;
    private String genres = " ";

    public MusicCD(String inputTitle, double inputPrice, String inputArtist, String inputDate, String inputLabel,
            String inputRecordCompany, int inputLength, String inputGenre) {// constructor with all variables
        super(inputTitle, inputPrice);
        artists = inputArtist;
        releaseDate = inputDate;
        label = inputLabel;
        recordCompany = inputRecordCompany;
        totalLength = inputLength;
        genres = inputGenre;
    }

    public String getArtist() {// getters and setters for each variable
        return artists;
    }

    public void setArtist(String inputArtist) {
        artists = inputArtist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String inputDate) {
        releaseDate = inputDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String inputLabel) {
        label = inputLabel;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String inputRecordCompany) {
        recordCompany = inputRecordCompany;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int length) {
        totalLength = length;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String inputGenres) {
        genres = inputGenres;
    }

    public String getType() {// returns music type
        return "Music";
    }
}
