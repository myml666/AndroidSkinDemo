package com.itfitness.androidskindemo;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @ProjectName: AndroidSkinDemo
 * @Package: com.itfitness.androidskindemo
 * @ClassName: Api
 * @Description: java类作用描述
 * @Author: LML
 * @CreateDate: 2018/9/19 17:28
 * @UpdateUser: 更新者：
 * @UpdateDate: 2018/9/19 17:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public interface Api {
    @GET("47f188041ae952c391ef.json")
    Observable<TestBean> getData();
}
