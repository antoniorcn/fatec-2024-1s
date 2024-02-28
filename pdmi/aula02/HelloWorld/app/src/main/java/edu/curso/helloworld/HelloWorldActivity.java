package edu.curso.helloworld;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
public class HelloWorldActivity
            extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedBundle) {
        super.onCreate(savedBundle);
        Log.i("HelloWorld",
                "Activity Hello World Aberta");
        setContentView(R.layout.helloworld_activity);
    }
}
