package ir.sample.mvpsample.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment
{
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if (rootView == null)
        {
            //inflate On getLayout() : because this class Use General for Any Fragments
            rootView = inflater.inflate(getLayout(), container, false);
            setupViews();
        }
        return rootView;
    }

    public abstract void setupViews();

    public abstract int getLayout();
}
