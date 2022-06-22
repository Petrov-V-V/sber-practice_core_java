package oop_1.Task1;

public class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone(String model, String number, int weight){
        this.model = model;
        this.number = number;
        this.weight = weight;
    }
    
    public Phone(String model, String number){
        this.model = model;
        this.number = number;
        weight = 0;
    }
    
    public Phone(){
        model = "Undefined model";
        number = "8 (***) ***-**-**";
        weight = 0;
    }

    public String getNumber(){
        return number;
    }

    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String number){
        System.out.print("Звонит " + name);
        System.out.println(", Номер " + number);
    }

    public static void sendMessage(){
        String[] numbers = {"8 (737) 005-01-97", "8 (989) 044-13-30", "8 (085) 965-69-22", "8 (230) 590-28-91",
                            "8 (521) 520-47-73", "8 (393) 288-68-21", "8 (232) 521-84-04", "8 (083) 171-11-63",
                            "8 (486) 695-42-09", "8 (189) 252-09-02"};

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    @Override
    public String toString() {
        return "Phone (Model = " + model + ", Number = " + number + ", Weight = " + weight + ")";
    }
}