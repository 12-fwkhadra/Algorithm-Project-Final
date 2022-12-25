public class SelectionSort {
    public static  void selectionSort(int[] arr){
        for(int i=0;i< arr.length;i++){
            int smallest=i;
            for(int j=i+1;j< arr.length;j++)
            {
                if(arr[j]<arr[smallest]){
                    smallest=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
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
        System.out.println("Selection Sort");
        int[] data = {64,25,12,22,11};
        selectionSort(data);
        print(data);
    }
}
