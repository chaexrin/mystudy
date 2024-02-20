package com.dining.dao;

import java.util.List;
import com.dining.vo.Reservation;

public interface ReservationDao {

  void add(Reservation reservation);

  int delete(int no);

  List<Reservation> findAll();

  Reservation findBy(int no);

  int update(Reservation reservation);

}
