package example.com.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;

    Typeface fontNumber1;
    Typeface fontNumber2;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        fontNumber1 = Typeface.createFromAsset(getAssets(), "fonts/theme1.ttf");
        fontNumber2 = Typeface.createFromAsset(getAssets(), "fonts/theme2.ttf");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        specifyTheFontForText1();
        specifyTheFontForText2();
        specifyTheFontForText3();
    }

    public void specifyTheFontForText1 () {
        boolean fontNumber1Value;
        boolean fontNumber2Value;
        String fontSize = sharedPreferences.getString("FONT_SIZE_1", "10");

        fontNumber1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR1_TEXT1", false);
        fontNumber2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR2_TEXT1", false);

        if (fontNumber1Value) {
            textView.setTypeface(fontNumber1);

        } else if (fontNumber2Value) {
            textView.setTypeface(fontNumber2);
        }

        textView.setTextSize(Integer.valueOf(fontSize));
    }

    public void specifyTheFontForText2 () {
        boolean fontNumber1Value;
        boolean fontNumber2Value;
        String fontSize = sharedPreferences.getString("FONT_SIZE_2", "10");

        fontNumber1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR1_TEXT2", false);
        fontNumber2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR2_TEXT2", false);

        if (fontNumber1Value) {
            textView2.setTypeface(fontNumber1);

        } else if (fontNumber2Value) {
            textView2.setTypeface(fontNumber2);
        }
        textView2.setTextSize(Integer.valueOf(fontSize));
    }

    public void specifyTheFontForText3 () {
        boolean fontNumber1Value;
        boolean fontNumber2Value;
        String fontSize = sharedPreferences.getString("FONT_SIZE_3", "10");

        fontNumber1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR1_TEXT3", false);
        fontNumber2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NR2_TEXT3", false);

        if (fontNumber1Value) {
            textView3.setTypeface(fontNumber1);

        } else if (fontNumber2Value) {
            textView3.setTypeface(fontNumber2);
        }
        textView3.setTextSize(Integer.valueOf(fontSize));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent (MainActivity.this, PreferencesActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
