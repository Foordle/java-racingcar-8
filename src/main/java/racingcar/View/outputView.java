package racingcar.View;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.racingCar;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;

public class outputView {
    public void raceResultOutput(List<racingCar> racingCars){
        try{
            List<String> raceResult = racingCars.stream()
                    .map(rc -> rc.getName() + ":" + rc.getPosition())
                    .collect(Collectors.toList());
            String raceResult_str = String.join("\n", raceResult);
            System.out.println(raceResult_str);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }
    public void finalResultOutput(List<racingCar> cars){
        try{
            List<String> winnerNames = cars.stream()
                    .map(rc -> rc.getName()) // .map(racingCar::getName) 를 간단한 람다식으로 작성해봄
                    .collect(Collectors.toList());

            String resultNames = String.join(", ", winnerNames);
            System.out.println("최종 우승자 : "+ resultNames);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
