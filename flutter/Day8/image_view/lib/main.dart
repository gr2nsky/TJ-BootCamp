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
  String _lampImage = 'images/light_on.png';
  double _lampWidth = 150;
  double _lampHeighy = 300;
  String _buttonName = "image 확대";
  String _lampSizeState = "small";
  bool _switch = true;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
        home: CupertinoPageScaffold(
      child: Center(
        child: Column(children: [
          Container(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Image.asset(
                  _lampImage,
                  width: _lampWidth,
                  height: _lampHeighy,
                )
              ],
            ),
            // Container는 해당 영역에서 고정
            width: 350,
            height: 650,
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CupertinoButton(
                  child: Text(_buttonName),
                  onPressed: () {
                    setState(() {
                      decisionLampSize();
                    });
                  }),
              Column(
                children: [
                  Text(
                    '전구 스위치',
                    style: TextStyle(fontSize: 12.0),
                  ),
                  CupertinoSwitch(
                      value: _switch,
                      onChanged: (value) {
                        setState(() {
                          _switch = value;
                          descisionOnOff();
                        });
                      }),
                ],
              ),
            ],
          )
        ]),
      ),
    ));
  }

  void decisionLampSize() {
    if (_lampSizeState == "small") {
      _lampSizeState = "large";
      _lampWidth = 300;
      _lampHeighy = 600;
      _buttonName = "Image 축소";
    } else {
      _lampSizeState = "small";
      _lampWidth = 150;
      _lampHeighy = 300;
      _buttonName = "Image 확대";
    }
  }

  void descisionOnOff() {
    if (_switch == true) {
      _lampImage = 'images/light_on.png';
    } else {
      _lampImage = 'images/light_off.png';
    }
  }
}
