package RawData;

public class Tires {
   private String model;
   private double pressure1;
   private int age1;
   private double pressure2;
   private int age2;
   private double pressure3;
   private int age3;
   private double pressure4;
   private int age4;

   public Tires(double pressure1, int age1, double pressure2, int age2,
                double pressure3, int age3, double pressure4, int age4) {
      this.model = model;
      this.pressure1 = pressure1;
      this.age1 = age1;
      this.pressure2 = pressure2;
      this.age2 = age2;
      this.pressure3 = pressure3;
      this.age3 = age3;
      this.pressure4 = pressure4;
      this.age4 = age4;
   }

   public boolean getPressure() {
      if (this.pressure1 < 1 || this.pressure2 < 1 || this.pressure3 < 1 || this.pressure4 < 1){
         return  true;
      }
      return false;
   }
}
