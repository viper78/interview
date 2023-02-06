package codesignal;

public class ReverseInparanthesis {

    String solution(String inputString) {
        int startIndex = inputString.lastIndexOf("(");
        int endIndex = inputString.indexOf(")", startIndex);

        while(startIndex != -1) {
            String revStr = new StringBuilder(inputString.substring(startIndex + 1, endIndex)).reverse().toString();
            String beginStr = inputString.substring(0, startIndex);
            String endStr = inputString.substring(endIndex+1);

            inputString = beginStr + revStr + endStr;

            startIndex = inputString.lastIndexOf("(");
            endIndex = inputString.indexOf(")", startIndex);
        }
        return inputString;
    }

}
