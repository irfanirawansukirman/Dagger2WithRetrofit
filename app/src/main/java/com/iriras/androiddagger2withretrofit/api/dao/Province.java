package com.iriras.androiddagger2withretrofit.api.dao;

import java.util.List;

/**
 * Created by irfan on 02/04/17.
 */

public class Province {
    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public class DataBean {
        private String propinsi;
        private String kode;

        public String getPropinsi() {
            return propinsi;
        }

        public void setPropinsi(String propinsi) {
            this.propinsi = propinsi;
        }

        public String getKode() {
            return kode;
        }

        public void setKode(String kode) {
            this.kode = kode;
        }
    }
}
