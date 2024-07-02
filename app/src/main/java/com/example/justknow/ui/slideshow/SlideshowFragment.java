package com.example.justknow.ui.slideshow;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.justknow.R;
import com.example.justknow.databinding.FragmentSlideshowBinding;
public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_slideshow, container, false);

        VideoView videoView = v.findViewById(R.id.videoView);
        String videoPath1 = "android.resource://" + getContext().getPackageName() + "/" +R.raw.an;
        Uri uri1 = Uri.parse(videoPath1);
        videoView.setVideoURI(uri1);
        MediaController mediaController = new MediaController(SlideshowFragment.this.getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        VideoView videoView2 = v.findViewById(R.id.videoView2);
        String videoPath2 = "android.resource://" + getContext().getPackageName() + "/" +R.raw.less;
        Uri uri2 = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(SlideshowFragment.this.getContext());
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

        VideoView videoView3 = v.findViewById(R.id.videoView3);
        String videoPath3 = "android.resource://" + getContext().getPackageName() + "/" +R.raw.vid;
        Uri uri3 = Uri.parse(videoPath3);
        videoView3.setVideoURI(uri3);
        MediaController mediaController3 = new MediaController(SlideshowFragment.this.getContext());
        videoView3.setMediaController(mediaController3);
        mediaController3.setAnchorView(videoView3);

        VideoView videoView4 = v.findViewById(R.id.videoView4);
        String videoPath4 = "android.resource://" + getContext().getPackageName() + "/" +R.raw.vid;
        Uri uri4 = Uri.parse(videoPath4);
        videoView4.setVideoURI(uri4);
        MediaController mediaController4 = new MediaController(SlideshowFragment.this.getContext());
        videoView4.setMediaController(mediaController4);
        mediaController4.setAnchorView(videoView4);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}