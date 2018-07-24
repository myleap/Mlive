package org.myleap.mlive.model.net;


import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by jwd on 2017/3/1.
 */
public interface RequestApi {
    @POST("member/getMemberTerm")
    Call<ResponeInfo> queryVideoFinalInfo(@Body RequestBody body);

    @POST("member/getMemberTerm")
    Observable<ResponeInfo> postRxJava(@Body RequestBody body);

    @POST("video/startLive")
    Observable<ResponeInfo> startLive(@Body RequestBody body);

    @POST("user/regiest")
    Observable<ResponeInfo> regiestUser(@Body RequestBody body);

    @FormUrlEncoded
    @POST("user/regiest")
    Observable<ResponeInfo> regiestUser(@Field("mobile") String mobile, @Field("code") String code, @Field("nickname") String nickname);

    @Headers({
            "Accept: application/x-protobuf",
            "Content-type: application/x-protobuf"
    })
    @POST("test/query")
    Call<ResponseBody> pro();
}
