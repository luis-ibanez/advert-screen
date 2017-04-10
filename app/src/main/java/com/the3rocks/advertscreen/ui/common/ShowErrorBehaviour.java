package com.the3rocks.advertscreen.ui.common;

public interface ShowErrorBehaviour {
    void showError(int resId, Object ... args);
    void showError(String errorMessage);
}
