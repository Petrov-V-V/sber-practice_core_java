package java_io.saving_loading;

import java.io.*;

public class Armor implements Serializable{
    private String name;
    private int addlArmor;
    private int addlHP;

    public Armor(String name, int addlArmor, int addlHP) {
        this.name = name;
        this.addlArmor = addlArmor;
        this.addlHP = addlHP;
    }

    public int getAddlArmor() {
        return addlArmor;
    }

    public int getAddlHP() {
        return addlHP;
    }
    
    @Override
    public String toString(){
        return "Armor name: " + name + "\nArmor: " + addlArmor + "\nArmor HP gained: " + addlHP;
    }
}