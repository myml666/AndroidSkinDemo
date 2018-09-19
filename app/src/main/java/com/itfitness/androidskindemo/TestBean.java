package com.itfitness.androidskindemo;

import java.util.List;

/**
 * @ProjectName: AndroidSkinDemo
 * @Package: com.itfitness.androidskindemo
 * @ClassName: TestBean
 * @Description: java类作用描述
 * @Author: LML
 * @CreateDate: 2018/9/19 17:28
 * @UpdateUser: 更新者：
 * @UpdateDate: 2018/9/19 17:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class TestBean {

    /**
     * code : 0
     * data : [{"img":"http://img3.imgtn.bdimg.com/it/u=3999410545,2985268536&fm=26&gp=0.jpg","title":"拉扎尔"},{"img":"http://img3.imgtn.bdimg.com/it/u=1457064978,307945803&fm=26&gp=0.jpg","title":"巨石强森"},{"img":"http://img0.imgtn.bdimg.com/it/u=710830891,1474234913&fm=26&gp=0.jpg","title":"李祥"},{"img":"http://img0.imgtn.bdimg.com/it/u=433080242,676588642&fm=26&gp=0.jpg","title":"美景"},{"img":"http://img0.imgtn.bdimg.com/it/u=613893559,822399065&fm=26&gp=0.jpg","title":"洪洪"},{"img":"http://img2.imgtn.bdimg.com/it/u=2385745069,1401895147&fm=26&gp=0.jpg","title":"雨意"},{"img":"http://img3.imgtn.bdimg.com/it/u=3185138414,428845729&fm=26&gp=0.jpg","title":"Android"},{"img":"http://img3.imgtn.bdimg.com/it/u=2164038151,1588863710&fm=26&gp=0.jpg","title":"ios"},{"img":"http://img4.imgtn.bdimg.com/it/u=1263803164,1201364820&fm=26&gp=0.jpg","title":"华为"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : http://img3.imgtn.bdimg.com/it/u=3999410545,2985268536&fm=26&gp=0.jpg
         * title : 拉扎尔
         */

        private String img;
        private String title;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
