/**
 * Input array:
 * [3, 7, 8, 9, 9, 9, 10, 10, 14, 14]
 * Output array:
 * [3 7 8 9 10 14]
 */
public class InplaceDuplicatesRemover {

    public int[] removeDuplicates(int[] arr) {

        int i, j;
        for (i = 0; i < arr.length; i++) {
            //1. If adjacent two elements are not equal, skip.
            if (i + 1 < arr.length && arr[i] != arr[i + 1]) {
                continue;
            }
            //2. If -1 skip.
            if (arr[i] == -1) {
                continue;
            }

            //3. Move j till the point where there are no duplicates.
            for (j = i + 1; j < arr.length && arr[i] == arr[j]; j++) {
            }

            //4. From left till end of array, shift left.
            int left = i + 1;
            int right = j;

            while (left < arr.length) {
                if (right >= arr.length) {
                    arr[left] = -1; //We don't have anymore data to overwrite. Therefore put -1.
                } else {
                    arr[left] = arr[right]; //Overwrite data.
                    right++;
                }
                left++;
            }
        }

        return arr;
    }
}
