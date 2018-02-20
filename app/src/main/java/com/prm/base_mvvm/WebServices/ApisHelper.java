/*
 * Copyright (c) 2017. Code by PRM . Happy coding
 */

package com.prm.base_mvvm.WebServices;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApisHelper
{
    @Multipart
    @POST(Web.Path.ApiUrl1)
    Call<BasicApiModel> uploadAudioLecture(
            @Part MultipartBody.Part filePart,
            @Part(Web.Keys.QUICK_LECTURE_TYPE) RequestBody quickLectureType
            , @Part(Web.Keys.USER_ID) RequestBody userId
            , @Part(Web.Keys.QUICK_LECTURE_TEXT) RequestBody quickLecText
            , @Part(Web.Keys.DISCOVERY_URL) RequestBody discovery_url
            , @Part(Web.Keys.PRIVACY) RequestBody privacy);



    @Multipart
    @POST(Web.Path.ApiUrl1)
    Call<BasicApiModel> textTypeQuickLecture(
            @Part(Web.Keys.QUICK_LECTURE_TYPE) RequestBody quickLectureType
            , @Part(Web.Keys.USER_ID) RequestBody userId
            , @Part(Web.Keys.QUICK_LECTURE_TEXT) RequestBody quickLecText);

}
