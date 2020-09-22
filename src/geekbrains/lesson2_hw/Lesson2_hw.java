package geekbrains.lesson2_hw;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.lang.reflect.Array;
import java.util.Random;

public class Lesson2_hw {

    public static void main(String[] args) {
        System.out.println("Задание №1:");
        changeArr();
        System.out.println();

        System.out.println("Задание №2:");
        createArr();
        System.out.println();

        System.out.println("Задание №3:");
        multiplyArr();
        System.out.println();

        System.out.println("Задание №4:");
        doI0matrix();
        System.out.println();

        System.out.println("Задание №5:");
        doSearchMinMax();
        System.out.println();

        System.out.println("Задание №6:");
        int[] a = {1, 1, 1, 2, 1};
            for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
        }
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1})); // true
        int[] a2 = {2, 1, 1, 2, 1};
            for (int i = 0; i < a2.length; i++) {
        System.out.print(a2[i] + " ");
        }
        System.out.println(checkBalance(new int[]{2, 1, 1, 2, 1})); // false
        System.out.println ();

        System.out.println("Задание №7:");
        doShiftArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -3);
            System.out.println();
    }


    // Задание 1 : 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static public void changeArr() {
            System.out.println("Заданный массив:");
        int[] myArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }
            System.out.println();
            System.out.println("Массив с заменой 0<=>1:");
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] == 0) myArr[i] = 1;
            else myArr[i] = 0;
            System.out.print(myArr[i] + " ");
        }
            System.out.println();
    }

    // Задание 2: Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static public void createArr() {
        int[] myArr2 = new int[8];
        int x = 0;
        int i = 0;
        while (i < myArr2.length) {

            myArr2[i] = myArr2[i] + x;
            System.out.print(myArr2[i] + " ");

            i++;
            x = x + 3;
        }

            System.out.println();
    }

    //3 задание: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static public void multiplyArr() {
        int i;
        int[] myArr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (i = 0; i < myArr3.length; i++) {
            System.out.print(myArr3[i] + " ");
        }

            System.out.println();

        for (i = 0; i < myArr3.length; i++) {
            if (myArr3[i] < 6) {
                myArr3[i] = myArr3[i] * 2;
            }
            System.out.print(myArr3[i] + " ");
        }
            System.out.println();
            System.out.println();
        }

    //Задание 4: Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void doI0matrix() {
        int[][] matrix = new int[4][4];
        int i;
        for (i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(9);
                if ((i == j) || (i == matrix.length - 1 - j)) {
                    matrix[i][j] = 1;
                }
                System.out.print(" " + matrix[i][j] + " ");

            }
                System.out.println();
        }
                System.out.println();
                System.out.println();

    }

    //Задание 5: Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static void doSearchMinMax() {
        int i;
        int[] myArr5 = new int[8];
        int min = myArr5[0];
        int max = myArr5[0];
        for (i = 0; i < myArr5.length; i++) {
            myArr5[i] = (int) Math.round((Math.random() * 40) - 20);
            if (min > myArr5[i]) {
                min = myArr5[i];
            }
            if (max < myArr5[i]) {
                max = myArr5[i];
            }
            //Но вот так конечно было бы проще и короче =)
            //max = Math.max(max, myArr5[i]);
            //min = Math.min(min, myArr5[i]);
            //Не знаю что подразумевалось под "без помощи интернета", наверное не пользоваться тем ,чего не объясняли.
            System.out.print(myArr5[i] + " ");
        }
            System.out.println();
            System.out.println("min = " + min + "   max = " + max);
    }
        //Задание 6: ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
    static public boolean checkBalance(int[] myArr6) {
        int leftSum = 0, rightSum = 0;
        int left = 0, right = 0;

        for (int i : myArr6) {
            right += i;
        }

        for (int i = 0; i < myArr6.length; i++) {
            if (left == right) {
                return true;
            }
            left += myArr6[i];
            right -= myArr6[i];
        }
        return false;

    }

     //Задание 7: ****Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    static public void doShiftArr(int[] myArr7, int n) {
        System.out.print("Заданный массив:  ");
        for (int i : myArr7) {
            System.out.print(i + " ");
        }

        System.out.println("(n = " + n + ")");

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                //сдвигаем вправо
                int buffer = myArr7[myArr7.length - 1];
                for (int j = myArr7.length - 1; j > 0; j--) {
                    myArr7[j] = myArr7[j - 1];
                }
                myArr7[0] = buffer;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                //  сдвигаем влево
                int buffer = myArr7[0];
                for (int j = 0; j < myArr7.length - 1; j++) {
                    myArr7[j] = myArr7[j + 1];
                }
                myArr7[myArr7.length - 1] = buffer;
            }
        }

        System.out.print("После сдвига:  ");
        for (int i : myArr7) {
            System.out.print(i + " ");
        }
    }
}


















