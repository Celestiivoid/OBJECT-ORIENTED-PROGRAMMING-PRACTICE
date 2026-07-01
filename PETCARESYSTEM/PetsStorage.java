package PETCARESYSTEM;
class Pet {
    private String petName;
    private String petType;
    private double petHunger;

    Pet(String petName, String petType, double petHunger) {
        this.petName = petName;
        this.petType = petType;
        this.petHunger = petHunger;
    }


     String eat(double feedAmount) {
        if(petHunger <= 0.0) {
            return "Pet already full";
        }
        if(feedAmount <= 0.0) {
            return "Cannot validate 0 or negative numbers";
        }
        if(feedAmount > petHunger) {
            return "You are over exceeding";
        }

        petHunger -= feedAmount;
        return "Feed successful.";
    }

    String getPetName() {
        return petName;
    }

    String getPetType() {
        return petType;
    }

    double getPetHunger() {
        return petHunger;
    }
}