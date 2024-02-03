package c.hw.rsrv;

import c.menu.AbstractMenuHandler;
import c.hw.dao.ReservationDao;
import c.hw.vo.Reservation;
import c.util.Prompt;
import java.util.List;

public class ReservationListHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationListHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%3s\t%5s\t%20s\t%10s\n",
        "No", "Name", "Date", "Time","The Number of People","Telephone", "createdDate");

    List<Reservation> list = reservationDao.findAll();

    for (Reservation reservation : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%3s\t%15s\t%30s\t%10s\n",
          reservation.getNo(),
          reservation.getName(),
          reservation.getReservationDate(),
          reservation.getTime(),
          reservation.getHeadCount(),
          reservation.getPhoneNr(),
          reservation.getCreatedDate());
    }
  }
}
