public class Software extends Item {// Software class
    String version = " ";// defaults to blank

    public Software(String inputTitle, double inputPrice, String inputVersion) {// constructor requires all variables
        super(inputTitle, inputPrice);// super uesd for title and price
        version = inputVersion;// only variable in software
    }

    public String getVersion() {// returns version of software
        return version;
    }

    public void setVersion(String inputVersion) {// sets version of software
        version = inputVersion;
    }

    public String getType() {// used for sorting, returns item type
        return "Software";
    }
}
