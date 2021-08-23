import 'package:flutter/material.dart';
import 'package:statefue_widget/firstPage.dart';
import 'package:statefue_widget/secondPage.dart';
import 'package:statefue_widget/stateItem.dart';

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
  List<StateInfo> stateList = [];

  @override
  void initState() {
    super.initState();
    controller = TabController(length: 2, vsync: this);

    stateList.add(StateInfo('images/america.png', '미국'));
    stateList.add(StateInfo('images/austria.png', '오스트리아'));
    stateList.add(StateInfo('images/belgium.png', '벨기에'));
    stateList.add(StateInfo('images/canada.png', '캐나다'));
    stateList.add(StateInfo('images/china.png', '중국'));
    stateList.add(StateInfo('images/estonia.png', '에스토니아'));
    stateList.add(StateInfo('images/france.png', '프랑스'));
    stateList.add(StateInfo('images/germany.png', '독일'));
    stateList.add(StateInfo('images/greece.png', '그리스'));
    stateList.add(StateInfo('images/hungary.png', '헝가리'));
    stateList.add(StateInfo('images/italy.png', '이탈리아'));
    stateList.add(StateInfo('images/korea.png', '대한민국'));
    stateList.add(StateInfo('images/latvia.png', '라트비아'));
    stateList.add(StateInfo('images/lithuania.png', '리투아니아'));
    stateList.add(StateInfo('images/luxemburg.png', '룩셈부르크'));
    stateList.add(StateInfo('images/netherland.png', '네덜란드'));
    stateList.add(StateInfo('images/romania.png', '루마니아'));
    stateList.add(StateInfo('images/turkey.png', '터키'));
  }

  @override
  void dispose() {
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
        children: [
          FirstPage(
            list: stateList,
          ),
          SecondPage()
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
