package com.example.trivia;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;

    private FbModule fbModule;
    private String backgroundcolor = "";
    private ConstraintLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.main);

        fbModule = new FbModule(this);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == RESULT_OK) {
                            Intent data = o.getData();
                            String str = data.getStringExtra("color");
                            Toast.makeText(MainActivity.this, "" + str, Toast.LENGTH_SHORT).show();
                            fbModule.writeBackgroundColorToFb(str);
                        }

                    }
                }
        );//נרשם כדי לקבל מידע מהאקטיביטי
    }

    public void onStartGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onSetting(View view) {
        Intent i = new Intent(this, SettingActivity.class);
        launcher.launch(i);
    }

    public void onInstruction(View view) {

    }

    public void setNewColorFromFB(String str) {
        this.backgroundcolor = str;
        setBackgroundColor(str);

    }

    public void setBackgroundColor(String color)
    {
        switch (color)
        {
            case "Red":
            {
                ll.setBackgroundColor(Color.argb(255,208,51,51));
                break;
            }
            case "Blue":{
                ll.setBackgroundColor(Color.argb(255,102,102,255));
                break;
            }
            case "Yellow":
            {
                ll.setBackgroundColor(Color.argb(255,249,236,51));
                break;

            }
            case "Pink":
            {
                ll.setBackgroundColor(Color.argb(255,255,102,255));
                break;
            }
            default:
                ll.setBackgroundColor(Color.WHITE);




        }

    }

}