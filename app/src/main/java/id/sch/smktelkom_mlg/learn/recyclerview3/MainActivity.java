package id.sch.smktelkom_mlg.exam.remidipraktekbase23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText etX;
    EditText etY;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etX = (EditText) findViewById(R.id.editTextX);
        etY = (EditText) findViewById(R.id.editTextY);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonProses).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doHitung();
            }
        });
    }

    private void doHitung()
    {
        if(isValid())
        {
            if(isValid2()) {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                String hasil = "";

                int z = x * y;

                for (int i = 0; i < z; i++) {
                    hasil += "*";
                }
                tvHasil.setText(hasil + " = " + (x * y));
            }
        }
    }

    private boolean isValid2() {
        boolean valid = true;

        int x = Integer.parseInt(etX.getText().toString());
        int y = Integer.parseInt(etY.getText().toString());

        if(y > 5)
        {
            etY.setError("Angka tidak boleh lebih dari 5");
            valid = false;
        }
        else if(y % 2 != 0)
        {
            etY.setError("Angka Y harus Genap");
            valid = false;
        }

        else
        {
            etY.setError(null);
        }

        if(x > 10)
        {
            etX.setError("Angka tidak boleh lebih dari 10");
            valid = false;
        }
        else if(x % 2 == 0 )
        {
            etX.setError("Angka X harus Ganjil");
            valid = false;
        }

        else
        {
            etX.setError(null);
        }

        return valid;

    }

    private boolean isValid()
    {
        boolean valid = true;



        String xx = etX.getText().toString();
        String yy = etY.getText().toString();

        if(xx.isEmpty())
        {
            etX.setError("X belum diisi");
            valid = false;
        }

        else
        {
            etX.setError(null);
        }

        if(yy.isEmpty())
        {
            etY.setError("Y belum diisi");
            valid = false;
        }

        else
        {
            etY.setError(null);
        }

        return valid;
    }

}
