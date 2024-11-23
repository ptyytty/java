package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        Integer imageFileId[] = { R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                R.drawable.pic9 };

        // 1등 그림 이름과 그림 파일을 보여준다.
        TextView tvTop = (TextView) findViewById(R.id.textTop);
        ImageView ivTop = (ImageView) findViewById(R.id.imgTop);
        int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFileId[maxEntry]);

        // 9개의 TextView, RatingBar 객체배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        // 9개의 TextView, RatingBar ID 배열
        Integer tvID[] = { R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9 };
        Integer rbarID[] = { R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3, R.id.ratingBar4,
                R.id.ratingBar5, R.id.ratingBar6, R.id.ratingBar7, R.id.ratingBar8, R.id.ratingBar9 };

        // TextView, RatingBar 개체 찾기.
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        // 각 TextVeiw 및 RatingBar에 넘겨 받은 값을 반영.
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });


    }
}
