package andriod.obydul.com.videodemo;

import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
//https://medium.com/@doyouseeitmyway/creating-and-using-resource-files-in-android-studio-8b4208c08862

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoViewId);

//        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.car_racing_sample;
//        Uri uri = Uri.parse(uriPath);
        //String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.car_racing_sample;
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tom_jerry);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();


    }
}
