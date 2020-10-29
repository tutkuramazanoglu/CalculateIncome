package review.serializable.passdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText workedHours;
    private EditText payRate;
    private RatingBar performanceRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.edName);
        workedHours=findViewById(R.id.edNumberHours);
        payRate=findViewById(R.id.edPayRate);
        performanceRate=findViewById(R.id.ratingBar);
    }
    public void calculateGrossSalary(View view){
        String empName=name.getText().toString();
        double hoursOfWorked=Double.parseDouble(workedHours.getText().toString());
        double rateOfPay=Double.parseDouble(payRate.getText().toString());
        //get to value of selected from the rating bar
        int levelOfPerformance=(int)performanceRate.getRating();

        //create employee object for sending screen 2
        Employee emp=new Employee(empName,rateOfPay,hoursOfWorked,levelOfPerformance);

        Intent intent=new Intent(this,Screen2.class);
        intent.putExtra("employee",emp);
        startActivity(intent);
    }
}