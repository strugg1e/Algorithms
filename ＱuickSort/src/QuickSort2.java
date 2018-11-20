public class QuickSort2 {

    /**
     * 双路快速排序算法
     */
    public QuickSort2() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //对arr[l....r]部分进行快速排序
    private static void sort(Comparable[] arr, int l, int r) {

//        if (l >= r)
//            return;
        if(r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    //对arr[l....r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];
        // arr[l+1...i] <= v ; arr[j...r) >= v
        int i = l + 1,j = r;
        while(true) {
            while( i <= r && arr[i].compareTo(v) < 0) i++;
            while( j >= l + 1 && arr[j].compareTo(v) > 0) j--;
            if( i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 测试 QuickSort2
    public static void main(String[] args) {

        // Quick Sort2也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("QuickSort2", arr);
    }
}

