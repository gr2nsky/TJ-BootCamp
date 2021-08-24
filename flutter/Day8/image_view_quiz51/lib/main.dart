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
  bool _sizeSwitch = false;
  bool _lightSwitch = true;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      home: CupertinoPageScaffold(
        child: Center(
          child: Column(
            children: [
              Container(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Image.asset(
                      _lampImage,
                      width: _lampWidth,
                      height: _lampHeighy,
                    ),
                  ],
                ),
                width: 350,
                height: 650,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Column(
                    children: [
                      Text(
                        "전구 스위치",
                        style: TextStyle(fontSize: 12.0),
                      ),
                      CupertinoSwitch(
                          value: _lightSwitch,
                          onChanged: (value) {
                            setState(() {
                              _lightSwitch = value;
                              decisionOnOff();
                            });
                          }),
                    ],
                  ),
                  SizedBox(
                    width: 50.0,
                  ),
                  Column(
                    children: [
                      Text(
                        "확대 스위치",
                        style: TextStyle(fontSize: 12.0),
                      ),
                      CupertinoSwitch(
                          value: _sizeSwitch,
                          onChanged: (value) {
                            setState(() {
                              _sizeSwitch = value;
                              decisionLampSize();
                            });
                          }),
                    ],
                  ),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }

  void decisionOnOff() {
    if (_lightSwitch == true) {
      _lampImage = "images/light_on.png";
    } else {
      _lampImage = "images/light_off.png";
    }
  }

  void decisionLampSize() {
    if (_sizeSwitch == true) {
      _lampWidth = 300;
      _lampHeighy = 600;
    } else {
      _lampWidth = 150;
      _lampHeighy = 300;
    }
  }
}
