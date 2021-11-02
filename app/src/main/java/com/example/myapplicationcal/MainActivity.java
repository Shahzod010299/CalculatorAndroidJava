package com.example.myapplicationcal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView tvInput, tvOutput;
    Button btnClear,btnLeftB,btnRightB, btnDivide,
            btn1, btn2, btn3, btn4, btn5, btn6, btn7,
            btn8, btn9, btn0, btn00,btnMultiply,
            btnMinus, btnPlus, btnDot, btnEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportBar();
        getViews();
        btnClick();

    }

    private void supportBar() {
        Window windows = this.getWindow();

        // tep qism
        windows.setStatusBarColor(ContextCompat.getColor(this,R.color.purple_700));

        // past qism
        windows.setNavigationBarColor(ContextCompat.getColor(this,R.color.purple_700));
    }

    private void btnClick() {
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"00");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,".");
            }
        });
        btnLeftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(true,"(");
            }
        });
        btnRightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(true,")");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"-");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"+");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"/");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnClick(false,"*");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });


    }

    private void calculate() {
        try {
            Expression input =new  ExpressionBuilder(tvInput.getText().toString().trim()).build();
            double output =input.evaluate();

            tvOutput.setText(String.valueOf(output));

        }catch (Exception e){
            Log.d("DDDSSS",e.getMessage());
        }

    }

    // clear btn bosilganda
    private void clear() {
        tvInput.setText("");
        tvOutput.setText("");
    }

    // btn bosilganda ulab ketish
    private void appendOnClick(Boolean click, String string) {
        if (click){
            tvOutput.setText("");
            tvInput.append(string);
        }else {
            tvInput.append(tvOutput.getText());
            tvInput.append(string);
            tvOutput.setText("");
        }
    }

    private void getViews() {
        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btn00 = findViewById(R.id.btn00);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot = findViewById(R.id.btnDot);

        btnClear = findViewById(R.id.btnClear);
        btnLeftB = findViewById(R.id.btnLeftB);
        btnRightB = findViewById(R.id.btnRightB);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);


    }
}