package TrafficLights;

public class TrafficLights {
    private Lights light;

    public TrafficLights(Lights light){
        this.light = light;
    }
    public Lights getLights(){
        return this.light;
    }
    public void update(){
        switch (light){
            case RED:
                this.light = Lights.GREEN;
                break;
            case GREEN:
                    this.light = Lights.YELLOW;
            break;
            case YELLOW:
                this.light = Lights.RED;
                break;
        }
    }
}
