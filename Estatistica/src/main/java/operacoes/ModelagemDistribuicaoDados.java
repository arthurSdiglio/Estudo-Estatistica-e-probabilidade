package operacoes;

import java.util.Arrays;
import java.util.List;

public class ModelagemDistribuicaoDados {
    List<Float> arr;

    public ModelagemDistribuicaoDados(Float... arr){
        this.arr = Arrays.asList(arr);
    }

    public float percentilIgualAbaixo(float value){
        float indexValue = arr.lastIndexOf(value)+1;
        float sizeArr = arr.size();
        return indexValue/sizeArr;
    }

    public float percentilAbaixo(float value){
        float indexValue = arr.lastIndexOf(value);
        float sizeArr = arr.size();
        return indexValue/sizeArr;
    }


    public void setArr(Float... arr) {
        this.arr = Arrays.asList(arr);
    }
}
