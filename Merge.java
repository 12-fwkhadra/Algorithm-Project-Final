public class Merge{
    // Merge two subarrays L and M into arr
    static void merge(int[] arr, int p, int q, int r) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

//        genericArrays L=new genericArrays(int.class,n1);
//        genericArrays M=new genericArrays(int.class,n2);
        int L[]=new int[n1+1];
        int M[]=new int[n2+1];
        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        Integer maxNb=Integer.MAX_VALUE;
        L[n1]= maxNb;
        M[n2]= maxNb;
        int i, j;
        i = 0;
        j = 0;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        for(int k=p; k<=r; k++) {
            if (L[i]<= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
        }

    }

    // Divide the array into two subarrays, sort them and merge them
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m =(int) Math.floor ((l + r) / 2);

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // Print the array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int[] arr = { 6, 5, 12, 10, 9, 1 };

        Merge ob = new Merge();
        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
