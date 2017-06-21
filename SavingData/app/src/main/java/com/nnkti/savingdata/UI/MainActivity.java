package com.nnkti.savingdata.UI;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nnkti.savingdata.Presenter.Presenter;
import com.nnkti.savingdata.Presenter.PresenterInterface;
import com.nnkti.savingdata.R;

import java.io.File;

public class MainActivity extends AppCompatActivity implements PresenterInterface.View{
    private EditText etInput;
    private TextView tvContent;
    private File file;
    private String fileName = "input.txt";
    private String filepath = "saved";


    private boolean isExternalStorageReadOnly() {
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState());
    }

    private boolean isExternalStorageAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.etInput);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnRead = (Button) findViewById(R.id.btnRead);
        Button btnRemove = (Button) findViewById(R.id.btnRemove);
        Button btnClone = (Button) findViewById(R.id.btnClone);
        Button btnLoadClone = (Button) findViewById(R.id.btnLoadClone);
        Button btnRemoveClone = (Button) findViewById(R.id.btnRemoveClone);
        tvContent = (TextView) findViewById(R.id.tvContent);

        final Presenter presenter = new Presenter(this);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            btnSave.setEnabled(false);
        } else {
            file = new File(getExternalFilesDir(filepath), fileName);
        }
        //Save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveInput(file, etInput.getText().toString());
            }
        });

        //Read button
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.readInput(file);

            }
        });

        //Remove button
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(getExternalFilesDir(filepath), fileName);
                presenter.removeInput(file);
            }
        });

        //Clone button
        btnClone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File fileSrc = new File(getExternalFilesDir(filepath), fileName);
                File fileDes = new File(getExternalFilesDir(filepath), "Copied" + fileName );
                presenter.cloneInput(fileSrc, fileDes);

            }
        });

        //Load Clone button
        btnLoadClone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File fileDes = new File(getExternalFilesDir(filepath), "Copied" + fileName);
                presenter.readInput(fileDes);
            }
        });
        //Remove Clone button
        btnRemoveClone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(getExternalFilesDir(filepath), "Copied" + fileName);
                presenter.removeInput(file);
            }
        });

    }

    @Override
    public void saved(boolean result) {
        if(result){
            Toast.makeText(this,"input.txt saved",Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this,"input.txt not saved",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(String s, boolean result) {
        if (result) {
            tvContent.setText(s);
            Toast.makeText(this, "file loaded", Toast.LENGTH_SHORT).show();
        } else {
            tvContent.setText("");
            Toast.makeText(this, "file not loaded", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void deleted(boolean result) {
        if (result){
            Toast.makeText(this,"file deleted",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"file not deleted",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void cloned(boolean result) {
        if (result) {
            Toast.makeText(this,"input.txt was cloned",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"input.txt wasn't cloned",Toast.LENGTH_SHORT).show();
        }
    }
}
