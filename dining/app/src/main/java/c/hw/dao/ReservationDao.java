package c.hw.dao;

import java.util.List;
import c.hw.vo.Reservation;

public interface ReservationDao {

  void add(Reservation reservation);

  int delete(int no);

  List<Reservation> findAll();

  Reservation findBy(int no);

  int update(Reservation reservation);

}
