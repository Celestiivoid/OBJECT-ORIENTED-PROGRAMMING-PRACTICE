package PETCARESYSTEMV2;

public class PetV2 {
    private String petName;
    private String petType;
    private double hungerLevel;
    private double energyLevel;

    PetV2(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
        this.hungerLevel = 0.0;
        this.energyLevel = 100.0;
    }
    String feed(double feedAmt) {
        if(feedAmt <= 0) {
            return "Cannot validate 0 or negative numbers.";
        }
        if(hungerLevel == 0) {
            return "Pet already full.";
        }
        if(feedAmt > getHungerLevel()) {
            return "Cannot feed more than the pets' hunger level.";
        }
        hungerLevel -= feedAmt;
        return "Successfully feed " + getPetName();
    }
    String play() {
        final double PLAY_HUNGER = 15.0;
        final double PLAY_ENERGY = 25.0;
        final double HUNGER_MAX = 100;

        if(energyLevel < PLAY_ENERGY) {
            return "Pet is too exhausted to play!";
        }
        if(hungerLevel + PLAY_HUNGER > HUNGER_MAX) {
            return "Pet is too hungry to play!";
        }
        hungerLevel += PLAY_HUNGER;
        energyLevel -= PLAY_ENERGY;
        return "You played with " + getPetName();
    }
    String rest() {
         double restHunger = 5;
         double restEnergy = 100;
         double energyLevelMax = 100;

        if(energyLevel >= energyLevelMax) {
            return "Pets' energy full";
        }

        energyLevel += restEnergy - energyLevel;
        hungerLevel += restHunger;
        return getPetName() + " is ready to play!";
    }
    void displayPet() {
        System.out.println("Pet name " + getPetName());
        System.out.println("Pet type: " + getPetType());
        System.out.println("Pet hunger: " + getHungerLevel());
        System.out.println("Pet Energy " + getEnergyLevel());
        System.out.println("Pet mood: " + petMood());
    }
    String getPetName() {
        return petName;
    }
    String getPetType() {
        return petType;
    }
    double getHungerLevel() {
        return hungerLevel;
    }
    double getEnergyLevel() {
        return energyLevel;
    }
    String petMood() {
        if(getEnergyLevel() >= 85.0 && getHungerLevel() <= 35.0) {
            return "Happy";
        }
        if(getEnergyLevel() <= 50) {
            return "Sleepy";
        }
        else if(getHungerLevel() >= 50) {
            return "Hungry";
        }
        else {
            return "Calm.";
        }
    }
}
