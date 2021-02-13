import java.util.stream.IntStream;

/*
    Проверяем, как быстрее посчитать сумму целочисленного массива:

    --
    Пройти его в обычном цикле for и посчитать
    --
    Пройти его в цикле for-each и посчитать
    --
    Посчитать через IntStream.of(arr1).sum();

 */

public class IntArraySumPerfTest {
    // Мы будем создавать целочисленный массив длиной TEST_ARRAYS_SIZE,
    // заполнять его случайными числами и считать сумму
    private static final int TEST_ARRAYS_SIZE = Integer.MAX_VALUE/100;
    // Сколько раз запускать каждый тест
    private static final int TEST_TRY_CNT = 50;
    // Показывать вычисленные суммы масивов
    private static final boolean SHOW_SUM = false;

    public static void main(String[] args) {
        String msg;

        // Запускаем каждый вариант по TEST_TRY_CNT раз, считаем среднее арифметическое

        double[] execTimes = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes[i] = arraySumClassic();
        }
        msg = "Вариант с обычным циклом for отработал за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes));

        double[] execTimes2 = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes2[i] = arraySumForEach();
        }
        msg = "Вариант с циклом for-each отработал за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes2));

        double[] execTimes3 = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes3[i] = arraySumIntStream();
        }
        msg = "Вариант с IntStream отработал за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes3));
    }

    // В обычном цикле for проходим массив и суммируем
    private static double arraySumClassic() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Считаем сумму всех элементов массива
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }

        double time_delta = System.currentTimeMillis() - m;

        if (SHOW_SUM)
            System.out.println("Сумма = " + sum);

        // Возвращаем итоговое время выполнения
        return time_delta;
    }

    // В цикле for-each проходим массив и суммируем
    private static double arraySumForEach() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Считаем сумму всех элементов массива
        int sum = 0;
        for (int val : arr1) {
            sum += val;
        }

        double time_delta = System.currentTimeMillis() - m;

        if (SHOW_SUM)
            System.out.println("Сумма = " + sum);

        // Возвращаем итоговое время выполнения
        return time_delta;
    }

    // Используем IntStream.of(arr1).sum()
    private static double arraySumIntStream() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Считаем сумму всех элементов массива
        int sum = IntStream.of(arr1).sum();

        double time_delta = System.currentTimeMillis() - m;

        if (SHOW_SUM)
            System.out.println("Сумма = " + sum);

        // Возвращаем итоговое время выполнения
        return time_delta;
    }
}
