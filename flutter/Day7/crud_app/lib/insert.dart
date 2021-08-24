import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class Insert extends StatefulWidget {
  const Insert({Key? key}) : super(key: key);

  @override
  _InsertState createState() => _InsertState();
}

class _InsertState extends State<Insert> {
  late TextEditingController _scodeEditController;
  late TextEditingController _nameEditController;
  late TextEditingController _deptEditController;
  late TextEditingController _phoneEditController;

  String code = '';
  String name = '';
  String dept = '';
  String phone = '';
  String result = "ERROR";

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _scodeEditController = new TextEditingController();
    _nameEditController = new TextEditingController();
    _deptEditController = new TextEditingController();
    _phoneEditController = new TextEditingController();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("insert & return for CRUD"),
        ),
        body: SingleChildScrollView(
          child: Container(
            child: Padding(
              padding: const EdgeInsets.all(20.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Column(
                      children: [
                        Text(
                          "학번을 입력하세요",
                          style: TextStyle(fontSize: 10, color: Colors.grey),
                        ),
                        TextField(
                          controller: _scodeEditController,
                          keyboardType: TextInputType.text,
                          maxLines: 1,
                        ),
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Column(
                      children: [
                        Text(
                          "성명을 입력하세요",
                          style: TextStyle(fontSize: 10, color: Colors.grey),
                        ),
                        TextField(
                          controller: _nameEditController,
                          keyboardType: TextInputType.text,
                          maxLines: 1,
                        ),
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Column(
                      children: [
                        Text(
                          "전공을 입력하세요",
                          style: TextStyle(fontSize: 10, color: Colors.grey),
                        ),
                        TextField(
                          controller: _deptEditController,
                          keyboardType: TextInputType.text,
                          maxLines: 1,
                        ),
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Column(
                      children: [
                        Text(
                          "전화번호를 입력하세요",
                          style: TextStyle(fontSize: 10, color: Colors.grey),
                        ),
                        TextField(
                          controller: _phoneEditController,
                          keyboardType: TextInputType.text,
                          maxLines: 1,
                        ),
                      ],
                    ),
                  ),
                  ElevatedButton(
                      onPressed: () {
                        setState(() {
                          code = _scodeEditController.value.text;
                          name = _nameEditController.value.text;
                          dept = _deptEditController.value.text;
                          phone = _phoneEditController.value.text;
                        });
                        insertJSON();
                      },
                      child: Text("입력")),
                ],
              ),
            ),
          ),
        ));
  }

  Future<String> insertJSON() async {
    var query = 'code=$code&name=$name&dept=$dept&phone=$phone';
    print(query);
    var url = Uri.parse(
        'http://localhost:8080/Flutter/student_insert_return_flutter.jsp?$query');
    var response = await http.get(url);
    print(response.body);

    setState(() {
      var resultConvertedJSON = json.decode(utf8.decode(response.bodyBytes));
      result = resultConvertedJSON['result'];
      resultUIControll();
    });

    return "temp";
  } //insertJSON()

  resultUIControll() {
    if (result == "OK") {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("입력 결과"),
            content: Text("입력이 완료되었습니다."),
            actions: <Widget>[
              ElevatedButton(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.blue)),
                onPressed: () {
                  Navigator.pop(context);
                },
                child: Text("확인"),
              ),
            ],
          );
        },
      );
    } else {
      final snackBar = SnackBar(
        content: Text('사용자 정보 입력에 문제가 발생하였습니다.'),
        duration: Duration(seconds: 2),
        backgroundColor: Colors.red,
      );
      ScaffoldMessenger.of(context).showSnackBar(snackBar);
    }
  } // resultUIControll()

}
