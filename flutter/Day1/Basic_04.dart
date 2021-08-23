//flutter는 싱글스레드이다.
void main(List<String> args) {
  checkVersion();
  print('end process');
}

//Future - async - await이 구성이 되야 async로 사용 가능
Future checkVersion() async {
  print("-----------");
  var version = await lookUpVersion();
}

int lookUpVersion() {
  return 12;
}
