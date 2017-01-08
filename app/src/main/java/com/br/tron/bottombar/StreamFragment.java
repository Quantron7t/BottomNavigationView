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

    String streamUrl="NoLinkFound";
    TextView textView;
    public StreamFragment(){};

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_stream, container, false);
        if(savedInstanceState==null)
        {

        }
        else
        {
            streamUrl=savedInstanceState.getString("CurrentStreamLink");
            textView =(TextView) getActivity().findViewById(R.id.streamLinkTextView);
            textView.setText(streamUrl);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putString("CurrentStreamLink",streamUrl);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        if (streamUrl!=null) {
//            streamUrl = savedInstanceState.getString("CurrentStreamLink");
            textView = (TextView) getActivity().findViewById(R.id.streamLinkTextView);
            textView.setText(streamUrl);
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void getUrl(String data)
    {
        streamUrl=data;
        if (streamUrl!=null)
        {
            textView=(TextView) getActivity().findViewById(R.id.streamLinkTextView);
            textView.setText(streamUrl);
        }
    }
}