package com.the3rocks.advertscreen.ui.common;


import android.support.v4.content.ContextCompat;
import android.support.design.widget.Snackbar;
import android.view.View;


import com.the3rocks.advertscreen.R;

public class SnackBarShowTemporaryErrorBehaviour implements ShowErrorBehaviour {

    private View view;

    public SnackBarShowTemporaryErrorBehaviour(View view) {
        this.view = view;
    }

    @Override
    public void showError(String message) {
        final Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.error));
        snackbar.show();
    }

    @Override
    public void showError(int resId, Object ... args) {
        final Snackbar snackbar = Snackbar.make(view, view.getResources().getString(resId, args), Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

}
