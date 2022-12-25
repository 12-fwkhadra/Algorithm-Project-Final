import java.util.Random;

public class InsertionSort {
    static int key,i;

    public static void insertionSort(int[] terms){
        for(int j=1;j<terms.length;j++){
            key=terms[j];
            i=j-1;
            while(i>=0 && terms[i]>key){
                terms[i+1]=terms[i];
                i=i-1;
            }
            terms[i+1]=key;
        }
    }
    public static void print(int[] terms){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<terms.length;i++){
            str.append(terms[i]+", ");
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        int[] terms={5,2,4,6,1,3};
        System.out.println("The first array before sorting: ");
        print(terms);
        System.out.println("The first array after sorting: ");
        insertionSort(terms);
        print(terms);

        System.out.println("\n################");
        Random rand=new Random();

        int[] terms2 = new int[20];
        for(int i=0;i<20;i++){
            int intRand=rand.nextInt(10);
            terms2[i]=intRand;
        }
        System.out.println("The second random array before sorting: ");
        print(terms2);
        System.out.println("The second random array after sorting: ");
        insertionSort(terms2);
        print(terms2);
    }
}
