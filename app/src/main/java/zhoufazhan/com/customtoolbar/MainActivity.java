package zhoufazhan.com.customtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CustomToolBar  customToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customToolBar = (CustomToolBar) findViewById(R.id.customToolbar);
        customToolBar.setToolBarClick(new CustomToolBar.ToolBarClick() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(), "左边", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(), "右边", Toast.LENGTH_LONG).show();
            }
        });
    }
}
