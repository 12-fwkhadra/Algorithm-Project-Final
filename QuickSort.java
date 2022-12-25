

public class QuickSort {
    public static  void quickSort(int[] arr, int p, int r){
        if(p<r){
            int q=partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    private static  int partition(int[] arr, int p, int r){
        int x=arr[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<=x){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return i+1;
    }
    public static void print(int[] terms){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<terms.length;i++){
            str.append(terms[i]+", ");
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        System.out.println("Quick Sort");
        int[] arr ={2,8,7,1,3,5,6,4};
        quickSort(arr,0, arr.length-1);
        print(arr);
    }
}
