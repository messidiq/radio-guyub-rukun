package com.guyubrukun.radio.listeners;

public interface MediaRecorderListener {
    void onRecordingStart();
    void onRecordingStop();
    void onRecordingError();
}
