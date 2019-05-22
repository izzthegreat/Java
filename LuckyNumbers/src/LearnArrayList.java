import java.util.ArrayList;

public class LearnArrayList {
    static void learnArrayList() {
        ArrayList<Integer> name3 = new ArrayList<>();
        name3.add(12);
        for (int i = 0; i<400000; i++) name3.add(i);
        System.out.println(name3.size());
        System.out.println(name3.get(2000));
        Integer storeIt = name3.remove(3702);
        System.out.println(storeIt);
        System.out.println(takesArrayList(name3));
        printAString("A string");
        addNums(2,3);
        bigO();
    }

    static long takesArrayList (ArrayList<Integer> doodle){

        long total = 0;
        for(int name: doodle) {
            total += name;
        }
        return total;
    }

    static void printAString (String words){
        System.out.println(words);
    }

    static void addNums (int a, int b){
        System.out.println(a+b);
    }

    static void bigO () {
        int n = 16;
        for (int i = 1; i < n; i = i*2){
            System.out.println("Hey,I'm busy looking at " + i);
        }
    }

}
