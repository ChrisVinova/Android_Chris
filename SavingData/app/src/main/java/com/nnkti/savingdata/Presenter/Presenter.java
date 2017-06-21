package com.nnkti.savingdata.Presenter;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

/**
 * Created by nnkti on 6/21/2017.
 */

public class Presenter implements PresenterInterface.Presenter {
    private PresenterInterface.View view;
    public Presenter(PresenterInterface.View view) {
        this.view = view;
    }

    private class FileRead{
        private File file;
        private String s;

        public FileRead(File file, String s) {
            this.file = file;
            this.s = s;
        }
    }

    private class SaveASyncTask extends AsyncTask<FileRead,Integer,FileRead>{
        @Override
        protected void onPostExecute(FileRead fileRead) {
            super.onPostExecute(fileRead);
            view.saved(fileRead.file.exists());
        }

        @Override
        protected FileRead doInBackground(FileRead... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                FileOutputStream fos = new FileOutputStream(params[0].file);
                fos.write(params[0].s.getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new FileRead(params[0].file,params[0].s);
        }
    }

    @Override
    public void saveInput(File file, String s) {
        //Save button
        SaveASyncTask saveASyncTask = new SaveASyncTask();
        saveASyncTask.execute(new FileRead(file,s));
    }

    private class ReadASyncTask extends AsyncTask<FileRead,Integer,FileRead>{
        @Override
        protected void onPostExecute(FileRead fileRead) {
            super.onPostExecute(fileRead);
            view.setContent(fileRead.s,fileRead.file.exists());
        }

        @Override
        protected FileRead doInBackground(FileRead... params) {
            try {
                FileInputStream fis = new FileInputStream(params[0].file);
                DataInputStream in = new DataInputStream(fis);
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(in));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    params[0].s = params[0].s + "\n" + strLine;
                }
                in.close();

            } catch (IOException e){
                e.printStackTrace();
            }
            return new FileRead(params[0].file,params[0].s);
        }
    }

    @Override
    public void readInput(File file) {
        ReadASyncTask readASyncTask = new ReadASyncTask();
        String myData = "";
        readASyncTask.execute(new FileRead(file,myData));
    }

    @Override
    public void removeInput(File file) {
        boolean d0 = file.delete();
        view.deleted(d0);
    }



    private class CopyASyncTask extends AsyncTask<File[], Integer, File>{
        private void copy(File src, File dst) throws IOException {
            FileInputStream inStream = new FileInputStream(src);
            FileOutputStream outStream = new FileOutputStream(dst);
            FileChannel inChannel = inStream.getChannel();
            FileChannel outChannel = outStream.getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
            inStream.close();
            outStream.close();
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            view.cloned(file.exists());
        }

        @Override
        protected File doInBackground(File[]... params) {
            try {
                copy(params[0][0],params[0][1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return params[0][1];
        }
    }

    @Override
    public void cloneInput(File fileSrc, File fileDes) {
        File[] list = new File[2];
        list[0] = fileSrc;
        list[1] = fileDes;
        CopyASyncTask copyASyncTask = new CopyASyncTask();
        copyASyncTask.execute(list);
    }
}
