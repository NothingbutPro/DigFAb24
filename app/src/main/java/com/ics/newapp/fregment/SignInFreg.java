package com.ics.newapp.fregment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.newapp.Navigation;
import com.ics.newapp.R;
import com.ics.newapp.SeasonManager.SessionManager;


public class SignInFreg extends Fragment implements
        AdapterView.OnItemSelectedListener {
    Button signIn;
    //  View view;
    Spinner spinalo;
    SessionManager sessionManager;
    Spinner spin;
    String[] country = {"Manufacturer", "Dealers", "Buyers"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vx = inflater.inflate(R.layout.fragment_sign_in_freg, container, false);
        spinalo= vx.findViewById(R.id.spinalo);
        sessionManager = new SessionManager(getActivity());
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.custom_spinner , country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinalo.setAdapter(aa);
        return  vx;

//        return inflater.inflate(R.layout.fragment_sign_in_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        //  getActivity().setTitle("BookMark List");

        signIn = view.findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.setLogin(true , spinalo.getSelectedItem().toString());
                Toast.makeText(v.getContext(), "is login is "+sessionManager.isLoggedIn(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Navigation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
