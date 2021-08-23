import 'dart:async';

import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
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

class _MyHomePageState extends State<MyHomePage> {
  final Completer<WebViewController> _controller =
      Completer<WebViewController>();
  //for indicator
  bool isLoading = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("WebView"),
      ),
      //z축으로 쌓음 (너비, 높이 말고 앞 뒤로)
      body: Stack(
        children: [
          WebView(
            initialUrl: 'https://www.daum.net',
            javascriptMode: JavascriptMode.unrestricted, //javascript를 허용
            onWebViewCreated: (WebViewController webCiewController) {
              _controller.complete(webCiewController);
            },
            onPageFinished: (finish) {
              setState(() {
                isLoading = false;
              });
            },
            onPageStarted: (start) {
              setState(() {
                isLoading = true;
              });
            },
          ),
          isLoading
              ? Center(
                  child: CircularProgressIndicator(),
                )
              : Stack(),
        ],
      ),
      floatingActionButton: FutureBuilder<WebViewController>(
          //현재페이지를 저장해두었다가 돌아올 수 있게끔 저장 -> 화면 다 뜬 후에 저장
          future: _controller.future,
          //AsyncSnapshot : 현재위치 저장0
          builder: (BuildContext context,
              AsyncSnapshot<WebViewController> controller) {
            if (controller.hasData) {
              return FloatingActionButton(
                  child: Icon(Icons.arrow_back),
                  backgroundColor: Colors.redAccent,
                  onPressed: () {
                    controller.data!.goBack();
                  });
            }
            return Container(); //web화면과는 별개이므로 플로팅버튼은 컨테이너 속성을 가져야함
          }),
    );
  }
}
