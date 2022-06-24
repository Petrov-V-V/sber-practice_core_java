package java_io.saving_loading;

import java.io.*;

public class Hero implements Serializable{
    private static final long serialVersionUID = 1L;
    private CharacterClass cclass;
    private CharacterRace crace;
    private String nickname;
    private int lvl;
    private int maxHP;
    private int baseDmg;
    private int baseArmor;
    private Weapon weapon;
    private Armor armor;

    public Hero(String nickname) {
        this.nickname = nickname;
        lvl = 1;
        maxHP = 200;
        baseDmg = 10;
        baseArmor = 2;
    }

    public Hero(String nickname, CharacterClass cclass, CharacterRace crace) {
        this.nickname = nickname;
        lvl = 1;
        maxHP = 200;
        baseDmg = 10;
        baseArmor = 2;
        this.cclass = cclass;
        this.crace = crace;
    }

    public void lvlUp(int lvl){
        if (lvl > 0){
            this.lvl += lvl;
            maxHP += 10 * (this.lvl - 1);
            baseDmg += 2 * (this.lvl - 1);
            baseArmor += 1 * ((this.lvl - 1) / 5);
        }
    }

    public void baseInfo(){
        System.out.println("\tBase Info");
        System.out.println("Name: " + nickname);
        if (cclass != null)
            System.out.println("Class: " + cclass);
        if (crace != null)
            System.out.println("Race: " + crace);
        System.out.println("Level: " + lvl);
        int curHP;
        if (armor != null)
            curHP = maxHP + armor.getAddlHP();
        else
            curHP = maxHP;
        System.out.println("Max HP: " + curHP);
        int curDmg;
        if (weapon != null)
            curDmg = baseDmg + weapon.getAddlDmg();
        else
            curDmg = baseDmg;
        System.out.println("Damage: " + curDmg);
        int curArmor;
        if (armor != null)
            curArmor = baseArmor + armor.getAddlArmor();
        else
            curArmor = baseArmor;
        System.out.println("Armor: " + curArmor);
    }

    public void fullInfo(){
        System.out.println("\tFull Info");
        System.out.println("Name: " + nickname);
        if (cclass != null)
            System.out.println("Class: " + cclass);
        else
            System.out.println("Class is not chosen yet");
        if (crace != null)
            System.out.println("Race: " + crace);
        else
            System.out.println("Race is not chosen yet");
        System.out.println("Level: " + lvl);
        System.out.println("Base HP: " + maxHP);
        System.out.println("Base Damage: " + baseDmg);
        System.out.println("Base Armor: " + baseArmor);
        System.out.println("\tEquipment");
        if (weapon != null)
            System.out.println(weapon);
        else
            System.out.println("Weapon is missing");
        if (armor != null)
            System.out.println(armor);
        else
            System.out.println("Armor is missing");
    }

    public void setCclass(CharacterClass cclass) {
        this.cclass = cclass;
    }
    public void setCrace(CharacterRace crace) {
        this.crace = crace;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}