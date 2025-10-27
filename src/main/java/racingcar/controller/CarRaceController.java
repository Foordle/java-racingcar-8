package racingcar.controller;
import racingcar.model.RacingCar;
import racingcar.view.OutputView;
import racingcar.view.InputView;
import racingcar.service.CarRaceService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CarRaceController { // model과 view를 이어주는 곳

    public void startRace(){
        try{
            // 1. 입력 받기 및 model 객체 생성 (Controller의 책임)
            List<RacingCar> initialCars = prepareCarList(InputView.getCarNames());
            int tryCount = InputView.getN();

            // 2. Service 초기화
            CarRaceService service = new CarRaceService(initialCars);

            // 3. 게임 실행
            runGame(service, tryCount);

            // 4. 최종 결과 출력
            OutputView.finalResultOutput(service.getWinners());

        }catch (Exception e) {
            // 예상치 못한 최종 오류 처리
            throw new IllegalArgumentException(e);
        }
    }

    private List<RacingCar> prepareCarList(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] namesArray = carNamesInput.split(",");
        List<RacingCar> carList = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String name : namesArray) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) { // 이름 길이 검사 등 추가
                throw new IllegalArgumentException("이름의 길이는 1~5사이만 허용됩니다!");
            }


            if (uniqueNames.contains(trimmedName)) {
                throw new IllegalArgumentException("중복된 자동차 이름 '" + trimmedName + "'이(가) 존재합니다.");
            }
            uniqueNames.add(trimmedName);

            carList.add(new RacingCar(trimmedName));
        }
        return carList;
    }

    // 게임 실행 흐름 제어 (controller 책임)
    private void runGame(CarRaceService service, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            service.oneRace(); // Model에게 턴 실행 요청
            OutputView.raceResultOutput(service.getCars()); // View에게 상태 출력 요청
        }
    }

}
