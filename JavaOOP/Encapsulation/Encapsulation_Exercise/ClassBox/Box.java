package ClassBox;

public class Box {
   private double length;
   private double width;
   private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (!isGreaterThenZero(length)){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }else{
            this.length = length;
        }
    }

    public void setWidth(double width) {
        if (!isGreaterThenZero(width)){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }else{
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if (isGreaterThenZero(height)) {
            this.height = height;
        }else{
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }
    public boolean isGreaterThenZero(double val){
        return  val > 0;
    }

    public double calculateSurfaceArea(){
        return 2 * length * width + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea(){
        return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume(){
        return  this.length * this.width * this.height;
    }
}
