package com.master.products_services.ResponseProduct;

import com.master.products_services.message.ResponseFile;

import java.util.ArrayList;
import java.util.List;

public class ResponseProduct {

    private Long productId;
    private String name;
    private Integer number;
    private Float value;
    private String info;

    List<ResponseFile> files = new ArrayList<>();

    public ResponseProduct() {
    }

    public ResponseProduct(Long productId, String name, Integer number, Float value, String info, List<ResponseFile> files) {
        this.productId = productId;
        this.name = name;
        this.number = number;
        this.value = value;
        this.info = info;
        this.files = files;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<ResponseFile> getFiles() {
        return files;
    }

    public void setFiles(List<ResponseFile> files) {
        this.files = files;
    }
}
