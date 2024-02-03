package c.hw.rsrv;

import c.menu.AbstractMenuHandler;
import c.hw.dao.ReservationDao;
import c.hw.vo.Reservation;
import c.util.Prompt;
import java.sql.Date;

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
