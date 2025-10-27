package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceService {
    private List<RacingCar> carList;
    private  static int ADVANCING_CONDITIONS = 4;

    public CarRaceService(List<RacingCar> carList) {
        this.carList = carList;
    }
    public void oneRace() {
        for(RacingCar car: carList){
            int randomN = Randoms.pickNumberInRange(0, 9);
            if(randomN >= ADVANCING_CONDITIONS){
                car.moveCar();
            }
        }
    }

    public List<RacingCar> getCars() {
        return carList;
    }

    public String getWinners(){
        if(carList.isEmpty()){
            return new String();
        }
        int maxPosition = carList.stream()
                .mapToInt(rc -> rc.getPosition())
                .max()
                .orElse(0);

        return carList.stream()
                .filter(rc -> rc.getPosition() == maxPosition)
                .map(rc -> rc.getName())
                .collect(Collectors.joining(", ")); // 쉼표와 공백으로 구분하여 String으로 만듦
    }

}
