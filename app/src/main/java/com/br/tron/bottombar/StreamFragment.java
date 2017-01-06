package com.br.tron.bottombar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Tron on 1/5/2017.
 */

public class StreamFragment extends Fragment {

    public StreamFragment(){};

    @Override
    public View onCreateView(final LayoutInflater inflater,final ViewGroup container,final Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_stream, container, false);

    }

}
