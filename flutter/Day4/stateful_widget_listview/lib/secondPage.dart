import 'package:flutter/material.dart';
import 'package:stateful_widget_listview/stateItem.dart';

class SecondPage extends StatefulWidget {
  final List<StateInfo> list;

  const SecondPage({Key? key, required this.list}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  final questionController = TextEditingController();
  final stateNameController = TextEditingController();
  var _imagePath;

  @override
  Widget build(BuildContext context) {
    return Scaffold();
  }
}
