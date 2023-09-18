public class Cat extends Animal {//inherits animal methods
    public Cat(String name) {
        super(name, "meow");//inputs name and speak to animal
    }

    public void chase(Mouse input) {//requires mouse object
        System.out.println(super.getName() + " is chasing " + input.getName() + ".");//prints out the message
    }
}
