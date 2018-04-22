package com.pramudana.sam.edubanten.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.pramudana.sam.edubanten.Calon1Activity;
import com.pramudana.sam.edubanten.Calon2Activity;
import com.pramudana.sam.edubanten.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
    Uri vidUri = Uri.parse(vidAddress);
    Button btnCalon1, btnCalon2;
    @BindView(R.id.myVideo)
    VideoView myVideo;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        btnCalon1 = (Button)getActivity().findViewById(R.id.btnCalon1);
        btnCalon2 = (Button)getActivity().findViewById(R.id.btnCalon2);

        btnCalon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent calon1 = new Intent(getActivity(), Calon1Activity.class);
                startActivity(calon1);
            }
        });

        btnCalon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calon2 = new Intent(getActivity(), Calon2Activity.class);
                startActivity(calon2);
            }
        });

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        VideoView vidView = (VideoView)view.findViewById(R.id.myVideo);
        vidView.setVideoURI(vidUri);
        vidView.start();

        MediaController vidControl = new MediaController(getContext());
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
