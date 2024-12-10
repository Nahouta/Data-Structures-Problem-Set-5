public class Problem3 {

    public static boolean isHeap(int[] arr) {
        if (arr == null) {
            return false;
        }
    
        return isHeapTree(arr, 0);
    }
    
    private static boolean isHeapTree(int[] arr, int i) {

        boolean isLeftHeap = false; //Checks if the left child subtree is a Heap
        boolean isRightHeap = false; //Checks if the right child subtree is a Heap
        boolean isThisHeap = false; //Checks if the current subtree is a Heap

        if (arr.length == 0) {  //Checks the length of the array. An empty array is not a Heap
            return false;
        }
        if (2*i + 2 <= arr.length - 1) { //The node has 02 children

            if ( (arr[i] >= arr[2*i +1 ]) && (arr[i] >= arr[2*i + 2]) ) {
                isThisHeap = true;
            }
            else { //No need to check any further because the current table is a Heap
                return false;
            }
            isLeftHeap = isHeapTree(arr, 2*i + 1);
            isRightHeap = isHeapTree(arr, 2*i + 2);

            //All three conditions need to be true in order for the current subtree to be a Heap
            if (isLeftHeap && isRightHeap && isThisHeap) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (2*i + 1 <= arr.length - 1) {   //The node has one child, which is necessarily the last item (otherwise the tree wouldn't be complete)
            if (arr[i] >= arr[2*i+1]) {
                return true;
            }
            else {
                return false;
            }
        }
        else {  //The node has no children, and is thus a Heap
            return true;
        }
    }

    public static void main (String [] args) {
        System.out.println("Helllo World");
        int[] arr1 = {48, 25, 16, 10, 18, 36};
        System.out.println(isHeap(arr1));

        int[] arr2 = {65, 46, 55, 18, 32, 30, 25, 10, 0};
        System.out.println(isHeap(arr2));

        int[] arr3 = {};
        System.out.println(isHeap(arr3));

        int[] arr4 = {10};
        System.out.println(isHeap(arr4));

    }
}