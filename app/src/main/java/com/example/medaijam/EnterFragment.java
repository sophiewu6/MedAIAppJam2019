package com.example.medaijam;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EnterFragment extends Fragment{

    Button button, closeButton;
    View view;
    Dialog dialog;
    EditText sbp, dbp, hr, ir;

    static Dataset.getSBP s = new Dataset.getSBP();
    static Dataset.getDBP d = new Dataset.getDBP();
    static Dataset.getMAP m = new Dataset.getMAP();
    static Dataset.getHR h = new Dataset.getHR();
    static Dataset.getIR i = new Dataset.getIR();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_enter, null);

        dialog = new Dialog(getActivity());
        button = (Button) view.findViewById(R.id.button4);

        sbp = (EditText) view.findViewById(R.id.editText2);
        dbp = (EditText) view.findViewById(R.id.editText3);
        hr = (EditText) view.findViewById(R.id.editText4);
        ir = (EditText) view.findViewById(R.id.editText6);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNewData(v);
            }
        });

        return view;
    }

    public void ShowPopup() {
        dialog.setContentView(R.layout.popup);
        closeButton = (Button) dialog.findViewById(R.id.button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void sendNewData(View view) {
        String sBP = sbp.getText().toString();
        s.addSBP(Integer.parseInt(sBP));
        String dBP = dbp.getText().toString();
        d.addDBP(Integer.parseInt(dBP));
        String hR = hr.getText().toString();
        h.addHR(Integer.parseInt(hR));
        String iR = ir.getText().toString();
        i.addIR(Integer.parseInt(iR));
        m.addMAP(Integer.parseInt(sBP), Integer.parseInt(dBP));

        System.out.println(EnterFragment.s.wantSBP());
        System.out.println(EnterFragment.d.wantDBP());
        System.out.println(EnterFragment.h.wantHR());
        System.out.println(EnterFragment.i.wantIR());
        System.out.println(EnterFragment.m.wantMAP());

    }
}
