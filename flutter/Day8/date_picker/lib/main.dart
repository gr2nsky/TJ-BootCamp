import 'package:date_picker/zeroFormat.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'package:flutter_localizations/flutter_localizations.dart';

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
  String currentDataTime = '';
  bool _isRunning = true;
  ZeroFormat zero = ZeroFormat();
  DateTime? chosenDateTime;

  @override
  void initState() {
    super.initState();
    Timer.periodic(Duration(seconds: 1), (Timer timer) {
      if (!_isRunning) {
        timer.cancel();
      }

      _addItem();
    });
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
        localizationsDelegates: [
          GlobalCupertinoLocalizations.delegate,
          GlobalWidgetsLocalizations.delegate,
          GlobalMaterialLocalizations.delegate,
        ],
        supportedLocales: [
          const Locale('ko', 'KO'),
          const Locale('en', 'US'),
        ],
        home: CupertinoPageScaffold(
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "현재시간 : " + currentDataTime,
                  style: TextStyle(fontSize: 16.0),
                ),
                Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Container(
                    child: CupertinoDatePicker(
                      initialDateTime: DateTime.now(),
                      use24hFormat: true,
                      onDateTimeChanged: (value) {
                        chosenDateTime = value;
                      },
                    ),
                    width: 300,
                    height: 200,
                  ),
                ),
                Text(
                  "선택시간 : ${chosenDateTime != null ? _chosenItem(chosenDateTime!) : "시간을 선택하세요."}",
                  style: TextStyle(
                    fontSize: 16.0,
                  ),
                ),
              ],
            ),
          ),
        ));
  }

  String _chosenItem(DateTime now) {
    String chosenDateTime = "";
    setState(() {
      chosenDateTime =
          ("${now.year}-${zero.appendZero(now.month)}-${zero.appendZero(now.day)} ${_weekDayToString(now.weekday)} ${zero.appendZero(now.hour)}:${zero.appendZero(now.minute)}:${zero.appendZero(now.second)}");
    });
    return chosenDateTime;
  }

  void _addItem() {
    final DateTime now = DateTime.now();
    setState(() {
      currentDataTime =
          ("${now.year}-${zero.appendZero(now.month)}-${zero.appendZero(now.day)} ${_weekDayToString(now.weekday)} ${zero.appendZero(now.hour)}:${zero.appendZero(now.minute)}:${zero.appendZero(now.second)}");
    });
  }

  String _weekDayToString(int weekday) {
    String dateName = "";
    switch (weekday) {
      case 1:
        dateName = "월";
        break;
      case 2:
        dateName = "화";
        break;
      case 3:
        dateName = "수";
        break;
      case 4:
        dateName = "목";
        break;
      case 5:
        dateName = "금";
        break;
      case 6:
        dateName = "토";
        break;
      case 7:
        dateName = "일";
        break;
    }
    return dateName;
  }
}
