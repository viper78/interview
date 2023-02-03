package blind75;

import java.util.Arrays;

public class MaxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        int currentUnits = 0;
        int boxCount = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int box = boxTypes[i][0];
            int units = boxTypes[i][1];

            boxCount += box;
            currentUnits += (box * units);

            while (boxCount > truckSize) {
                boxCount--;
                currentUnits -= units;
            }
        }

        return currentUnits;
    }
}
