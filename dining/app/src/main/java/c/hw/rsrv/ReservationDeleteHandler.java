package c.hw.rsrv;

import c.menu.AbstractMenuHandler;
import c.hw.dao.ReservationDao;
import c.util.Prompt;

public class ReservationDeleteHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationDeleteHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (reservationDao.delete(no) == 0) {
      System.out.println("예약 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}