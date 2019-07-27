package andriod.obydul.com.htmlcontenttextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String mimeTyp = "text/html";
    private String encoding = "utf-8";

    String html = "<H1>A simple HTML page</H1><body>" +
            "<p>Android tutorial  programs present in obyduljava.blogspot.com</p>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtViewId);
        textView.setText(Html.fromHtml(html));


    }
}
