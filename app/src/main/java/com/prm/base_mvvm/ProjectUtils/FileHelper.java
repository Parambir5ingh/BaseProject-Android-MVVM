package com.prm.base_mvvm.ProjectUtils;

import android.os.Environment;

import com.prm.base_mvvm.WebServices.Web;

import java.io.File;
import java.io.IOException;

public class FileHelper
{
    private static final FileHelper ourInstance = new FileHelper();

    public static FileHelper getInstance()
    {

        return ourInstance;
    }

    private FileHelper()
    {
    }


    /**
     * intialize folder for audio files
     * @return
     */
    private File initFolderAudio()
    {
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + Web.LocalFolders.LectureVerbAudio);
        if (!folder.exists()) {
            folder.mkdir();
        }

        return folder;
    }

    public File createAudioFile(String fileName)
    {
        File newFile = new File(initFolderAudio(), fileName);
        return newFile;
    }











    /**
     * intialize folder for Images files
     * @return
     */
    private File initFolderImages()
    {

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "LectureVerbImages");
            if (!folder.exists()) {
                folder.mkdir();
            }


        return folder;
    }


    public File createImageFile(String fileName)
    {
        File newFile = new File(initFolderImages(), fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }









    /**
     * intialize folder for video files
     * @return
     */
    private File initFolderVideos()
    {
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + Web.LocalFolders.LectureVerbVideos);
        if (!folder.exists()) {
            folder.mkdir();
        }

        return folder;
    }


    public File createVideosFile(String fileName)
    {
        File newFile = new File(initFolderImages(), fileName);
        return newFile;
    }


}
