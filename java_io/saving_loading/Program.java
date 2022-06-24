package java_io.saving_loading;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        // Первый персонаж
        try (FileOutputStream fileOutputStream = new FileOutputStream("java_io\\saving_loading\\Malfurion.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream("java_io\\saving_loading\\Malfurion.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                Hero Malfurion = new Hero("Malfurion");
                Malfurion.setCclass(CharacterClass.DRUID);
                Malfurion.setCrace(CharacterRace.NIGHT_ELF);
                Malfurion.lvlUp(17);
                Armor vest = new Armor("Umbrahide Vest", 12, 500);
                Malfurion.setArmor(vest);
                Weapon staff = new Weapon("Atiesh, Greatstaff of the Guardian", 105);
                Malfurion.setWeapon(staff);
                Malfurion.baseInfo();
                System.out.println();
                objectOutputStream.writeObject(Malfurion);

                Malfurion = (Hero) objectInputStream.readObject();
                Malfurion.fullInfo();
                System.out.println("\n");
                
        } catch (IOException exception) {
            System.out.println(exception.getMessage());;
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        } 
        
        // Второй персонаж
        try (FileOutputStream fileOutputStream = new FileOutputStream("java_io\\saving_loading\\Arthas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream("java_io\\saving_loading\\Arthas.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                Hero Arthas = new Hero("Arthas", CharacterClass.PALADIN, CharacterRace.HUMAN);
                Armor breastplate = new Armor("Shadowghast Breastplate", 20, 600);
                Arthas.setArmor(breastplate);
                Weapon axe = new Weapon("Shadowmourne", 75);
                Arthas.setWeapon(axe);
                Arthas.lvlUp(13);
                Arthas.baseInfo();
                System.out.println();
                objectOutputStream.writeObject(Arthas);

                Arthas = (Hero) objectInputStream.readObject();
                Arthas.fullInfo();
                System.out.println("\n");

        } catch (IOException exception) {
            System.out.println(exception.getMessage());;
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        } 
    }
}