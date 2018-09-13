package sh.surge.icpepr9.arduinocontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button onBtn, offBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBtn = findViewById(R.id.onBtn);
        offBtn = findViewById(R.id.offBtn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference buttonProp = database.getReference("button-prop");

        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonProp.setValue("on");
            }
        });

        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonProp.setValue("off");
            }
        });
    }
}
