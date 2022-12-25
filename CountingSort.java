public class CountingSort {
public static void countSort(int[] array, int size) {
    int[] output = new int[size + 1];
    int max = array[0];
    for (int i = 1; i < size; i++) {
        if (array[i] > max)
            max = array[i];
    }
    int[] count = new int[max + 1];
    for (int i = 0; i < max; ++i) {
        count[i] = 0;
    }
    for (int i = 0; i < size; i++) {
        count[array[i]]++;
    }
    for (int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
    }
    for (int i = size - 1; i >= 0; i--) {
        output[count[array[i]] - 1] = array[i];
        count[array[i]]--;
    }
    for (int i = 0; i < size; i++) {
        array[i] = output[i];
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
        System.out.println("Counting Sort");
        int[] arr ={ 4, 2, 2, 8, 3, 3, 1 };
        countSort(arr,arr.length);
        print(arr);
    }
}
