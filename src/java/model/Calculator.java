/*
Copyright (c) 2016 Christy Smith
Campus Box 7915, Elon University, Elon, NC 27244

Copyright (c) 2016 Evan Elkin
Campus Box 7947, Elon University, Elon, NC 27244

Copyright (c) 2016 Breslin Wiley
Campus Box 7947, Elon University, Elon, NC 27244
*/
package model;

import java.io.Serializable;

/*
  The calculator JavaBean
*/
public class Calculator implements Serializable {
  private double investmentAmount;
  private double yearlyInterestRate;
  private int numberOfYears;
  private double futureValue;
    
  public Calculator() {
    investmentAmount = 0;
    yearlyInterestRate = 0;
    numberOfYears = 0;
    futureValue = 0;
  }
    
  public Calculator(double investmentAmount, double yearlyInterestRate, 
      int numberOfYears) {
      this.investmentAmount = investmentAmount;
      this.yearlyInterestRate = yearlyInterestRate;
      this.numberOfYears = numberOfYears;
      this.futureValue = FutureValueCalculator.findFutureValue(investmentAmount, 
        yearlyInterestRate, numberOfYears);
    }
    
    public double getInvestmentAmount() {
      return investmentAmount;
    }
    
    public void setInvestmentAmount(double investmentAmount) {
      this.investmentAmount = investmentAmount;
    }
    
    public double getYearlyInterestRate() {
      return yearlyInterestRate;
    }
    
    public void setYearlyInterestRate(double yearlyInterestRate) {
      this.yearlyInterestRate = yearlyInterestRate;
    }
    
    public int getNumberOfYears() {
      return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears) {
      this.numberOfYears = numberOfYears;
    }
    
    public double getFutureValue() {
      return futureValue;
    }
    
    public void setFutureValue(double investmentAmount, double yearlyInterestRate, 
      int numberOfYears) {
      this.futureValue = FutureValueCalculator.findFutureValue(investmentAmount, 
            yearlyInterestRate, numberOfYears);
    }
    
}
