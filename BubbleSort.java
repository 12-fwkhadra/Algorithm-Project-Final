public class BubbleSort{
    public static  void bubbleSort(int[] arr){
        int temp;
        for(int i=0;i< arr.length;i++){
            for(int j= arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1])
                { temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;}
            }
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
        System.out.println("Bubble Sort");
        int[] data = { -2, 45, 0, 11, -9 };
        bubbleSort(data);
        print(data);
    }
}
