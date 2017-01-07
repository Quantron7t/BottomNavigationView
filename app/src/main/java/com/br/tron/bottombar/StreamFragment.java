package com.br.tron.bottombar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Tron on 1/5/2017.
 */

public class StreamFragment extends Fragment {

    String streamUrl;
    TextView textView;

    public StreamFragment(){};

    @Override
    public View onCreateView(final LayoutInflater inflater,final ViewGroup container,final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_stream, container, false);

        return view;
    }

    public void getUrl(String data)
    {
        streamUrl=data;
        textView=(TextView) getActivity().findViewById(R.id.streamLinkTextView);
        if (streamUrl!=null)
        {
            textView.setText(streamUrl);
        }
    }
}
