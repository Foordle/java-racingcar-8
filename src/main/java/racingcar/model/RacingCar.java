package racingcar.model;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    };

    public void moveCar(){
        this.position+=1;
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }
    public String getPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
