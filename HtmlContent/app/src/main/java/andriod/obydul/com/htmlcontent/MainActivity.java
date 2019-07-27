package andriod.obydul.com.htmlcontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    String myText = "<h1>This is heading 1</h1>\n"+
            "<h2>This is heading 2</h2>\n"+
            "<h3>This is heading 3</h3>\n"+
            "<p><u>This is a paragraph</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webviewid);
        webView.loadDataWithBaseURL(null, myText, "text/html", "utf-8", null);

    }
}
