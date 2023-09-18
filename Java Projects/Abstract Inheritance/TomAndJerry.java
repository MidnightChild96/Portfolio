public class TomAndJerry {
    public static void makeAnimalSpeak(Animal input) {//makes whatever animal speak
        input.speak();
    }

    public static void main(String[] args) {
        Animal pet1 = new Mouse("Jerry");//creates an animal class with instance mouse named Jerry
        Animal pet2 = new Cat("Tom");//creates an animal class with instance of cat named Tom
        pet1.speak();//outputs mouse noise
        pet2.speak();//outputs cat noise
        ((Mouse) pet1).chew("cheese");//downcast Jerry to use Chew method of mouse
        ((Cat) pet2).chase(((Mouse) pet1));//downcast Tom to cat to use chase method
    }
}
