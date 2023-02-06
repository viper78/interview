package codesignal;

public class GrowingPlant {
    int solution(int upSpeed, int downSpeed, int desiredHeight) {

        return Math.max(0, (int)Math.ceil((double) (desiredHeight - upSpeed)/ (upSpeed - downSpeed))) + 1;
    }

}
