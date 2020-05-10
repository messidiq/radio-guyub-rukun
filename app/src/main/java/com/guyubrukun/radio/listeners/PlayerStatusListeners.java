package com.guyubrukun.radio.listeners;

public interface PlayerStatusListeners {
    void onMyPlayerStartPlaying();
    void onMyPlayerPause();
    void onMyPlayerStop();
    void onMyPlayerError();
}
