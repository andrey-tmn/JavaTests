public class ArrayMethods {
    //Посчитать среднее арифметическое для массива double
    public static double calcArrayAverage(double[] arr1) {
        double sum = 0;
        for (double val : arr1) {
            sum += val;
        }
        return sum / arr1.length;
    }

    // Создать массив и заполнить его случайными числами от 0 до 100
    public static int[] genArray(final int SIZE) {
        int[] arr1 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr1[i] = (int) (Math.random() * 100);
        }
        return arr1;
    }
}
