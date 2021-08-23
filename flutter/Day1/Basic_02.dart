void main() {
  String str = "abc";
  print(str);

  var name = "asd";
  print(name);

  //문자열 보간법
  int intNum = 179;
  int numNum2 = 70;

  print("intNum과 intNum2의 합은 $intNum + $numNum2 입니다.");
  print("intNum1과 intNum2의 합은 ${intNum + numNum2} 입니다.");

  //사용을 권장하진 않음
  dynamic name1 = "장비";
  print(name1);

  name1 = 10;
  print(name1);
}
