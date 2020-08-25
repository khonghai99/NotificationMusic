package com.bkav.android.notificationmusic;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton play;
    TextView title;

    List<Track> tracks = new ArrayList<>();

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.imgPlay);
        title = findViewById(R.id.tvTitle);

        populateTracks();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNotification.createNotification(MainActivity.this, tracks.get(1),
                        R.drawable.ic_pause, 1, tracks.size() - 1);
            }
        });

    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name;
            NotificationChannel channel = new NotificationChannel(CreateNotification.CHANNEL_ID,
                    "BKAV DEV", NotificationManager.IMPORTANCE_LOW);

            notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    public void populateTracks() {
        tracks.add(new Track("Track 1", "Artist 1", R.drawable.chieu_hom_ay));
        tracks.add(new Track("Track 2", "Artist 2", R.drawable.dung_cho_anh_nua));
        tracks.add(new Track("Track 3", "Artist 3", R.drawable.dung_thuong));
        tracks.add(new Track("Track 4", "Artist 4", R.drawable.mai_mai_khong_phai_anh));
        tracks.add(new Track("Track 5", "Artist 5", R.drawable.nuoc_mat));
    }
}