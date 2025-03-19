class PetrolPump {
  int petrol, distance;

  public PetrolPump(int petrol, int distance) {
    this.distance = distance;
    this.petrol = petrol;
  }
}

public class circularTour {
  public static int checkTour(PetrolPump[] pumps) {
    int balance = 0;
    int starting_Idx = 0;
    int total = 0;

    for (int i = 0; i < pumps.length; i++) {
      balance += pumps[i].petrol - pumps[i].distance;
      total += pumps[i].petrol - pumps[i].distance;
      if (balance < 0) {
        starting_Idx = i + 1;
        balance = 0;
      }

    }
    return ( total >= 0 ) ? starting_Idx : -1;
  }

  public static void main(String[] args) {
    PetrolPump[] pumps = {
        new PetrolPump(6, 4),
        new PetrolPump(5, 6),
        new PetrolPump(3, 7),
        new PetrolPump(7, 4)
    };

    int start = checkTour(pumps);
    System.out.println((start == -1) ? "Not possible" : start);
  }
}
