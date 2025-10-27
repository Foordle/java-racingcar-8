package racingcar.view;
import racingcar.model.RacingCar;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void raceResultOutput(List<RacingCar> RacingCars){
        try{
            List<String> raceResult = RacingCars.stream()
                    .map(rc -> rc.getName() + " : " + rc.getPositionString())
                    .collect(Collectors.toList());
            String raceResult_str = String.join("\n", raceResult);
            System.out.println(raceResult_str);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }
    public static void finalResultOutput(String winners){
        try{
            System.out.println("최종 우승자 : "+ winners);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
