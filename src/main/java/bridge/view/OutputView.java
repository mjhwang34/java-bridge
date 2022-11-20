package bridge.view;

import bridge.Move;

import java.util.List;

import static bridge.Utility.MOVE_NAME;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String finalResultMessage = "최종 게임 결과";
    public static final String gameResultMessage = "게임 성공 여부: ";
    public static final String totalTriesMessage = "총 시도한 횟수: ";

    public static final String mapStart = "[ ";
    public static final String mapEnd = " ]";
    public static final String mapSeparator = " | ";
    public static final String mapRight = "O";
    public static final String mapWrong = "X";
    public static final String mapBlank = " ";
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> totalMove, List <String> bridge) {
        for(int i=Move.UP.getNum(); i>=Move.DOWN.getNum(); i--){
            String _curMove = MOVE_NAME.get(i);
            String curMove = Move.valueOf(_curMove).getMoveType();
            String mapResult = createMapByLine(totalMove, bridge, curMove);
            printMessage(mapResult);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public String createMapByLine(List<String> totalMove, List <String> bridge, String type){
        String mapResult = "";
        mapResult = mapResult+mapStart;
        for(int i=0; i<totalMove.size(); i++){
            String selectedCurMove = totalMove.get(i);
            String bridgeCurMove = bridge.get(i);
            if(!selectedCurMove.equals(type))
                mapResult = mapResult+mapBlank;
            if(selectedCurMove.equals(type) && selectedCurMove.equals(bridgeCurMove))
                mapResult = mapResult+mapRight;
            if(selectedCurMove.equals(type) && !selectedCurMove.equals(bridgeCurMove))
                mapResult = mapResult+mapWrong;
            if(i!=(totalMove.size()-1))
                mapResult = mapResult+mapSeparator;
        }
        mapResult = mapResult+mapEnd;
        return mapResult;
    }
}
