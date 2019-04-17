package com.ics.newapp.fregment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.newapp.Affiliate_Marketing;
import com.ics.newapp.Main2Activity;
import com.ics.newapp.Navigation;
import com.ics.newapp.R;
import com.ics.newapp.SeasonManager.SessionManager;


public class SignUpFreg extends Fragment {
    Button signup;
    //  View view;
    Spinner spin;
    String[] country = {"Manufacturer", "Dealers", "Buyers","Affiliate Marketer"};
    public SessionManager sessionManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_freg, container, false);
        sessionManager = new SessionManager(view.getContext());
        return view;
//        return inflater.inflate(R.layout.fragment_sign_up_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        //  getActivity().setTitle("BookMark List");

        signup = view.findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.setSkipped(true);
                if(spin.getSelectedItem() !=null)
                {
                    sessionManager.setLogin(true , spin.getSelectedItem().toString());

                    if (spin.getSelectedItem().equals("Affiliate Marketer")){
                        Intent intent = new Intent(getActivity(), Main2Activity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(), Navigation.class);
                        startActivity(intent);
                    }
                    Toast.makeText(v.getContext(), "login is "+sessionManager.isLoggedIn(), Toast.LENGTH_SHORT).show();

                }else{

                }
              /*  Fragment view_comment = new Host_Event_Screen();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, view_comment).addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);*/

            }
        });

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        spin = (Spinner)view.findViewById(R.id.spin12);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.custom_spinner , country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }
}
