package racingcar.Model;

public class racingCar {
    private String name;
    private int position;

    public racingCar(String name) {
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
}
