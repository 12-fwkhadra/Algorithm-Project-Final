import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;


public class Evaluation {
    private static String choice(int x, int[] arr){
        if(x==1){ Merge.mergeSort(arr,0,arr.length-1); return "Merge Sort"; }
        if(x==2){ InsertionSort.insertionSort(arr); return "Insertion Sort"; }
        if(x==3){ HeapSort.heapSort(arr); return "Heap Sort"; }
        if(x==4){
            QuickSort.quickSort(arr,0, arr.length-1);
            return "Quick Sort";
        }
        if(x==5){
            BubbleSort.bubbleSort(arr);
            return "Bubble Sort";
        }
        if (x==6){
            SelectionSort.selectionSort(arr);
            return "Selection Sort";
        }
        if (x==7){
            CountingSort.countSort(arr, arr.length);
            return "Count Sort";
        }
        return "No algorithm selected";
    }


    public static void main(String[] args) {
        Map<Integer, Map<String, Double>> finalTable = new HashMap<Integer, Map<String, Double>>();
        int n;
        for( n=50;n<=2000;n+=10){
            //generate array of random numbers
            int N=n;
            Map<String, Double> average_Execution_at_Each_n = new HashMap<String, Double>();
            String sortAlgorithm = null;
            for(int k=1;k<8;k++){
                double execution=0;
                for(int i=0;i<500;i++){
                    int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt((int)N/2)).limit(n).toArray();
                    double start = System.nanoTime();
                    sortAlgorithm=choice(k,randomIntsArray.clone());
                    double end = System.nanoTime();
                    execution+=(end - start);
                }
                double averageExecution=execution/500;
                average_Execution_at_Each_n.put(sortAlgorithm,averageExecution);
            }
            finalTable.put(n,average_Execution_at_Each_n);
        }
        convertor(finalTable);
    }
    private static void convertor(Map<Integer, Map<String, Double>> table){
        JSONObject json =  new JSONObject(table);

        //save the results in a JSON file
        try (FileWriter file = new FileWriter("results.json")) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

