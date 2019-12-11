package ir.sample.mvpsample.Base;

public interface BasePresenter<T extends BaseView>
{
    void attachView(T view);

    void detachView();
}
