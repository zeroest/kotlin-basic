package me.zeroest.kotlin.basic.reservedword;

import java.io.InputStream;

public class JavaKeyword {
    private InputStream in;
    private Boolean is;

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public Boolean getIs() {
        return is;
    }

    public void setIs(Boolean is) {
        this.is = is;
    }

}

enum CountryCodeJava {
    kr, jp, us,
    // do는 자바의 예약어이기 때문에 사용 불가
//    do // 도미니카 공화국
}
