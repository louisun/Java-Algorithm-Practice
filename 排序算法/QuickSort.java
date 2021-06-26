public class QuickSort {
  // 递归（二分）
  static void quickSort(int a[], int low, int high) {
    if (low < high) {
      int pivotPos = partition(a, low, high);
      quickSort(a, low, pivotPos - 1);
      quickSort(a, pivotPos + 1, high);
    }
  }

  // 根据 pivot 分成左右两份，找出 pivot 下标
  private static int partition(int a[], int low, int high) {
    int pivot = a[low];
    while (low < high) {
      while (low < high && a[high] >= pivot) high--;
      a[low] = a[high];
      while (low < high && a[low] <= pivot) low++;
      a[high] = a[low];
    }
    a[low] = pivot;
    return low;
  }

  static void printResult(int a[]) {

    boolean flag = true;
    for (int i = 0; i < 100; i++) {
      if (a[i] != i) {
        flag = false;
        break;
      }
    }
    if (flag) {
      System.out.println("==== 排序成功 ====");
      for (int i : a) {
        System.out.printf("%d ", i);
      }
      System.out.println("\n==== 排序成功 ====");
    } else {
      System.out.println("==== 排序失败 ====");
      for (int i : a) {
        System.out.printf("%d ", i);
      }
      System.out.println("\n==== 排序失败 ====");
    }
  }

  public static void main(String[] args) {
    int[] a = {
      86, 25, 49, 61, 36, 6, 22, 38, 46, 30, 72, 29, 89, 47, 51, 35, 20, 56, 26, 94, 62, 63, 2, 33,
      8, 60, 12, 5, 68, 57, 64, 42, 69, 75, 0, 21, 11, 79, 95, 18, 14, 98, 23, 27, 70, 65, 45, 24,
      71, 44, 50, 15, 74, 9, 31, 67, 77, 37, 54, 93, 87, 84, 85, 66, 40, 81, 1, 90, 92, 43, 3, 7,
      28, 73, 53, 59, 48, 80, 97, 41, 4, 99, 19, 55, 88, 96, 82, 39, 78, 83, 34, 58, 91, 10, 17, 52,
      76, 32, 16, 13
    };
    quickSort(a, 0, a.length - 1);
    printResult(a);
  }
}
