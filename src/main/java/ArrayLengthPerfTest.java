import java.util.Arrays;

/*
    Проверяем, какой вариант определения длины массива в цикле быстрее:

    --
    for (int i = 0; i < arr1.length; i++)

    --
    int len = arr1.length;
    for (int i = 0; i < len; i++)

    --
    final int len = arr1.length;
    for (int i = 0; i < len; i++)

 */

public class ArrayLengthPerfTest {
    // Мы будем создавать целочисленный массив длиной TEST_ARRAYS_SIZE,
    // заполнять его случайными числами и сортировать
    private static final int TEST_ARRAYS_SIZE = 30000;
    // Сколько раз запускать каждый тест
    private static final int TEST_TRY_CNT = 100;

    public static void main(String[] args) {
        String msg;
        // Запускаем каждый вариант по TEST_TRY_CNT раз, считаем среднее арифметическое
        double[] execTimes3 = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes3[i] = perfTestWithConst();
        }
        msg = "Вариант с константой отработывает за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes3));

        double[] execTimes2 = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes2[i] = perfTestWithVar();
        }
        msg = "Вариант с переменной отработывает за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes2));

        double[] execTimes = new double[TEST_TRY_CNT];
        for (int i = 0; i < TEST_TRY_CNT; i++) {
            execTimes[i] = perfTestWithoutVar();
        }
        msg = "Вариант с arr1.length отработывает за: %.2f мс.%n";
        System.out.printf(msg, ArrayMethods.calcArrayAverage(execTimes));
    }

    // Без переменной
    private static double perfTestWithoutVar() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Сортируем массив
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] < arr1[j]) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }

        // Возвращаем итоговое время выполнения
        return System.currentTimeMillis() - m;
    }

    // С переменной
    private static double perfTestWithVar() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Сортируем массив
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr1[i] < arr1[j]) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }

        // Возвращаем итоговое время выполнения
        return System.currentTimeMillis() - m;
    }

    // С константой
    private static double perfTestWithConst() {
        int[] arr1 = ArrayMethods.genArray(TEST_ARRAYS_SIZE);

        // Засекаем время
        long m = System.currentTimeMillis();

        // Сортируем массив
        final int len = arr1.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr1[i] < arr1[j]) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }

        // Возвращаем итоговое время выполнения
        return System.currentTimeMillis() - m;
    }
}
