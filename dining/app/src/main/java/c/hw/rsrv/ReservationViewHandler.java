package c.hw.rsrv;

import c.menu.AbstractMenuHandler;
import c.hw.dao.ReservationDao;
import c.hw.vo.Reservation;
import c.util.Prompt;

public class ReservationViewHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationViewHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Reservation reservation = reservationDao.findBy(no);
    if (reservation == null) {
      System.out.println("예약 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", reservation.getNo());
    System.out.printf("예약자: %s\n", reservation.getName());
    System.out.printf("예약일: %s\n", reservation.getReservationDate());
    System.out.printf("예약시간: %d\n", reservation.getTime());
    System.out.printf("인원: %d\n", reservation.getHeadCount());
    System.out.printf("전화번호: %s\n", reservation.getPhoneNr());
   System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", reservation.getCreatedDate());
  }
}
