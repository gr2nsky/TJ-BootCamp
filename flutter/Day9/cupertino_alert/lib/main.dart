import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

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
  var image = 'images/light_on.png';
  bool lampSataus = true;

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
        home: CupertinoPageScaffold(
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Alert',
              style: TextStyle(
                fontSize: 20.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            Container(
              child: Image.asset(
                image,
                width: 300,
                height: 600,
              ),
              width: 300,
              height: 600,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                CupertinoButton(
                    child: Text("켜기"),
                    onPressed: () {
                      turnOnLamp();
                    }),
                CupertinoButton(
                    child: Text("끄기"),
                    onPressed: () {
                      turnOffLamp();
                    }),
              ],
            )
          ],
        ),
      ),
    ));
  }

  void turnOnLamp() {
    if (lampSataus == true) {
      showCupertinoDialog(
          context: context,
          builder: (context) {
            return CupertinoAlertDialog(
              title: Text("경고"),
              content: Text("이미 켜져 있습니다."),
              actions: [
                CupertinoDialogAction(
                    isDefaultAction: true,
                    child: Text("확인"),
                    onPressed: () {
                      Navigator.pop(context);
                    }),
              ],
            );
          });
    } else {
      showCupertinoDialog(
          context: context,
          builder: (context) {
            return CupertinoAlertDialog(
              title: Text("램크 켜기"),
              content: Text("램프를 켜시겠습니까?"),
              actions: [
                CupertinoDialogAction(
                  child: Text("네"),
                  onPressed: () {
                    lampSataus = true;
                    setState(() {
                      image = 'images/light_on.png';
                    });
                    Navigator.pop(context);
                  },
                ),
                CupertinoDialogAction(
                    isDefaultAction: true,
                    child: Text("아니요"),
                    onPressed: () {
                      Navigator.pop(context);
                    }),
              ],
            );
          });
    }
  }

  void turnOffLamp() {
    if (lampSataus == true) {
      showCupertinoDialog(
          context: context,
          builder: (context) {
            return CupertinoAlertDialog(
              title: Text("램크 끄기"),
              content: Text("램프를 끄시겠습니까?"),
              actions: [
                CupertinoDialogAction(
                  child: Text("네"),
                  onPressed: () {
                    lampSataus = false;
                    setState(() {
                      image = 'images/light_off.png';
                    });
                    Navigator.pop(context);
                  },
                ),
                CupertinoDialogAction(
                    isDefaultAction: true,
                    child: Text("아니요"),
                    onPressed: () {
                      Navigator.pop(context);
                    }),
              ],
            );
          });
    } else {
      showCupertinoDialog(
          context: context,
          builder: (context) {
            return CupertinoAlertDialog(
              title: Text("경고"),
              content: Text("이미 꺼져 있습니다."),
              actions: [
                CupertinoDialogAction(
                    isDefaultAction: true,
                    child: Text("확인"),
                    onPressed: () {
                      Navigator.pop(context);
                    }),
              ],
            );
          });
    }
  }
}
