public class HeapSort {

    private static double parent(int i){
        return Math.floor(i/2);
    }
    private static int left(int i){
        return (2*i)+1;
    }
    private static int right(int i){
        return (2*i)+2;
    }

    private static void maxHeapify(int[] arr, int i, int size){
        int l=left(i);
        int r=right(i);
        int largest;
        if(l< size && arr[l]>arr[i])
             largest=l;
        else
            largest=i;
        if(r< size && arr[r]>(arr[largest]))
            largest=r;
        if(largest!=i)
        {
            int temp=  arr[largest];
            arr[largest]=arr[i];
            arr[i]=  temp;
            maxHeapify(arr,largest,size);
        }
    }
    private static void buildMaxHeap(int[] arr){
        for(double i=Math.floor(arr.length/2)-1; i>-1;i--){
            maxHeapify(arr,(int)Math.round(i), arr.length);
        }
    }

    public static void heapSort(int[] arr){
        buildMaxHeap(arr);
        int length= arr.length;
        for(int i= length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            length=length-1;
            maxHeapify(arr,0,i);

        }
    }

    public static void print(int[] terms){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<terms.length;i++){
            str.append(terms[i]+", ");
        }
        System.out.println(str);
    }
    public static void main(String[] args){
        System.out.println("Max Heapify:");
        int[] arr ={27,17,3,16,13,10,1,5,7,12,4,8,9,0};
        maxHeapify(arr,2, arr.length);
        print(arr);

        System.out.println("\n################Build Max Heapify");
        int[] arr2={4,1,3,2,16,9,10,14,8,7};
        buildMaxHeap(arr2);
        print(arr2);

        System.out.println("\n#############Heap Sort");
        int[] arr3={16,14,10,8,7,9,3,2,4,1};
        heapSort(arr3);
        print(arr3);
    }
}
