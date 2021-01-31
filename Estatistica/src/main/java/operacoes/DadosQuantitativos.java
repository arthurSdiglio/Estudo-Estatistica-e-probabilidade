package operacoes;

import java.util.*;

public class DadosQuantitativos extends CollectionCalculo {
    private int[] valores;

    public DadosQuantitativos() {
        this.valores = new int[0];
    }

    public DadosQuantitativos(int[] valores) {
        this.valores = valores;
    }

    public float media() {
        try{
            float somatorioValores=0;
            for (int valor : valores) {
            somatorioValores += valor;
        }
            return somatorioValores/valores.length;
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public float mediaPonderada( int[] pesos) {
        try{
            float somatorioPesos=0;
            float somatorioValores=0;

            for (int i = 0; i < valores.length; i++) {
                somatorioPesos += pesos[i];
                somatorioValores += valores[i] * pesos[i];
            }
            return somatorioValores/somatorioPesos;
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public float varianciaPopulacao() {
        try{
            float media=0;

            for (int valore : valores) {
                media += Math.pow((valore - media()), 2);
            }
            return media/valores.length;
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public float varianciaAmostra() {
        try{
            float media=0;

            for (int valore : valores) {
                media += Math.pow((valore - media()), 2);
            }
            return media/(valores.length-1);
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public int desvioPadraoPopulacao() {
        try{
           return (int) Math.pow(varianciaPopulacao(), 0.5);
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public int desvioPadraoAmostra() {
         try {
             return (int) Math.pow(varianciaAmostra(), 0.5);
         }catch (Exception e) {
             System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
         }
        return -1;
    }

    public int escala() {
        try {
            Arrays.sort(valores);
            return valores[valores.length - 1] - valores[0];
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public int mediana() {
        try {
            int valorCentralDireita = valores[valores.length / 2];
            int valorCentralEsquerda = valores[(valores.length - 1) / 2];
            if (valores.length % 2 == 0) {
                System.out.println(valorCentralDireita + " " + valorCentralEsquerda);
                return (valorCentralDireita + valorCentralEsquerda) / 2;
            }
            return valores[valores.length / 2];
        }catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public ArrayList<Integer> moda() {
        try{
            Map<Integer, Integer> valores = new HashMap<>();
            ArrayList<Integer> moda = new ArrayList<>();
            int valorMaximo=0;

            for(int valor: this.valores) {
                Integer quantidade = valores.get(valor);

                if(quantidade == null){ quantidade=1; }else{ quantidade++; }

               valores.put(valor, quantidade);
                if(quantidade > valorMaximo){
                    valorMaximo = quantidade;
                }
            }
            if(valorMaximo > 1){
                for (int key: valores.keySet()){
                    if(valores.get(key) == valorMaximo){
                        moda.add(key);
                    }
                }
            }
            return moda;
        }catch (Exception e){
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
            return new ArrayList<>();
        }

    public int[] primeiroQuartil() {
        try {
            Arrays.sort(valores);
            if (getValores().length % 2 == 0) {
                return getSliceOfArray(getValores(), 0, (getValores().length / 2));
            }
            return getSliceOfArray(getValores(), 0, (getValores().length - 1) / 2);
        }catch (Exception e){
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return null;
    }

    public int[] terceiroQuartil() {
        try {
            Arrays.sort(valores);
            if (getValores().length % 2 == 0) {
                return getSliceOfArray(getValores(), getValores().length / 2, getValores().length);
            }
            return getSliceOfArray(getValores(), (getValores().length / 2) + 1, getValores().length);
        }catch (Exception e ){ System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage()); }
        return null;
    }

    public int FIQ(){
        try {
            Arrays.sort(getValores());
            int[] primeiroQuartil = primeiroQuartil();
            int[] terceiroQuartil = terceiroQuartil();

            if (valores.length % 2 == 0) {
                if (primeiroQuartil.length % 2 == 0) {
                    int[] temp = getValores();

                    setValores(terceiroQuartil);
                    int medianaTerceiroQuartil = mediana();

                    setValores(temp);
                    setValores(primeiroQuartil);
                    int medianaPrimeiroQuartil = mediana();

                    return medianaTerceiroQuartil - medianaPrimeiroQuartil;
                }
                return terceiroQuartil[(terceiroQuartil.length / 2)] - primeiroQuartil[(primeiroQuartil.length / 2)];
            }

            if (terceiroQuartil.length % 2 == 0) {
                int[] temp = getValores();

                setValores(terceiroQuartil());
                int medianaTerceiroQuartil = mediana();

                setValores(temp);
                setValores(primeiroQuartil());
                int medianaPrimeiroQuartil = mediana();

                return medianaTerceiroQuartil - medianaPrimeiroQuartil;
            }
            return terceiroQuartil[terceiroQuartil.length / 2] - primeiroQuartil[primeiroQuartil.length / 2];
        }catch (Exception e){
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    public void detectarOutlierFIQ(){
        try {
            int fiq = FIQ();
            int[] q1 = primeiroQuartil();
            int[] q3 = terceiroQuartil();

            int outlierQ1 = 0, outlierQ3 = 0;
            int[] temp = getValores();

            setValores(primeiroQuartil());
            int medianaQ1 = mediana();

            for (int valor : q1) {
                if (valor < medianaQ1 - (1.5 * fiq)) {
                    outlierQ1++;
                }
            }
            System.out.println("Quantidade de outliers primeiro quartil: " + outlierQ1);

            setValores(temp);
            int medianaQ3 = mediana();
            for (int valor : q3) {
                if (valor > medianaQ3 + (1.5 * fiq)) {
                    outlierQ3++;
                }
            }
            System.out.println("Quantidade de outliers terceiro quartil: " + outlierQ3);
        }catch (Exception e ){
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
    }

    public float desvioAbsolutoMedio() {
        try {
            float media = media();
            float resultado = 0;

            for (int valor : valores) {
                resultado += Math.abs(valor - media);
            }
            return resultado/valores.length;
        } catch (Exception e) {
            System.out.println("Não foi possível realizar a operação verifique se foi inserido os valores \nErro: " + e.getMessage());
        }
        return -1;
    }

    //Em quantos desvio padrao o valor está distante da média
    public double desvioPadraoDistanteMedia(float valor){
        return (valor-media())/ desvioPadraoPopulacao();
    }


    //Setters and Getters
    public int[] getValores() {
        return valores;
    }

    public void setValores(int[] valores) {
        this.valores = valores;
    }
}
