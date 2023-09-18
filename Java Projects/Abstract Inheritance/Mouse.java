public class Mouse extends Animal {//inherits animal methods
    public Mouse(String name) {
        super(name, "squeak");//uses animal method to place name and create speach
    }

    public void chew(String food) {
        System.out.println(super.getName() + " is chewing on " + food + ".");//uses the super to get the name of the variable
    }

}
