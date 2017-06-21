package com.nnkti.savingdata.Presenter;

import java.io.File;

/**
 * Created by nnkti on 6/21/2017.
 */

public interface PresenterInterface {
    interface View{
        void saved(boolean result);
        void setContent(String s,boolean result);
        void deleted(boolean result);
        void cloned(boolean result);
    }
    interface Presenter{
        void saveInput(File file, String s);
        void readInput(File file);
        void removeInput(File file);
        void cloneInput(File fileSrc, File fileDes);
    }
}
