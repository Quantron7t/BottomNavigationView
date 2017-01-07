package com.br.tron.bottombar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Tron on 1/5/2017.
 */

public class RadioFragment extends Fragment implements Button.OnClickListener  {

    Button buttonman;
    View rootView;
    PushStreamLink pushStreamLink;
    Activity a;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            //a = (Activity) context;
        }
        if (context instanceof PushStreamLink) {
            pushStreamLink = (PushStreamLink) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    public RadioFragment(){
    };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_player, container, false);
        buttonman = (Button)rootView.findViewById(R.id.buttonman);
        buttonman.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        /*Fragment fragment = new StreamFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/
        //((MainActivity)a).performStreamClick();
        pushStreamLink.sendStreamLink("www.zz.com");
    }
}
