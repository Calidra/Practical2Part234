package my.tutorial.practical2part234;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextValue;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = findViewById(R.id.myMsg);
        editTextValue = findViewById(R.id.editText1);
        msg.setText("Welcome to MAD");
    }

    public void button2Click(View view)
    {
        //Part 3
        String enteredText;
        enteredText = editTextValue.getText().toString();
        msg.setText(enteredText);

        //Part 4
        Toast.makeText(getApplicationContext(),
                enteredText, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        // set title
        alertDialogBuilder.setTitle(enteredText);
        // set dialog message
        alertDialogBuilder
                .setMessage("Yes to exit OR click No to close")
                .setCancelable(false)
                .setPositiveButton("YES to Exit",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("CANCEL DIALOG",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
}