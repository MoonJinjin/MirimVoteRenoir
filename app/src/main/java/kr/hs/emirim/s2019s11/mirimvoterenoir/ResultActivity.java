package kr.hs.emirim.s2019s11.mirimvoterenoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");
        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");
        TextView[] textVs = new TextView[imgNames.length];
        RatingBar[] ratingBars = new RatingBar[imgNames.length];
        ImageView imgResult = findViewById(R.id.img_result);

        int[] textIds = {R.id.text_pic1, R.id.text_pic2, R.id.text_pic3, R.id.text_pic4, R.id.text_pic5, R.id.text_pic6, R.id.text_pic7, R.id.text_pic8, R.id.text_pic9 };
        int[] ratingIds = {R.id.rating_bar1, R.id.rating_bar2, R.id.rating_bar3, R.id.rating_bar4, R.id.rating_bar5, R.id.rating_bar6, R.id.rating_bar7, R.id.rating_bar8, R.id.rating_bar9 };
        Integer imageFileId[] = {R.drawable.vote1, R.drawable.vote2, R.drawable.vote3, R.drawable.vote4, R.drawable.vote5, R.drawable.vote6, R.drawable.vote7, R.drawable.vote8, R.drawable.vote9};

        for(int i=0; i<imgNames.length; i++) {
            textVs[i] = findViewById(textIds[i]);
            ratingBars[i] = findViewById(ratingIds[i]);

            textVs[i].setText(imgNames[i]);
            ratingBars[i].setRating((float)voteCount[i]);

            imgResult.setImageResource(imageFileId[i]);
        }
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}