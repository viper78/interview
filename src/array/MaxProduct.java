package array;

public class MaxProduct {

    public static void main(String[] args) {
        int arr[] = {-8, -6, -3, 6, 7, 0};
        int n = arr.length;
        maxProduct(arr, n);

    }

    static void maxProduct(int arr[], int n) {
        if (n < 2)
        {
            System.out.println("No pairs exists");
            return;
        }

        if (n == 2)
        {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }

        // Iniitialize maximum and second maximum
        int posa = 0,
                posb = 0;

        // Iniitialize minimum and second minimum
        int nega = 0,
                negb = 0;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            // Update maximum and second maximum
            // if needed
            if (arr[i] > posa) {
                posb = posa;
                posa = arr[i];
            }
            else if (arr[i] > posb)
                posb = arr[i];

            // Update minimum and second minimum
            // if needed
            if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(nega)) {
                negb = nega;
                nega = arr[i];
            }
            else if(arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negb))
                negb = arr[i];
        }

        System.out.println((float) nega/posb);
        System.out.println((float)posa/negb);

        if (Math.abs((float)nega/posb) > Math.abs((float)posa/negb)) {
            System.out.println("Max product pair is {"
                    + nega + ", " + negb + "}");
        } else {
            System.out.println("Max product pair is {"
                             + posa + ", " + posb + "}");
        }

        /*if (nega * negb > posa * posb)
            System.out.println("Max product pair is {"
                    + nega + ", " + negb + "}");
        else
            System.out.println("Max product pair is {"
                    + posa + ", " + posb + "}");
                    */
    }
}
