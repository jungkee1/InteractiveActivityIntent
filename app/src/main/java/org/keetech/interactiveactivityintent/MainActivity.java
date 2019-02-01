package org.keetech.interactiveactivityintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1 = findViewById(R.id.edtNum1);
                EditText edtNum2 = findViewById(R.id.editNum2);
                RadioGroup rg = findViewById(R.id.rg);
                int calculation = rg.getCheckedRadioButtonId();
                RadioButton checkedRB = findViewById(calculation);
                String checkedCal = checkedRB.getText().toString();


                Intent intent = new Intent(MainActivity.this,second.class); // MainActivity = getApplicationContext()
                intent.putExtra("num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("num2",Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("calculation",checkedCal);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            int value = data.getIntExtra("value",0);
            String error = data.getStringExtra("error");
            if(error  != null){     //String 받음
                Toast.makeText(getApplicationContext(),"result:" + error, Toast.LENGTH_SHORT).show();
            }else{  //error가 null로 넘어오면 error이 없으니깐 정상 계산
                Toast.makeText(getApplicationContext(),"result:" + value, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
