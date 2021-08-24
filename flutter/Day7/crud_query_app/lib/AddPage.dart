import 'package:flutter/material.dart';
import 'package:crud_query_app/main.dart';

class AddPage extends StatefulWidget {
  const AddPage({Key? key}) : super(key: key);

  @override
  _AddPageState createState() => _AddPageState();
}

class _AddPageState extends State<AddPage> {
  late TextEditingController _scodeEditController;
  late TextEditingController _nameEditController;
  late TextEditingController _deptEditController;
  late TextEditingController _phoneEditController;

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
                ],
              ),
            ),
          ),
        ));
  }
}
