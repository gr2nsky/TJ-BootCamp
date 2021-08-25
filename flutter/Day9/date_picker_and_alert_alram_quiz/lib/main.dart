import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'package:flutter_localizations/flutter_localizations.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
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
  bool isRunning = true;
  DateTime? chosenDateTime;
  String currentDateTime = '';

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    Timer.periodic(Duration(seconds: 1), (Timer timer) {
      if (!isRunning) {
        timer.cancel();
      }
      _addTimer();
      if (isEqualsTime()) {
        showCupertinoDialog(
            context: context,
            builder: (context) {
              return CupertinoAlertDialog(
                title: Text("알림"),
                content: Text("설정한 시간입니다."),
                actions: [
                  CupertinoDialogAction(
                    isDefaultAction: true,
                    child: Text("네, 알겠습니다."),
                    onPressed: () {
                      Navigator.pop(context);
                    },
                  ),
                ],
              );
            });
      }
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
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: Text("알람시간 정하기"),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: Text("현재시간 : $currentDateTime"),
              ),
              Container(
                child: CupertinoDatePicker(
                    initialDateTime: DateTime.now(),
                    use24hFormat: true,
                    onDateTimeChanged: (value) {
                      chosenDateTime = value;
                    }),
                width: 300,
                height: 200,
              ),
              Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Text("${selectedTime()}")),
            ],
          ),
        ),
      ),
    );
  }

  void _addTimer() {
    final DateTime now = DateTime.now();
    setState(() {
      currentDateTime = getTime(now);
    });
  }

  String getTime(DateTime time) {
    String year = '${time.year}';
    String month = AddZero(time.month);
    String day = AddZero(time.day);
    String wd = parseWeekday(time.weekday);
    String hour = AddZero(time.hour);
    String min = AddZero(time.minute);
    String second = AddZero(time.second);

    return "$year-$month-$day $wd $hour:$min:$second";
  }

  String parseWeekday(int weekday) {
    switch (weekday) {
      case 1:
        return "월";
      case 2:
        return "화";
      case 3:
        return "수";
      case 4:
        return "목";
      case 5:
        return "금";
      case 6:
        return "토";
      case 7:
        return "일";
      default:
        return "error";
    }
  }

  String AddZero(int value) {
    return value >= 10 ? '$value' : '0$value';
  }

  String selectedTime() {
    if (chosenDateTime == null) {
      return "시간을 선택해 주세요.";
    }
    return "선택시간 : ${getTime(chosenDateTime!)}";
  }

  bool isEqualsTime() {
    if (chosenDateTime == null) {
      return false;
    }

    bool year = (DateTime.now().year == chosenDateTime!.year);
    bool month = (DateTime.now().month == chosenDateTime!.month);
    bool day = (DateTime.now().day == chosenDateTime!.day);
    bool hour = (DateTime.now().hour == chosenDateTime!.hour);
    bool min = (DateTime.now().minute == chosenDateTime!.minute);
    bool sec = (DateTime.now().second == chosenDateTime!.second);

    return year && month && day && hour && min && sec;
  }
}
