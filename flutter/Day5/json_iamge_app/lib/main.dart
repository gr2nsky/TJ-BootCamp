import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert'; // for json

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

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String result = '';
  late List data;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    data = [];
    getJSONData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Json Images Test"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Container(
          child: Center(
              child: data.length == 0
                  ? Text(
                      "데이터가 없습니다.",
                      style: TextStyle(fontSize: 20),
                      textAlign: TextAlign.center,
                    )
                  : ListView.builder(
                      //scrollDirection: Axis.horizontal,
                      itemBuilder: (context, index) {
                        return Card(
                          child: Column(
                            children: [
                              Row(
                                children: [
                                  Image(
                                      width: 100.0,
                                      image: NetworkImage(
                                          data[index]['image'].toString()),
                                      fit: BoxFit.contain),
                                ],
                              )
                            ],
                          ),
                        );
                      },
                      itemCount: data.length,
                    )),
        ),
      ),
    );
  }

  Future<String> getJSONData() async {
    var url = Uri.parse('http://localhost:8080/Flutter/images.json');
    var response = await http.get(url);
    //print(response.body);

    setState(() {
      var dataConvertedJSON = json.decode(response.body);
      List result = dataConvertedJSON['results'];
      //print(result);
      data.addAll(result);
    });

    return 'temp';
  }
}
