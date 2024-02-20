package com.dining.rsrv;

import com.menu.AbstractMenuHandler;
import com.dining.dao.ReservationDao;
import com.dining.vo.Reservation;
import com.util.Prompt;

public class ReservationAddHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationAddHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    Reservation reservation = new Reservation();
    reservation.setName(this.prompt.input("예약자? "));
    reservation.setReservationDate(this.prompt.inputDate("예약일?(예: 2024-01-01) "));
    reservation.setTime(this.prompt.inputInt("예약 시간? "));
    reservation.setHeadCount(this.prompt.inputInt("인원? "));
    reservation.setPhoneNr(this.prompt.input("전화번호? "));


    reservationDao.add(reservation);
  }
}
