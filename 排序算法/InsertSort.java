
public class InsertSort{
    static void insertSort(int a[]){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                int key = a[i];
                int j = i-1;
                // 找到 a[i] 能插入的位置，途中元素往后移
                // 注意：j 的范围（大于等于0）
                for(; j >= 0 && key < a[j]; j--){
                    a[j+1] = a[j];
                }
                a[j+1] = key;
            }
        }
    }

    // 折半（二分）插入排序就是二分查找范围
    static void insertBinarySort(int a[]){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                int key = a[i];

                int low = 0, high = i-1;

                /** 
                 * 注意二分查找   区间要能够缩小，避免死循环
                 * 之前是 while(low < high)  , high = mid+1, low=mid
                 * 由于 mid 可能等于 low，区间范围可能不变
                 */

                // 二分查找范围 0 ~ i-1（找第一个比 key 小的值）
                while(low <= high){
                    int mid = (low + high) / 2 ;
                    // a[mid] 应该靠近比 key 小的部分
                    if(key < a[mid]) high = mid - 1;
                    else low = mid+1;
                }

                // low = high 就是那个位置，从那开始到 i-1，都后移
                for(int j = i-1; j >= high+1; j--){
                    a[j+1] = a[j];
                }
                a[high + 1] = key;
            }
        }
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
            96, 82, 39, 78, 83, 34, 58, 91, 10, 17, 52, 76, 32, 16, 13};;
        insertSort(a);
        printResult(a);
    }
}