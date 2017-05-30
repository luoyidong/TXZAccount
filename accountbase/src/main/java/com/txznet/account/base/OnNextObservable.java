package com.txznet.account.base;

import android.database.Observable;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class OnNextObservable extends Observable<OnNextObservable.OnNextObserver> {

    public static OnNextObservable GLOBAL_OBSERVABLE = new OnNextObservable();

    public interface OnNextObserver {
        void onNext();

        void onEnd();
    }

    public void notifyOnNext() {
        synchronized (mObservers) {
            for (OnNextObserver observer : mObservers) {
                observer.onNext();
            }
        }
    }

    public void notifyOnEnd() {
        synchronized (mObservers) {
            for (OnNextObserver observer : mObservers) {
                observer.onEnd();
            }
        }
    }
}