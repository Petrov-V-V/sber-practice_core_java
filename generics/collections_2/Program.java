package generics.collections_2;

public class Program {
    public static void main(String[] args) {
        System.out.println("\n\tHASHMAP TESTING\n");
        System.out.println("\tput, values, keySet and entrySet testing");
        HashMap<Object, Object> hMap = new HashMap<>();
        hMap.put(1, 1);
        hMap.put("2", "2");
        hMap.put(3, 3);
        hMap.put(3, "4");
        hMap.put(5, "five");
        hMap.put("six", 6);
        hMap.put("seven", null);
        for (Object el : hMap.values())
            System.out.print(el+"  ");
        System.out.println();
        for (Object el : hMap.keySet())
            System.out.print(el+"  ");
        System.out.println();
        for (Entry<Object, Object> el : hMap.entrySet()) 
            System.out.print(((Entry<Object, Object>) el).getKey()+":"+((Entry<Object, Object>) el).getValue()+"  ");
        System.out.println();

        System.out.println("\tcontainsKey testing");
        System.out.println(hMap.containsKey(1));
        System.out.println(hMap.containsKey("2"));
        System.out.println(hMap.containsKey(2));
        System.out.println("\tcontainsValue testing");
        System.out.println(hMap.containsValue("4"));
        System.out.println(hMap.containsValue("five"));
        System.out.println(hMap.containsValue(null));
        System.out.println(hMap.containsValue(3));

        System.out.println("\tget testing");
        System.out.println(hMap.get(1));
        System.out.println(hMap.get("seven"));
        System.out.println(hMap.get(3));

        System.out.println("\tremove testing");
        System.out.println(hMap.remove(1));
        System.out.println(hMap.remove(5));
        for (Entry<Object, Object> el : hMap.entrySet()) 
            System.out.print(((Entry<Object, Object>) el).getKey()+":"+((Entry<Object, Object>) el).getValue()+"  ");
        System.out.println();

        System.out.println("\tisEmpty and clear testing");
        System.out.println(hMap.isEmpty());
        hMap.clear();
        System.out.println(hMap.isEmpty());

        
        System.out.println("\n\tTREEMAP TESTING\n");
        System.out.println("\tput, values, keySet and entrySet testing");
        TreeMap<Object, Object> tMap = new TreeMap<>();
        tMap.put(1, 1);
        tMap.put("2", "2");
        tMap.put(3, 3);
        tMap.put(3, "4");
        tMap.put(5, "five");
        tMap.put("six", 6);
        tMap.put("seven", null);
        for (Object el : tMap.values())
            System.out.print(el+"  ");
        System.out.println();
        for (Object el : tMap.keySet())
            System.out.print(el+"  ");
        System.out.println();
        for (Entry<Object, Object> el : tMap.entrySet()) 
            System.out.print(((Entry<Object, Object>) el).getKey()+":"+((Entry<Object, Object>) el).getValue()+"  ");
        System.out.println();

        System.out.println("\tcontainsKey testing");
        System.out.println(tMap.containsKey(1));
        System.out.println(tMap.containsKey("2"));
        System.out.println(tMap.containsKey(2));
        System.out.println("\tcontainsValue testing");
        System.out.println(tMap.containsValue("4"));
        System.out.println(tMap.containsValue("five"));
        System.out.println(tMap.containsValue(null));
        System.out.println(tMap.containsValue(3));

        System.out.println("\tget testing");
        System.out.println(tMap.get(1));
        System.out.println(tMap.get("seven"));
        System.out.println(tMap.get(3));

        System.out.println("\tremove testing");
        System.out.println(tMap.remove(1));
        System.out.println(tMap.remove(5));
        for (Entry<Object, Object> el : tMap.entrySet()) 
            System.out.print(((Entry<Object, Object>) el).getKey()+":"+((Entry<Object, Object>) el).getValue()+"  ");
        System.out.println();

        System.out.println("\tisEmpty and clear testing");
        System.out.println(tMap.isEmpty());
        tMap.clear();
        System.out.println(tMap.isEmpty());
    }
}