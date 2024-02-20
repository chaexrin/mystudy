package com.dining.dao.mysql;

import com.dining.dao.ReservationDao;
import com.dining.dao.DaoException;
import com.dining.vo.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {


    Connection con;

    public ReservationDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Reservation reservation) {
        try {
            Statement stmt = con.createStatement();
            String sql = String.format(
                "insert into reservations(name,reservation_date, reservation_time, ppl, tel) values('%s', '%s', '%d', '%d', '%s')",
                reservation.getName(), reservation.getReservationDate(), reservation.getTime(),
                reservation.getHeadCount(), reservation.getPhoneNr());
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }

    }

    @Override
    public int delete(int no) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(String.format("delete from reservations where reservation_no=%d", no));

        } catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }
    }

    @Override
    public List<Reservation> findAll() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs =
                stmt.executeQuery("select * from reservations ");


            ArrayList<Reservation> list = new ArrayList<>();

            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setNo(rs.getInt("reservation_no"));
                reservation.setName(rs.getString("name"));
                reservation.setReservationDate(rs.getDate("reservation_date"));
                reservation.setTime(rs.getInt("reservation_time"));
                reservation.setHeadCount(rs.getInt("ppl"));
                reservation.setPhoneNr(rs.getString("tel"));
                reservation.setCreatedDate(rs.getDate("created_date"));

                list.add(reservation);
            }
            return list;

        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public Reservation findBy(int no) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from reservations where reservation_no = " + no);

            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setNo(rs.getInt("reservation_no"));
                reservation.setName(rs.getString("name"));
                reservation.setReservationDate(rs.getDate("reservation_date"));
                reservation.setTime(rs.getInt("reservation_time"));
                reservation.setHeadCount(rs.getInt("ppl"));
                reservation.setPhoneNr(rs.getString("tel"));
                reservation.setCreatedDate(rs.getDate("created_date"));

                return reservation;
            }
            return null;

        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public int update(Reservation reservation) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(String.format(
                "update reservations set name= '%s', reservation_date='%s', reservation_time='%d', ppl='%d', tel='%s' where reservation_no=%d",
                reservation.getName(), reservation.getReservationDate(), reservation.getTime(),
                reservation.getHeadCount(),
                reservation.getPhoneNr(),
                reservation.getNo()));

        } catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }
    }


}
