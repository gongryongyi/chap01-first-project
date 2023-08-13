package com.ohgiraffers.section01;

public class MovieDTO {
    private int code;
    private String name;
    private String theather;
    private int categoryCode;
    private String releaseStatus;

    public MovieDTO() {
    }

    public MovieDTO(int code, String name, String theather, int categoryCode, String releaseStatus) {
        this.code = code;
        this.name = name;
        this.theather = theather;
        this.categoryCode = categoryCode;
        this.releaseStatus = releaseStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheather() {
        return theather;
    }

    public void setTheather(String theather) {
        this.theather = theather;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", theather='" + theather + '\'' +
                ", categoryCode=" + categoryCode +
                ", releaseStatus='" + releaseStatus + '\'' +
                '}';
    }
}
