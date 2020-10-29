package review.serializable.passdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    //Define UI variable
    TextView empName;
    TextView payRate;
    TextView hoursWorked;
    TextView rating;
    TextView salary;
    TextView tax;
    TextView netSalary;

    //define variable that get to screen 1
    double payOfRate;
    double hoursOfWorked;
    int performanceRate;
    double grossSalary;
    double incomeTax;
    double netIncome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        //get UI components
        empName=findViewById(R.id.empName);
        payRate=findViewById(R.id.payRate);
        hoursWorked=findViewById(R.id.hoursWorked);
        rating=findViewById(R.id.performanceLevel);
        salary=findViewById(R.id.grossSalary);
        tax=findViewById(R.id.incomeTax);
        netSalary=findViewById(R.id.netIncome);

        //get to value of employee object from screen 1
        Intent intent=getIntent();
        Employee emp= (Employee) intent.getSerializableExtra("employee");

        //get to value for calculate income
        payOfRate=emp.getRateOfPay();
        hoursOfWorked=emp.getHoursWorked();
        performanceRate=emp.getPerformanceLevel();

        //call method for calculate gross salary
        grossSalary=emp.calculateGrossSalary(hoursOfWorked,payOfRate,performanceRate);

        //call method for calculate tax income
        incomeTax=emp.incomeTax(grossSalary);

        //call method for calculate net income
        netIncome=emp.netSalary(grossSalary,incomeTax);

        //set to text
        empName.setText("Employee Name: "+emp.getName());
        payRate.setText("Pay of Rate: "+emp.getRateOfPay());
        hoursWorked.setText("Hours Worked is: "+emp.getHoursWorked());
        rating.setText("Performance level is: "+emp.getPerformanceLevel());
        salary.setText("Gross Salary is: "+grossSalary);
        tax.setText("Tax income is: "+incomeTax);
        netSalary.setText("Net Income is: "+netIncome);



    }
}