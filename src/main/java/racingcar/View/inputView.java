package racingcar.View;
import camp.nextstep.edu.missionutils.Console;

public class inputView {
    public String getCarName(){
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
            String carName = Console.readLine();
            return carName;
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }

    public int getN(){
        try {
            System.out.println("시도할 횟수는 몇 회인가요?\n");
            String inputN = Console.readLine();
            int cnt = Integer.parseInt(inputN);
            if(cnt < 1){
                throw new IllegalArgumentException("n이 1이하입니다!");
            }

            return cnt;

        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
