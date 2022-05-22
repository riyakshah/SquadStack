import java.io.File;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws Exception {
    //Parking parking= Parking.createParking(6);
    //arking.createCar("ABCKSDH",23);
    Parking  parking;
    File file = new File("input.txt");
    Scanner sc = new Scanner(file);
    String command=sc.nextLine();
    String[] splited = command.split(" ");
    if(!splited[0].equals("Create_parking_lot")){        //edge case: If first input is not for create parking
      System.out.println("First create the parking system properly");
      System.exit(0);
    }
    
    parking = Parking.createParking(Integer.parseInt(splited[1]));

    
    while (sc.hasNextLine()){
      command = sc.nextLine();
      splited = command.split(" ");
      switch(splited[0]){
       
        case "Park":
         
           if(splited[1].length()!=13 &&  Integer.parseInt(splited[3])>=1000){     //edge cses: if age or registration numbers entered are not valid
            System.out.println("Please enter valid registration number and age" );
            System.exit(0);
          }
          else if(splited[1].length()!=13){
            System.out.println("Please enter valid registration number" );
            System.exit(0);
          
          }
          else if(Integer.parseInt(splited[3])>=1000){
            System.out.println("Please enter valid age" );
            System.exit(0);
          }
          parking.park(splited[1],Integer.parseInt(splited[3]));
          break;

        case "Slot_numbers_for_driver_of_age":
          parking.getSlotNumbersByAge(Integer.parseInt(splited[1]));
          break;
          
        case "Slot_number_for_car_with_number":
          parking.getSlotByRegNum(splited[1]);
          break;
          
        case "Vehicle_registration_number_for_driver_of_age":
          parking.getRegNumbersByAge(Integer.parseInt(splited[1]));
          break;
          
        case "Leave":
          parking.leave(Integer.parseInt(splited[1]));
          break;
          
        default:
          System.out.println("Invalid command");
          System.exit(0);
          break;
              
  }

  }
}
}