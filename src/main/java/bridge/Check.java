package bridge;

import bridge.exception.BridgeLengthOutOfRange;
import bridge.exception.NotNumeric;

import static bridge.Utility.ERROR_MESSAGE;

public class Check {
    public static boolean checkNumeric(String input){
        try{
            Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            IllegalArgumentException exception = new NotNumeric(ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }

    public static boolean checkBridgeLengthOutOfRange(int bridgeLength){
        if(!(bridgeLength>=3 && bridgeLength<=20)){
            IllegalArgumentException exception = new BridgeLengthOutOfRange(ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }


}
