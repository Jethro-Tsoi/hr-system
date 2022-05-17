public class Payment {
  private int salary;
  private int bonus;
  

  public Payment(int salary){
    salary = this.salary; 
  }


  public void addBonus( int bonus){
    this.bonus+=bonus;
  }
  
  public void addSalary(int increment){
    salary+=increment;
  }
  public void checkSalary(){
    System.out.println("Your salary is " + (salary));
  }

  public int getSalary() {
    return salary;
  }

  public void getBonus(){
    System.out.println("Your bonus is " + (bonus));
  }

  public void getMonthlyPayment(){
    System.out.println("You will receive $"+(salary+bonus));
  }

  

}

