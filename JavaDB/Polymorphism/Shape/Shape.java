package Shape;

public abstract class Shape {
    protected Double perimeter;
    protected Double area;

    protected Shape(){
        this.perimeter = calculatePerimeter();
        this.area = calculateArea();
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();
}
