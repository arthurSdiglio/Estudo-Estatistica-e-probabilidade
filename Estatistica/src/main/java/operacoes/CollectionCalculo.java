package operacoes;

public class CollectionCalculo {
     public int[] getSliceOfArray(int[] arr, int start, int end){
         int[] slice = new int[end-start];

         for (int i = 0; i < slice.length; i++) {
             slice[i] = arr[start + i];
         }
         return slice;
    }

    public int findIndiceArray(Integer[] arr, int value){
         if(arr == null){
            return -1;
         }

         int i = 0;
         int len = arr.length;
         while(i < len){
             if(arr[i] == value){
                 return i;
             }
             i++;
         }
         return -1;
    }
}
