public class MergeSort {
    private static int[] tmp = new int[100];

    // 注意递归写法
    static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            // 对两本分别排序
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int a[], int low, int mid, int high) {
        // low 到 high 内容都复制到 辅助数组
        for (int i = low; i <= high; i++) {
            tmp[i] = a[i];
        }

        // low~mid-1, mid~high (i, j位置相互比较)，放到 a[k++]里面
        // 注意：k 的位置也应该从 low 开始
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (tmp[i] <= tmp[j]) {
                a[k++] = tmp[i++];
            } else {
                a[k++] = tmp[j++];
            }
        }

        while (i <= mid)
            a[k++] = tmp[i++];
        while (j <= mid)
            a[k++] = tmp[i++];

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
        int[] a = { 86, 25, 49, 61, 36, 6, 22, 38, 46, 30, 72, 29, 89, 47, 51, 35, 20, 56, 26, 94, 62, 63, 2, 33, 8, 60,
                12, 5, 68, 57, 64, 42, 69, 75, 0, 21, 11, 79, 95, 18, 14, 98, 23, 27, 70, 65, 45, 24, 71, 44, 50, 15,
                74, 9, 31, 67, 77, 37, 54, 93, 87, 84, 85, 66, 40, 81, 1, 90, 92, 43, 3, 7, 28, 73, 53, 59, 48, 80, 97,
                41, 4, 99, 19, 55, 88, 96, 82, 39, 78, 83, 34, 58, 91, 10, 17, 52, 76, 32, 16, 13 };
        mergeSort(a, 0, a.length - 1);
        printResult(a);
    }
}