import 'package:flutter/material.dart';
import 'package:tap_bar/firstPage.dart';
import 'package:tap_bar/secondPage.dart';

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

  @override
  void initState() {
    // 앱이 시작할 떄
    // ignore: todo
    // TODO: implement initState
    super.initState();
    //탭이 2개짜리다 라는 말
    controller = TabController(
        length: 2, vsync: this); // 탭 컨트롤러가 첫 페이지 두번쨰 페이지 다 들어간다는 뜻. >> this
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
        children: [FirstPage(), SecondPage()],
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

}
