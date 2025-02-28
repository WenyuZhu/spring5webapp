package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String addressLineOne;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(){
    }

    public Publisher(String name, String addressLineOne, String city, String state, String zip){
        this.name = name;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Set<Book> getBooks(){
        return books;
    }

    public void setBooks(Set<Book> books){
        this.books = books;
    }

    public Long getId(){
        return Id;
    }

    public void setId(Long id){
        Id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddressLineOne(){
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne){
        this.addressLineOne = addressLineOne;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getZip(){
        return zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    @Override
    public String toString(){
        return "Publisher{" + "Id=" + Id + ", name='" + name + '\'' + ", addressLineOne='" + addressLineOne + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip='" + zip + '\'' + '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode(){
        return Id != null ? Id.hashCode() : 0;
    }
}
