/**
 * Created by Владимир on 08.02.2015.
 */
public class SortedMass {
    //сортировка методом пузырька (с конца)
    public static int[] bubbleSort(int[] mass) {
        int[] resMass = mass.clone();

        for (int i = 1; i < resMass.length; i++)
            for (int j = resMass.length - 1; j >= i; j--)
                if (resMass[j - 1] > resMass[j]) {
                    int temp = resMass[j - 1];
                    resMass[j - 1] = resMass[j];
                    resMass[j] = temp;
                }

        return resMass;
    }

    //сортировка методом выбора
    public static int[] selectSort(int[] mass) {
        int[] resMass = mass.clone();

        int index = 0;//индекс минимального элемента
        int min = 0;  //сам минимальный элемент
        for (int i = 0; i < resMass.length; i++) {
            min = resMass[i]; //по умолчанию 1-й элемент минимальный
            index = i;
            //(i+1) - с увеличением i количество элементов по которым нужно пройти уменьшается
            for (int j = i + 1; j < resMass.length; j++) {
                if (resMass[j] < min) {  //>-сортировка в обратном порядке
                    index = j;
                    min = resMass[j];
                }
            }
            //обмен местами чисел если они не равны
            if (resMass[i] != resMass[index]) {
                resMass[index] = resMass[i];
                resMass[i] = min;           //i всегда указывает на 1-й элемент массива
            }
        }

        return resMass;
    }

    //сортировка методом вставки
    public static int[] insertionSort(int[] mass) {
        int[] resMass = mass.clone();

        int j, temp;
        for (int i = 0; i < resMass.length; i++) {
            temp = resMass[i];
            for (j = i - 1; j >= 0 && resMass[j] > temp; j--) {
                resMass[j + 1] = resMass[j];
            }
            resMass[j + 1] = temp;
        }

        return resMass;
    }

    //сортировка Шейкера
    public static int[] sheycerSort(int[] mass) {
        int[] resMass = mass.clone();

        int left = 1, right = resMass.length - 1; //границы прохода
        do {
            for (int i = right; i >= left; i--) { //поиск минимального элемента и запись его в начало
                if (resMass[i - 1] > resMass[i]) {
                    int temp = resMass[i];
                    resMass[i] = resMass[i - 1];
                    resMass[i - 1] = temp;
                }
            }
            left++;
            for (int i = left; i <= right; i++) { //поиск максимального элемента и запись его в конец
                if (resMass[i - 1] > resMass[i]) {
                    int temp = resMass[i];
                    resMass[i] = resMass[i - 1];
                    resMass[i - 1] = temp;
                }
            }
            right--;
        } while (left <= right);

        return resMass;
    }

    //сортировка Шелла
    public static int[] shellSort(int[] mass) {
        int[] resMass = mass.clone();

        int d = resMass.length / 2; //узнаем половину длинны массива
        while (d > 0) {
            for (int i = 0; i < (resMass.length - d); i++) {
                int j = i;
                while ((j >= 0) && (resMass[j] > resMass[j + d])) {
                    int temp = resMass[j];
                    resMass[j] = resMass[j + d];
                    resMass[j + d] = temp;
                    j--;
                }
            }
            d = d / 2;
        }

        return resMass;
    }

    //надо доработать
    public static int[] quickSort(int[] mass, int start, int end) {
        int[] resMass = mass.clone();
        if (start >= end) return resMass;
        int i = start;
        int j = end;

        int op = i - (i - j) / 2;

        while (i < j) {
            while ((i < op) && (resMass[i] <= resMass[op])) i++;
            while ((j > op) && (resMass[j] >= resMass[op])) j--;

            if (i < j) {
                int temp = mass[i];
                mass[i] = mass[j];
                mass[j] = temp;

                if (i == op) op = j;
                else if (j == op) op = i;
            }
        }

        quickSort(resMass, start, op);
        quickSort(resMass, op + 1, end);

        return resMass;
    }
}
