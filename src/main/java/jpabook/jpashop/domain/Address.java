package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    //임베디드 타입은 객체타입이기 때문에 값 변경시 여러군데에서 값이 바뀌는 문제가 생길 수 있음. setter를 기본적으로 private으로 차단
    private void setStreet(String street) {
        this.street = street;
    }

    private String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    //equeals 랑 hashcode만들 때는 Use getters during code generation을 사용하는게 좋음
    //저걸 선택하지 않으면 필드에 직접 접근함.
    //그러면 프록시 객체일 때는 계산이 안돼서 비교를 못하게 됨
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
