package kr.hs.emirim.s2019s11.mirimvoterenoir;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgRes = {R.drawable.vote1,R.drawable.vote2,R.drawable.vote3,R.drawable.vote4,R.drawable.vote5,R.drawable.vote6,R.drawable.vote7,R.drawable.vote8,R.drawable.vote9};
    String[] imgNames = {"주황런쥔", "청순도영", "패딩영훈", "이재현", "당근준휘", "금발준휘", "멈머지성", "조슈아", "핑크찬희"};
    int[] voteCount = new int[imgNames.length];

    public GridAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(300, 400));
        imgv.setAdjustViewBounds(true);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5, 5, 5, 5);
        imgv.setImageResource(imgRes[position]);
        for(int i=0; i<voteCount.length; i++) {
            voteCount[i] = 0;
        }
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCount[pos]++;
                Toast.makeText(context, imgNames[pos] + ": 총 " + voteCount[pos] + "표", Toast.LENGTH_SHORT).show();
            }
        });
        return imgv;
    }
}
