package com.dining.rsrv;

import com.menu.AbstractMenuHandler;
import com.dining.dao.ReservationDao;
import com.dining.vo.Reservation;
import com.util.Prompt;


public class ReservationModifyHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationModifyHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Reservation oldReservation = reservationDao.findBy(no);
    if (oldReservation == null) {
      System.out.println("예약 번호가 유효하지 않습니다.");
      return;
    }

    Reservation reservation = new Reservation();
    reservation.setNo(oldReservation.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    reservation.setName(this.prompt.input("예약자(%s)? ", oldReservation.getName()));
    reservation.setReservationDate(this.prompt.inputDate("예약일(%s)? ", oldReservation.getReservationDate()));
    reservation.setTime(this.prompt.inputInt("예약 시간(%d)", oldReservation.getTime()));
    reservation.setHeadCount(this.prompt.inputInt("인원(%d)", oldReservation.getHeadCount()));
    reservation.setPhoneNr(this.prompt.input("전화번호(%s)? ", oldReservation.getPhoneNr()));
    reservation.setCreatedDate(oldReservation.getCreatedDate());

    reservationDao.update(reservation);
    System.out.println("예약을 변경했습니다.");
  }
}
