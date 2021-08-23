import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; //for json

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
  String result = '';
  String search = "플러터";
  late List data;
  late TextEditingController _inputController;
  late ScrollController _scrollController;
  int page = 1;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    data = [];

    _inputController = TextEditingController();
    _scrollController = ScrollController();

    _scrollController.addListener(() {
      //리스트의 마지막일 경우에 사용
      if (_scrollController.offset >=
              _scrollController.position.maxScrollExtent &&
          !_scrollController.position.outOfRange) {
        print('bottom');
        page++;
        getJSONData();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: TextField(
          controller: _inputController,
          style: TextStyle(color: Colors.white),
          keyboardType: TextInputType.text,
          decoration: InputDecoration(hintText: '검색어를 입력하세요'),
        ),
      ),
      body: Container(
        child: Center(
          child: data.length == 0
              ? Text(
                  'No Data',
                  style: TextStyle(fontSize: 20.0),
                  textAlign: TextAlign.center,
                )
              : ListView.builder(
                  scrollDirection: Axis.vertical,
                  itemBuilder: (context, index) {
                    return Card(
                      child: Container(
                        child: Row(
                          children: [
                            Image.network(
                              data[index]['thumbnail'],
                              height: 150,
                              width: 100,
                              fit: BoxFit.contain,
                            ),
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  data[index]['title'].toString().length < 26
                                      ? Text(
                                          data[index]['title'].toString(),
                                          style: TextStyle(
                                              fontWeight: FontWeight.bold),
                                        )
                                      : Text(
                                          data[index]['title'].toString(),
                                          style: TextStyle(
                                              fontWeight: FontWeight.bold),
                                        ),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  Text(data[index]['authors'].toString()),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  Text(data[index]['sale_price'].toString()),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  Text(data[index]['status'].toString())
                                ],
                              ),
                            )
                          ],
                        ),
                      ),
                    );
                  },
                  itemCount: data.length,
                  controller: _scrollController,
                ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          data.clear();
          page = 1;

          setState(() {
            search = _inputController.value.text;
          });

          getJSONData();
        },
        child: Icon(Icons.file_download),
      ),
    );
  }

  Future<String> getJSONData() async {
    var url = Uri.parse(
        'https://dapi.kakao.com/v3/search/book?target=title&page=$page&query=$search');
    var response = await http.get(url,
        headers: {"Authorization": "KakaoAK 6bbd11608517d4c876f0a3a2a9595cef"});
    print(response.body);

    setState(() {
      var dataConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      List result = dataConvertedJSON['documents'];
      print('result : $result');
      data.addAll(result);
    });
    return "Success";
  }
}
