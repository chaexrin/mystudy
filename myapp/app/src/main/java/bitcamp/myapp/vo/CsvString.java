package bitcamp.myapp.vo;

// caller: CSV 문자열을 받아서 파일에 저장하는 측
// callee: 도메인 객체 = 값 객체(value object; vo) = 데이터 전송 객체(dto)
public interface CsvString {

  String toCsvString();
}
