package Shape;

public class Rectangle  extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.perimeter != null){
            return  super.perimeter;
        }
        return super.perimeter = 2 * this.height + 2 * this.width;
    }

    @Override
    public Double calculateArea() {
        if (super.area != null){
            return super.area;
        }
         return super.area = this.height * this.width;
    }
}
