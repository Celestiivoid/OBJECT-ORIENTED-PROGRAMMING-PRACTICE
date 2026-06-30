
class Pet {
    String petName;
    int hungerLevel;

    Pet(String petName, int hungerLevel) {
        this.petName = petName;
        this.hungerLevel = hungerLevel;
    }
}

public class OOPCHL1 {
    public static void main(String[] args) {

        Pet dog = new Pet("Timmy",40);
        System.out.println(dog);
    }
}