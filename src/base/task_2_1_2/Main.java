package base.task_2_1_2;

import java.util.Arrays;

// Disclaimer: this project contain code of merge-sort algorithm
// that was taken from URL: https://proglib.io/p/java-sorting-algorithms/

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(15_000, "notebook", "low-end"),
                new Product(7_500, "shaver", "mens"),
                new Product(22_000, "watch", "smart"),
                new Product(2_360, "teapot", "for kitchen"),
                new Product(7_830, "ssd-drive", "pretty fast"),
                new Product(86_305, "ultrabook", "very thin"),
                new Product(34_165, "toys tower", "+6"),
                new Product(45_800, "jacket", "from beaver"),
                new Product(5_290, "toothbrush", "electric"),
                new Product(11_630, "keyboard", "with leds"),
                new Product(15_000, "smartphone", "android"),
                new Product(8_394, "ukulele", "small guitar")
        };

        System.out.println("\nМассив до сортировки:");
        printProducts(products);
        mergeSort(products, 0, (products.length - 1));
        System.out.println("\nМассив после сортировки:");
        printProducts(products);
    }

    public static void mergeSort(Product[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    static void merge(Product[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        Product[] leftArray = new Product[lengthLeft];
        Product[] rightArray = new Product[lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex].getPrice() < rightArray[rightIndex].getPrice()) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    static void printProducts(Product[] products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
