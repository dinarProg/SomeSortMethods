/**
 * Created by Владимир on 08.02.2015.
 */
public class Main {
    public static void main(String[] arqs) {
        int[] mas = new int[12];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) Math.round(Math.random() * 100);
            System.out.print(mas[i] + " ");
        }

        int[] bubble = SortedMass.bubbleSort(mas);
        int[] select = SortedMass.selectSort(mas);
        int[] insertion = SortedMass.insertionSort(mas);
        int[] shake=SortedMass.sheycerSort(mas);
        int[] shell=SortedMass.shellSort(mas);

        consoleWriter(bubble);
        consoleWriter(select);
        consoleWriter(insertion);
        consoleWriter(shake);
        consoleWriter(shell);

    }

    //вывод отсортированных массивов на консоль
    public static void consoleWriter(int[] mass){
        System.out.println();
        for (int i=0;i<mass.length;i++) {
            System.out.print(mass[i]+" ");
        }
    }
}
