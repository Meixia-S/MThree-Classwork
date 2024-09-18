 # Java Practice: Employee Salary Calculator                           

## Overview

In this activity, you will create a salary calculator that calculates an employee's weekly pay based on hours worked and the employee's hourly pay rate.

## Problem Statement

ABC Company’s standard work week for any of its employees is 40 hours.

Any work exceeding 40 hours is considered overtime, which is paid at twice the normal hourly rate.

Create a Java program named **EmployeeSalaryCalculator** to calculate an employee's weekly earnings, including additional overtime pay where appropriate.

The program will accept user input through the console for:

1.  *EmployeeID*
2.  *EmployeeName*
3.  Total number of working hours (*HoursWorked*)
4.  The employee's hourly rate pay rate per hour (*HourlyRate*)

Your program will then take the input, compute the relevant amounts, and print output to the console, similar to:

```nocode
================PAYSLIP==============

Employee ID       :     E-101

Employee Name     :     Sam

Hours Worked      :     36

Hourly Rate       :     1500

OverTime          :     0

OverTime Rate     :     0

OverTime Pay      :     0

Basic Pay         :     54000

Gross Salary      :     54000
```

Most of the code has already been written for this activity. Your task is to write the code that will perform the required calculations.

### Instructions

Update only the existing **EmployeeSalaryCalculator / src / main / EmployeeSalaryCalculator.java** class in the starter code provided. **Do not change the code in any other file provided.**

In the EmployeeSalaryCalculator class, find the method named SalaryCalculator. This method includes an if-else block where you will add the required calculations.

```java
   static int SalaryCalculator(int HW,int HR)
   {
   	HourlyRate = HR;
	HoursWorked = HW;
		
	/*
	All new code must be added between the commented lines below.
		YOUR CODE STARTS HERE
		YOUR CODE ENDS HERE
	Test cases execute automatically each time you commit code to GitHub.
	You must follow these rules:
		1. Do not change any code outside of the new code placeholders.
		2. Your own code must be inside the new code placeholders.
		3. Do not change existing class names, interface names, method signatures, or attributes.
		4. Follow standard Java naming conventions for all code that you write.
	*/
​
​
			if(HW <= StandardWorkingHours)
			{
				//YOUR CODE STARTS HERE


				//YOUR CODE ENDS HERE
			}
			else
			{
				//YOUR CODE STARTS HERE
 
​
				//YOUR CODE ENDS HERE
			}
			return GrossSalary;
   }
```

In the if block, add a statement that will calculate standard working hours for employees who work 40 hours or less in a given week.

In the else block, add a statement to calculate the pay for employees who work more than 40 hours in a given week.
