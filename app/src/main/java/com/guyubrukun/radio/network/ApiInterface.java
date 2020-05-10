package com.guyubrukun.radio.network;

import com.guyubrukun.radio.model.Programs;
import com.guyubrukun.radio.model.RadioChannelData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET(HttpParams.SHEET_API_END_POINT)
    Call<Programs> getProgramList(@Query("id") String sheetId, @Query("sheet") String sheetName);

    @GET(HttpParams.SHEET_API_END_POINT)
    Call<RadioChannelData> getChannelData(@Query("id") String sheetId, @Query("sheet") String sheetName);
}
