package com.guyubrukun.radio.listeners;

public interface MediaRecorderStatusListener {
    void onMyRecorderStart();
    void onMyRecorderStop();
    void onMyRecorderError();
}
