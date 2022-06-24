package java_io.saving_loading;

import java.io.*;

public class Weapon implements Serializable{
    private String name;
    private int addlDmg;

    public Weapon(String name, int addlDmg) {
        this.name = name;
        this.addlDmg = addlDmg;
    }

    public int getAddlDmg() {
        return addlDmg;
    }
    
    @Override
    public String toString(){
        return "Weapon name: " + name + "\nWeapon damage: " + addlDmg;
    }
}