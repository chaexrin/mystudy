package c.hw.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {

    private static final long serialVersionUID = 100L;

    private int no;
    private String name;
    private Date reservationDate;
    private int time;
    private int headCount ;

    private String phoneNr;
    private Date createdDate;

    @Override
    public String toString() {
        return "Reservation{" +
            "no=" + no +
            ", name= " + name + '\'' +
            ", date= " + reservationDate + '\'' +
            ", time= " + time + '\'' +
            ", the number of people= " + headCount + '\'' +
            ", telephone= " + phoneNr + '\'' +
            ", createdDate= " + createdDate +
            '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
