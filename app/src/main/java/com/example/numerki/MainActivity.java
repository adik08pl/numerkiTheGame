package com.example.numerki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnRozrzuc;
    private final List<Button> przyciski = new ArrayList<>();
    private final Random random = new Random();
    private int losowo, wysokoscTemp, szerokoscTemp, tura = 1;
    private boolean czyRozrzycone = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnRozrzuc = findViewById(R.id.btnRozrzuc);
        dodajPrzyciski();
        int wysokosc = (int) btn5.getY();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzCzyKoniec(9);
            }
        });

        btnRozrzuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (czyRozrzycone) {
                    rozpocznij();
                    btnRozrzuc.setText("Wylosuj");
                } else {
                    losowoUluzPrzyciski();
                    btnRozrzuc.setText("Start");
                }
                czyRozrzycone = !czyRozrzycone;
            }
        });


    }

    private void dodajPrzyciski() {
        przyciski.add(btn1);
        przyciski.add(btn2);
        przyciski.add(btn3);
        przyciski.add(btn4);
        przyciski.add(btn5);
        przyciski.add(btn6);
        przyciski.add(btn7);
        przyciski.add(btn8);
        przyciski.add(btn9);
        for(int i = 0;i<9;i++) {
            przyciski.get(i).setEnabled(false);
        }
    }

    private void sprawdzCzyKoniec(int numerPrzycisku) {
        if (tura == 9) {
            Intent myActivity = new Intent(this, WinningActivity.class);
            startActivity(myActivity);
        } else if (numerPrzycisku == tura) {
            tura++;
            przyciski.get(numerPrzycisku-1).setEnabled(false);
        } else {
            Intent myActivity = new Intent(this, LossingActivity.class);
            startActivity(myActivity);
        }
    }

    private void rozpocznij() {
        tura=1;
        for (int i = 0; i < 9; i++) {
            przyciski.get(i).setEnabled(true);
            przyciski.get(i).setText("");
        }
    }

    private void losowoUluzPrzyciski() {
        for (int i = 0; i < 9; i++) {
            przyciski.get(i).setText("" + (i + 1));
            losowo = random.nextInt(9);
            wysokoscTemp = (int) przyciski.get(i).getY();
            szerokoscTemp = (int) przyciski.get(i).getX();
            przyciski.get(i).setY(przyciski.get(losowo).getY());
            przyciski.get(losowo).setY(wysokoscTemp);
            przyciski.get(i).setX(przyciski.get(losowo).getX());
            przyciski.get(losowo).setX(szerokoscTemp);
            przyciski.get(i).setEnabled(false);
        }
    }

}