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
                  "íėŽėę° : " + currentDataTime,
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
                  "ė íėę° : ${chosenDateTime != null ? _chosenItem(chosenDateTime!) : "ėę°ė ė ííėļė."}",
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
        dateName = "ė";
        break;
      case 2:
        dateName = "í";
        break;
      case 3:
        dateName = "ė";
        break;
      case 4:
        dateName = "ëŠĐ";
        break;
      case 5:
        dateName = "ęļ";
        break;
      case 6:
        dateName = "í ";
        break;
      case 7:
        dateName = "ėž";
        break;
    }
    return dateName;
  }
}
