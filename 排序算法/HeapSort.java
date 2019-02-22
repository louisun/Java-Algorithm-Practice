
public class HeapSort{
    static void heapSort(int a[]){
        // 建大根堆
        buildMaxHeap(a);

        for(int i = a.length-1; i > 0; i--){
            // 将「最后」一个元素和第一个元素交换
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            // 每次调整，长度-1
            AdjustDown(a, 1, i);
        }

    }

    private static void buildMaxHeap(int a[]){
        // 注意：堆排序要求序号从1开始，因此数组实际下标为 i-1
        for(int i = a.length / 2; i > 0; i--){
            // 从序号 i 开始对树往下调整
            AdjustDown(a, i, a.length);
        }

    }

    private static void AdjustDown(int a[], int k, int len){
        int tmp = a[k-1];
        // 从 k 开始，一直往下调整
        for(int i = 2*k; i <= len; i*=2){
            // 第 i 个节点 是第k个节点左孩子，第 i+1 是第 k 个节点右孩子
            if(i < len && a[i-1] < a[i]) i++;

            if(tmp >= a[i-1]) break; // 满足大根堆条件
            else{
                // k 的位置交给其孩子节点，k 到其孩子位置，继续向下调整
                a[k-1] = a[i-1];
                k = i;
            }
        }
        // 原来第 k 个节点放到最终属于他的位置
        a[k-1] = tmp;
    }

    static void printResult(int a[]){

        boolean flag = true;
        for(int i = 0; i < 100; i++){
            if(a[i] != i){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("==== 排序成功 ====");
            for(int i : a){
                System.out.printf("%d ", i);
            }
            System.out.println("\n==== 排序成功 ====");
        }
        else{
            System.out.println("==== 排序失败 ====");
            for(int i : a){
                System.out.printf("%d ", i);
            }
            System.out.println("\n==== 排序失败 ====");
        }

    }
    public static void main(String[] args) {
        int[] a = {86, 25, 49, 61, 36,  6, 22, 38, 46, 30, 72, 29, 89, 47, 51, 35, 20,
            56, 26, 94, 62, 63,  2, 33,  8, 60, 12,  5, 68, 57, 64, 42, 69, 75,
             0, 21, 11, 79, 95, 18, 14, 98, 23, 27, 70, 65, 45, 24, 71, 44, 50,
            15, 74,  9, 31, 67, 77, 37, 54, 93, 87, 84, 85, 66, 40, 81,  1, 90,
            92, 43,  3,  7, 28, 73, 53, 59, 48, 80, 97, 41,  4, 99, 19, 55, 88,
            96, 82, 39, 78, 83, 34, 58, 91, 10, 17, 52, 76, 32, 16, 13};
        heapSort(a);
        printResult(a);
    }
}