import java.util.*;

//As only one object of this class needs to be created, have used Singleton design pattern
public class Parking{
  int slots;                  //total number of slots
  private static Parking instance;
  public boolean arr[];
  public HashMap<String,Integer> reg_slot_map = new HashMap<String,Integer>();
  public HashMap<Integer,List<String>> age_reg_map= new HashMap<Integer,List<String>>();
  public HashMap<Integer,List<Integer>> age_slot_map = new HashMap<Integer,List<Integer>>();
  public HashMap<Integer,Car> slot_car_map = new HashMap<Integer,Car>();

  
  private Parking(int slots){
    this.slots=slots; 
    arr=new boolean[slots];

  }

  public static Parking createParking(int slots){
    if(instance==null){
    instance= new Parking(slots);
      }
    System.out.println("Created parking of "+slots+" slots");
    return instance;
  }

  
  

  public int park(String registration_number,int age){
    Car car=new Car(registration_number,age);
    boolean full=true;                                 //to check weather parking lot is full or not

    for(int i=0;i<arr.length;i++){
      if(!arr[i]){                                      //arr[i] will be false if that slot is empty
        full=false;
        arr[i]=true;
        car.allocated_slot=i+1;                         //allocated slot will be from 1 to n
        break;
      }
      }
      if(full){                                         //edge case: if parking lot is full
        System.out.println("Parking is full");
      }
    
    reg_slot_map.put(car.registration_number,car.allocated_slot);      //add all values corresponding to this car in maps
    slot_car_map.put(car.allocated_slot, car);
    if(age_reg_map.get(car.age)==null){
      age_reg_map.put(car.age,new ArrayList<String>());
    }
  
    age_reg_map.get(car.age).add(car.registration_number);
    
    if(age_slot_map.get(car.age)==null){
      age_slot_map.put(car.age,new ArrayList<Integer>());
    }
    age_slot_map.get(car.age).add(car.allocated_slot);
    printTicket(car.registration_number,car.allocated_slot);
    
    
    return car.allocated_slot;
  
  }


  public void printTicket(String registration_number,int allocated_slot){
    System.out.println("Car with vehicle registration number \"" +registration_number+"\" has been parked at slot number " + allocated_slot);
  return;    
  }


  public void getSlotNumbersByAge(int age){
    if(age_slot_map.containsKey(age)){         //edge case: if there is no slot with particular driver age
    List<Integer> list=age_slot_map.get(age);
    int len=list.size();
    for(int i=0;i<len-1;i++){
      System.out.print(list.get(i)+",");
    }
    if(len>0){
    System.out.println(list.get(len-1));
    }
    }
    }

  public void getSlotByRegNum(String registration_number){
    if(reg_slot_map.containsKey(registration_number)){        //edge case: if there is no car with particular registration number
    int allocated_slot=reg_slot_map.get(registration_number);
    System.out.println(allocated_slot);
    
  }
    } 

  public void getRegNumbersByAge(int age){            
    if(age_reg_map.containsKey(age)){                      //edge case: if there is no car with this driver age

    List<String> list = age_reg_map.get(age);
      
    int len = list.size();
    for(int i=0;i<len-1;i++){
      System.out.print(list.get(i)+",");
    }
    if(len>0){                                            
    System.out.println(list.get(len-1));  
    }
    }
    }

  public Car getCarBySlot(int slot){         
    
    return slot_car_map.get(slot);
       
  }


  public void leave(int allocated_slot){
    arr[allocated_slot-1]=false;
    Car car = getCarBySlot(allocated_slot);
    
    List<Integer> list = age_slot_map.get(car.age);
    int n=list.size();
    for(int i=0;i<n;i++){
      if(list.get(i)==allocated_slot){
          list.remove(i);
      }
      }
    if(list.size()==0){               //edge case: If after removing element from list, list size is 0
      age_slot_map.remove(car.age);
    }
    
    reg_slot_map.remove(car.registration_number);
    
    List<String> list2 = age_reg_map.get(car.age);  
    list2.remove(car.registration_number);
    if(list2.size()==0){            //edge case: If after removing element from list, list size is 0
      age_reg_map.remove(car.age);
    }
    
    slot_car_map.remove(allocated_slot);

    System.out.println("Slot number "+allocated_slot+" vacated, the car with vehicle registration number \""+car.registration_number+"\" left the space, the driver of the car was of age "+ car.age);
    
    return;
    }  
  
  
}