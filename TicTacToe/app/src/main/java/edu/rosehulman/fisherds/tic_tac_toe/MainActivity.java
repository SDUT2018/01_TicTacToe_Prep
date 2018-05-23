package edu.rosehulman.fisherds.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TicTacToeGame mGame;
  private static final String TAG = "TTT";
  private Button[] mButtons;
  private TextView mGameStateTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mGame = new TicTacToeGame(this);
    mGameStateTextView = findViewById(R.id.game_state_text_view);
    mButtons = new Button[TicTacToeGame.NUM_SQUARES];
    mButtons[0] = findViewById(R.id.button0);
    mButtons[1] = findViewById(R.id.button1);
    mButtons[2] = findViewById(R.id.button2);
    mButtons[3] = findViewById(R.id.button3);
    mButtons[4] = findViewById(R.id.button4);
    mButtons[5] = findViewById(R.id.button5);
    mButtons[6] = findViewById(R.id.button6);
    mButtons[7] = findViewById(R.id.button7);
    mButtons[8] = findViewById(R.id.button8);
  }

  public void pressedSquare(View view) {
    int buttonIndex = Integer.valueOf((String) view.getTag());
    mGame.pressedButtonAtIndex(buttonIndex);
    //Log.d(TAG, "Pressed button " + buttonIndex);
    updateView();
  }


  public void pressedNewGame(View view) {
    mGame = new TicTacToeGame(this);
    //Log.d(TAG, "Pressed new game");
    updateView();
  }

  private void updateView() {
    mGameStateTextView.setText(mGame.stringForGameState());

    for (int i = 0; i < TicTacToeGame.NUM_SQUARES; i++) {
      mButtons[i].setText(mGame.stringForButtonAtIndex(i));
    }
  }
}
