package base_syntax;

public class Task2 {
    public static int [] quick_sort(int[] array){
        int [] lower = new int [array.length], higher = new int[array.length], equal = new int[array.length];
        int lcount = 0, hcount = 0, ecount = 0;
        if (array.length > 1){
            int pivot = array[0];

            //System.out.println("array = "+array.length);

            for (int i = 0; i < array.length; i++) {
                if (array[i] < pivot){
                    lower[lcount] = array[i];
                    lcount++;
                } else if (array[i] > pivot){
                    higher[hcount] = array[i];
                    hcount++;
                } else if (array[i] == pivot){
                    equal[ecount] = array[i];
                    ecount++;
                }
            }
            
            int [] newlower = new int [lcount], newhigher = new int[hcount], newequal = new int[ecount];

            //System.out.println("newlower = "+newlower.length);
            //System.out.println("newhigher = "+newhigher.length);
            //System.out.println("newequal = "+newequal.length);

            for (int i = 0; i < newlower.length; i++) {
                newlower[i] = lower[i];
            }
            for (int i = 0; i < newhigher.length; i++) {
                newhigher[i] = higher[i];
            }
            for (int i = 0; i < newequal.length; i++) {
                newequal[i] = equal[i];
            }

            int [] newestlower = quick_sort(newlower), newesthigher = quick_sort(newhigher);

            //System.out.println("newestlower = "+newestlower.length);
            //System.out.println("newesthigher = "+newesthigher.length);

            int [] finalarray = new int [newestlower.length+newequal.length+newesthigher.length];

            //System.out.println("final = "+finalarray.length);

            int j = 0;
            for (int i = 0; i < newestlower.length; i++) {
                finalarray[i] = newestlower[j];
                j++;
            }
            j = 0;
            for (int i = newestlower.length; i < newestlower.length+newequal.length; i++) {
                finalarray[i] = newequal[j];
                j++;
            }
            j = 0;
            for (int i = newestlower.length+newequal.length; i < newestlower.length+newequal.length+newesthigher.length; i++) {
                finalarray[i] = newesthigher[j];
                j++;
            }

            return finalarray;
        }else{
            return array;
        }
    }
    public static void main(String[] args) {
        int [] array = {2, 0, 4, 5, 7, 8, 3, 9, 10, 9, 5, 1};
        array = quick_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}