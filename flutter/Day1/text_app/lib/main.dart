import 'package:flutter/material.dart';

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

//stl
class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Text App"),
        backgroundColor: Colors.redAccent,
      ),
      body: Center(
        child: Column(
          //가운데정렬
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Divider(
              height: 30.0,
              color: Colors.grey[700],
              thickness: 0.5,
            ),
            Text("유비"),
            Text("관우"),
            Text("장비"),
            SizedBox(
              height: 50.0,
            ),
            Text(
              "조조",
              style: TextStyle(
                color: Colors.blue,
                letterSpacing: 5.0,
                fontSize: 28.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            Text("여포"),
            Text("동탁"),
          ],
        ),
      ),
    );
  }
}
