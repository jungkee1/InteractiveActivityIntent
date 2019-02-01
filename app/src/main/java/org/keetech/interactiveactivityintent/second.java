package org.keetech.interactiveactivityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class second extends AppCompatActivity {
    int value;
    String error; //객체를 선언 해놓고 밑에서 if에 안걸려서 error에 값이 할당 안되면 그것은 null 이다 ""이 아님

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("second activity");

        Intent inIntent = getIntent();
        String cal = inIntent.getStringExtra("calculation");
        int num1 = inIntent.getIntExtra("num1",0);
        int num2 = inIntent.getIntExtra("num2",0);


        switch (cal){
            Log.i("gdgd","하이루");
            case "add" : value = num1+num2;break;
            case "subtract" : value = num1-num2;break;
            case "multiply" : value= num1*num2;break;
            case "divide" :
                if(num1 == 0){ //case 안에서도 if문 쓸 수 있음 0으로 나눌시에는 error 값 줌
                    error = "연산이 불가 합니다";
                }else{
                    value = num1/num2;
                }break;

        }

//        switch (cal){ 0으로 나누었을 때 에러 처리를 위해 여기는 주석함 여기는 String 개입없이 수로만 연산 했음
//            case "add" : value = inIntent.getIntExtra("num1",0) + inIntent.getIntExtra("num2",0);break;
//            case "subtract" : value = inIntent.getIntExtra("num1",0) - inIntent.getIntExtra("num2",0);break;
//            case "multiply" : value = inIntent.getIntExtra("num1",0) * inIntent.getIntExtra("num2",0);break;
//            case "divide" : value = inIntent.getIntExtra("num1",0) / inIntent.getIntExtra("num2",0);break;
//
//        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(second.this,MainActivity.class);
                outIntent.putExtra("value", value);
                outIntent.putExtra("error",error);  //String 형 전송
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });


    }
}
