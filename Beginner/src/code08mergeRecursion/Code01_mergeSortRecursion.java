package code08mergeRecursion;


//递归排序 递归方式
public class Code01_mergeSortRecursion {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr,0,arr.length-1);
    }


    private static void process(int[] arr,int L,int R) {
        if (L==R) {
            return;
        }
        //变有序
        int mid = (L+R)/2;
        process(arr,L,mid-1);
        process(arr,mid+1,R);

        //数组变有序了之后，再直接进行下一步进行merger
        merger(arr,L,mid,R);
    }

    private static void merger(int[] arr, int l, int mid, int r) {
        int [] help = new int[r-l+1];
        int i = 0;
        int left =0;
        int right = mid+1;

        //如果数组的左右两边都有值
        while (left <= l && right <= mid) {
            help[i++]= help[left]<help[right]?arr[left++]:arr[right++];
        }

        //如果只剩下数组的左边
        while (left <= l) {
            help[i++]= arr[left++];
        }

        //如果只剩下数组的右边
        while (right <= r) {
            help[i++]= arr[right++];
        }

        //将help数组移动进去
        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }

    }


}
