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
        final double playHunger = 15;
        final double playEnergy = 20;

        if(hungerLevel >= 100) {
            return "Pet is too hungry to play!";
        }
        if(energyLevel == 0) {
            return "Pet is too exhausted to play!";
        }
        hungerLevel += playHunger;
        energyLevel -= playEnergy;
        return "You played with " + getPetName();
    }
    String rest() {
        final double restHunger = 5;
        final double restEnergy = 100;

        if(energyLevel >= 100) {
            return "Pet is not tired yet!";
        }
            
        hungerLevel += restHunger;  
        energyLevel += restEnergy;
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
            return "Pet ran away.";
        }
    }
}
