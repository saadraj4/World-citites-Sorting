public class QuickSort {
    static int comparisonCount;
    public static void quickSort(City[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
// partitioning function to find the pivot element
    private static int partition(City[] array, int low, int high) {
        double pivot = array[high].getLatitude();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisonCount++;
            if (array[j].getLatitude() < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(City[] array, int i, int j) {
        City temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}