import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Flutter Demo',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<String> images = [
    'flower_01.png',
    'flower_02.png',
    'flower_03.png',
    'flower_04.png',
    'flower_05.png',
    'flower_06.png'
  ];
  String imageName = 'flower_01.png';
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                imageName,
                style: TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
              ),
              Image.asset(
                'images/$imageName',
                width: 300,
                height: 600,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CupertinoButton(
                      child: Text("이전"),
                      onPressed: () {
                        setState(() {
                          backBtn();
                        });
                      }),
                  SizedBox(
                    width: 30.0,
                  ),
                  CupertinoButton(
                      child: Text("이전"),
                      onPressed: () {
                        setState(() {
                          goBtn();
                        });
                      }),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }

  void backBtn() {
    if (count == 0) {
      count = images.length - 1;
    } else {
      count--;
    }
    imageName = images[count];
  }

  void goBtn() {
    if (count == images.length - 1) {
      count = 0;
    } else {
      count++;
    }
    imageName = images[count];
  }
}
