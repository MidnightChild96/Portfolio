abstract class Animal {
    private String name;//keeps track of name
    private String speech;//keeps track of the speech

    public Animal(String inputName, String inputSpeech) {//constructor
        name = inputName;
        speech = inputSpeech;
    }

    public String getSpeech() {//get method for speech
        return speech;
    }

    public void setSpeech(String input) {//set method for speech
        speech = input;
    }

    public String getName() {//get method for name
        return name;
    }

    public void setName(String input) {//set method for name
        name = input;
    }

    public void speak() {
        System.out.println(name + " says " + speech);//prints out animal noise
    }
}