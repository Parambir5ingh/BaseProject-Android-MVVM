/*
 * Copyright (c) 2017. Code by PRM . Happy coding
 */

package com.prm.base_mvvm.WebServices;

public @interface Web {

    @interface Keys {
        String USER_ID = "user_id";
        String SUCCESS = "success";
        String QUICK_LECTURE_TYPE = "QUICK_LECTURE_TYPE";
        String QUICK_LECTURE_TEXT = "QUICK_LECTURE_TEXT";
        String DISCOVERY_URL = "DISCOVERY_URL";
        String PRIVACY = "PRIVACY";
    }


    @interface File_Options {
        String IMAGE = "IMAGE";
        String AUDIO = "AUDIO";
        String VIDEO = "VIDEO";
        String DOC = "DOC";
        String PDF = "PDF";
        String TEXT = "TEXT";

    }

    @interface LocalFolders {
        String LectureVerbVideos = "ForHerApp/LectureVerbVideos";
        String LectureVerbAudio = "ForHerApp/LectureVerbAudio";
    }


    @interface Path {
        String BASE_URL = "http://192.168.88.0:8001";
        String BASE_IMAGE_URL = "http://192.168.88.0:8001/images";
        String MID_URL = "lecture_verb.php?lectureverb=";

        String ApiUrl1 = MID_URL + "add_quick_lecture";
    }
}
