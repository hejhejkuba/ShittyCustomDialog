package com.example.mikroprojekt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editText1, editText2;
    private ExampleDialogListener exampleDialogListener;
    private Button button;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Limity dla hasła")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                "Zmiany nie zostały zapisane", Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("Zapisz", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String jeden = editText1.getText().toString();
                        String dwa = editText2.getText().toString();
                            if(jeden.equals("") || dwa.equals(""))
                            {
                                Toast.makeText(getActivity(),
                                        "Zmiany nie zostały zapisane", Toast.LENGTH_LONG).show();
                            }
                            else{

                                exampleDialogListener.applyTexts(jeden, dwa);
                            }



                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Toast.makeText(getActivity(),
                                "Zmiany nie zostały zapisane", Toast.LENGTH_LONG).show();
                    }
                });
        editText1 = view.findViewById(R.id.editText1);
        editText1.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "3" )}) ;
        editText2 = view.findViewById(R.id.editText2);
        editText2.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "3" )}) ;
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            exampleDialogListener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String jeden, String dwa);
    }
}
