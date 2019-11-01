package com.teamacademicprobation.probation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.teamacademicprobation.probation.R;
import com.teamacademicprobation.probation.game.implementations.tappinggame.TapGameActivity;
import com.teamacademicprobation.probation.player.Player;
import com.teamacademicprobation.probation.player.PlayerAccess;
import com.teamacademicprobation.probation.player.PlayerManager;
import com.teamacademicprobation.probation.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HighScoresActivity extends AppCompatActivity {

  private Player player;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_high_scores);

    String playerID = getIntent().getStringExtra(LoginActivity.PLAYER_ID_KEY);
    PlayerAccess playerAccess = new PlayerManager();
    List<String> statsToShow = new ArrayList<>();
    List<String> gameIDs = playerAccess.getGamesPlayed(playerID);
    for(String gameID : gameIDs){
      StringBuilder toShow = new StringBuilder(gameID + ": ");
      Map<String, Integer> gameStatMap = playerAccess.getBest(playerID, gameID);
      for(String statID : gameStatMap.keySet()){
        toShow.append(statID).append(": ").append(gameStatMap.get(statID));
      }
      statsToShow.add(toShow.toString());
    }
    String[] arr = new String[statsToShow.size()];
    statsToShow.toArray(arr);

    ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
    TextView label = findViewById(R.id.txtPlayerStatsTitle);
    ListView list = findViewById(R.id.statsListView);
    list.setAdapter(adapter);
  }

  public void returnToHomeScreen(View view) {
    startActivity(new Intent(this, MainActivity.class));
  }
}
