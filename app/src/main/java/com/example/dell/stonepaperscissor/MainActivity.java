package com.example.dell.stonepaperscissor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_stone, b_paper, b_scissor, b_restart, b_exit;
    TextView tv_playerChoice, tv_cpuChoice, tv_scoreCard, tv_result;
    ImageView iv_playerChoice, iv_cpuChoice;
    int playerScore = 0, cpuScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_stone = (Button) findViewById(R.id.b_stone);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);
        b_restart = (Button) findViewById(R.id.b_restart);
        b_exit = (Button) findViewById(R.id.b_exit);
        tv_scoreCard = (TextView) findViewById(R.id.tv_scoreCard);
        tv_playerChoice = (TextView) findViewById(R.id.tv_playerChoice);
        iv_playerChoice = (ImageView) findViewById(R.id.iv_playerChoice);
        tv_result = (TextView)findViewById(R.id.tv_result);
        iv_cpuChoice = (ImageView) findViewById(R.id.iv_cpuChoice);
        b_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_playerChoice.setImageResource(R.drawable.stone);
                turn("stone");

            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_playerChoice.setImageResource(R.drawable.paper);
                turn("paper");

            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_playerChoice.setImageResource(R.drawable.sic);
                turn("scissor");

            }
        });

        b_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });

    }

    void turn(String playerChoice) {

        Random r = new Random();
        int cpu_Choice_no;
        String cpuChoice = "";
        String message = "";
        cpu_Choice_no = r.nextInt(3) + 1;
        if (cpu_Choice_no == 1) {
            cpuChoice = "stone";
            iv_cpuChoice.setImageResource(R.drawable.stone);
        } else if (cpu_Choice_no == 2) {
            cpuChoice = "paper";
            iv_cpuChoice.setImageResource(R.drawable.paper);
        } else if (cpu_Choice_no == 3) {
            cpuChoice = "scissor";
            iv_cpuChoice.setImageResource(R.drawable.sic);
        }

        if (cpuChoice == playerChoice) {
            message = "Draw!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "stone" && playerChoice == "paper") {
            playerScore++;
            message = "Paper smashes stone! Your Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "stone" && playerChoice == "scissor") {
            cpuScore++;
            message = "Stone breaks scissor! CPU's Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "paper" && playerChoice == "stone") {
            cpuScore++;
            message = "Paper smashes stone! CPU's Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "paper" && playerChoice == "scissor") {
            playerScore++;
            message = "Scissor cuts paper! Your Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "scissor" && playerChoice == "paper") {
            cpuScore++;
            message = "Scissor cuts paper! CPU's Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }
        if (cpuChoice == "scissor" && playerChoice == "stone") {
            playerScore++;
            message = "Stone breaks scissor! Your Point!";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tv_scoreCard.setText("Score : YOU " + playerScore + " | CPU " + cpuScore);
        }

        if(playerScore>=10){
            tv_result.setText("Congrats! You Win!");
            b_stone.setEnabled(false);
            b_scissor.setEnabled(false);
            b_paper.setEnabled(false);
        }
        if(cpuScore>=10){
            tv_result.setText("Sorry! CPU Win!");
            b_stone.setEnabled(false);
            b_scissor.setEnabled(false);
            b_paper.setEnabled(false);
        }

    }


}
