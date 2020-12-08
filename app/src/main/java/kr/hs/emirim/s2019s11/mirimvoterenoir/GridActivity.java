package kr.hs.emirim.s2019s11.mirimvoterenoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {
    GridView gridv;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridv = findViewById(R.id.gridv);
        GridAdapter adapter = new GridAdapter(this);
        gridv.setAdapter(adapter);

        Button btnGo = findViewById(R.id.btn_go);
        btnGo.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", adapter.voteCount);
            intent.putExtra("imgNames", adapter.imgNames);
            startActivity(intent);
        }
    };
}