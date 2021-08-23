void main() {
  List threeKingdoms = [];
  threeKingdoms.add("위");
  threeKingdoms.add("촉");
  threeKingdoms.add("오");

  print(threeKingdoms);

  threeKingdoms[0] = "we";
  print(threeKingdoms);

  threeKingdoms.remove("we");
  print(threeKingdoms);

  threeKingdoms.removeAt(0);
  print(threeKingdoms);
  print(threeKingdoms.length);

  //기본 List에는 타입구분이 없다.
  threeKingdoms.add(1);
  threeKingdoms.add(2);
  threeKingdoms.add(3);
  print(threeKingdoms);

  //제너릭을 사용해 List에 타입의 구분을 둔다
  List<String> threeKingdoms2 = [];

  threeKingdoms2.add("위");
  threeKingdoms2.add("촉");
  // threeKingdoms2.add(1); 불가능

  List<String> threeKingdoms3 = ["위", "촉", "오"];
}
