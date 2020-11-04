package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.findage.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btClick(View view) {
        Button btnSelected = (Button) view;

        int cellId = 0;
        switch (btnSelected.getId()){
            case R.id.btn1:
                cellId = 1;
                break;
            case R.id.btn2:
                cellId = 2;
                break;
            case R.id.btn3:
                cellId = 3;
                break;
            case R.id.btn4:
                cellId = 4;
                break;
            case R.id.btn5:
                cellId = 5;
                break;
            case R.id.btn6:
                cellId = 6;
                break;
            case R.id.btn7:
                cellId = 7;
                break;
            case R.id.btn8:
                cellId = 8;
                break;
            case R.id.btn9:
                cellId = 9;
                break;
        }
        PlayGame(cellId, btnSelected);
    }

    int ActivePlayer = 1;  //1 for 1st player 2 for 2nd player
    ArrayList<Integer> player1 = new ArrayList<Integer>(); // to hold player 1 data
    ArrayList<Integer> player2 = new ArrayList<Integer>(); // to hold player 2 data

    void PlayGame(int cellId,Button btnSelected){

        Log.d("Player:",String.valueOf(cellId));
        if(ActivePlayer == 1){
            btnSelected.setText("X");
            btnSelected.setBackgroundColor(Color.GREEN);
            player1.add(cellId);
            ActivePlayer = 2;
            AutoPlay();
        }
        else if(ActivePlayer == 2){
            btnSelected.setText("O");
            btnSelected.setBackgroundColor(Color.YELLOW);
            player2.add(cellId);
            ActivePlayer = 1;
        }
        btnSelected.setEnabled(false);
        checkWinner();
    }

    void checkWinner(){
        int winner = -1;

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2;
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2;
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2;
        }

        //column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2;
        }

        //column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1;
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2;
        }

        //column 1
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2;
        }

        //cross 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2;
        }

        //cross 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2;
        }

        if( winner !=-1){
            //we have winner
            if(winner == 1){
                Toast.makeText(MainActivity.this,"Player 1 wins!!!",Toast.LENGTH_SHORT).show();
                
            }
            if(winner == 2){
                Toast.makeText(MainActivity.this,"Player 2 wins!!!",Toast.LENGTH_SHORT).show();

            }
        }
    }

    void AutoPlay(){
        ArrayList<Integer> EmptyCells = new ArrayList<Integer>(); //all unselected cells
        //find empty cells
        for(int cid=1; cid<10; cid++){
            if(!(player1.contains(cid) || player2.contains(cid))){
                EmptyCells.add(cid);
            }
        }
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size() - 0) + 0; //if size = 3 , select (0,1,2)
        int cellId = EmptyCells.get(RandIndex);

        Button btnSelected;
        switch (cellId) {

            case 1:
                btnSelected = (Button) findViewById(R.id.btn1);
                break;
            case 2:
                btnSelected = (Button) findViewById(R.id.btn2);
                break;
            case 3:
                btnSelected = (Button) findViewById(R.id.btn3);
                break;
            case 4:
                btnSelected = (Button) findViewById(R.id.btn4);
                break;
            case 5:
                btnSelected = (Button) findViewById(R.id.btn5);
                break;
            case 6:
                btnSelected = (Button) findViewById(R.id.btn6);
                break;
            case 7:
                btnSelected = (Button) findViewById(R.id.btn7);
                break;
            case 8:
                btnSelected = (Button) findViewById(R.id.btn8);
                break;
            case 9:
                btnSelected = (Button) findViewById(R.id.btn9);
                break;
            default:
                btnSelected = (Button) findViewById(R.id.btn1);
                break;
        }

        PlayGame(cellId, btnSelected);
    }
}