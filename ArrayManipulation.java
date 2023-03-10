public class ArrayManipulation {

    public static int sum(int arr[]) {
        // returns the sum of all values in the array
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }

    public static boolean isin(int num, int arr[]) {
        // check if the number (int num) is in the array using a simple linear search
        for (int i: arr) {
            if (num == i) return true;
        }
        return false;
    }

    public static int[] remove(int num, int arr[]) {
        // removes an element in the array that is equivalent to num
        // if there are duplicate values in the array, this will remove only the first one

        int[] newarr = new int[arr.length - 1];
        
        try {
            // find the index in which the array's element is equivalent to num
            int equiv_i = arr.length;
            for (int i = (arr.length-1); i >= 0; i--) {
                if (num == arr[i]) {
                    equiv_i = i;
                }
            }

            // once index is found, copy the values from arr to newarr
            // excluding the value from that index
            int j = 0;
            for (int i=0; i < arr.length; i++) {
                if (i != equiv_i) {
                    newarr[j] = arr[i];
                    j++;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: array does not contain the element that you are trying to remove");
            return arr;
        }

        return newarr;
    }
}