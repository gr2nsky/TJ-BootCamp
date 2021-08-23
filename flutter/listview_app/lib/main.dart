import 'package:flutter/material.dart';
import 'package:listview_app/firstPage.dart';
import 'package:listview_app/secondPage.dart';
import 'package:listview_app/animalItem.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage>
    with SingleTickerProviderStateMixin {
  //late는 또 뭐고
  late TabController controller;
  List<Animal> animalList = [];

  @override
  void initState() {
    // 앱이 시작할 떄
    // ignore: todo
    // TODO: implement initState
    super.initState();
    //탭이 2개짜리다 라는 말
    // 탭 컨트롤러가 첫 페이지 두번쨰 페이지 다 들어간다는 뜻. >> this
    controller = TabController(length: 2, vsync: this);

    animalList.add(Animal(
        animalName: '벌',
        kind: '곤충',
        imagePath: 'images/bee.png',
        fltExist: true));
    animalList.add(Animal(
        animalName: '고양이',
        kind: '포유류',
        imagePath: 'images/cat.png',
        fltExist: false));
    animalList.add(Animal(
        animalName: '강아지',
        kind: '포유류',
        imagePath: 'images/dog.png',
        fltExist: false));
    animalList.add(Animal(
        animalName: '젖소',
        kind: '포유류',
        imagePath: 'images/cow.png',
        fltExist: false));
    animalList.add(Animal(
        animalName: '원숭이',
        kind: '영장류',
        imagePath: 'images/monkey.png',
        fltExist: false));
    animalList.add(Animal(
        animalName: '여우',
        kind: '포유류',
        imagePath: 'images/fox.png',
        fltExist: true));
    animalList.add(Animal(
        animalName: '돼지',
        kind: '포유류',
        imagePath: 'images/pig.png',
        fltExist: false));
    animalList.add(Animal(
        animalName: '늑대',
        kind: '포유류',
        imagePath: 'images/fox.png',
        fltExist: false));
  }

  @override
  void dispose() {
    // 앱이 정리 될때
    // ignore: todo
    // TODO: implement dispose
    controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(' Tab bar Test'),
      ),
      body: TabBarView(
        //페이지 생성자이므로 리스트뷰 아이템을 생성자로 넘겨야 함
        children: [
          FirstPage(
            list: animalList,
          ),
          SecondPage(
            list: animalList,
          )
        ],
        controller: controller,
      ),
      bottomNavigationBar: TabBar(
        tabs: [
          Tab(
            icon: Icon(
              Icons.looks_one,
              color: Colors.blue,
            ),
            text: 'Page #1',
          ),
          Tab(
            icon: Icon(
              Icons.looks_two,
              color: Colors.red,
            ),
          ),
        ],
        // Design + controller 정의
        controller: controller,
      ),
    );
  }
}
