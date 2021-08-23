import 'package:flutter/material.dart';
import 'package:stateful_widget_listview/stateItem.dart';

class FirstPage extends StatelessWidget {
  final List<StateInfo> list;

  const FirstPage({Key? key, required this.list}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: ListView.builder(
            itemBuilder: (context, position) {
              return GestureDetector(
                child: Card(
                  child: Row(
                    children: [
                      Image.asset(
                        list[position].imagePath,
                        height: 100,
                        width: 100,
                        fit: BoxFit.contain,
                      ),
                      Text(list[position].previewName)
                    ],
                  ),
                ),
                onTap: () {
                  _showDialog(context, list[position].stateName);
                },
              );
            },
            itemCount: list.length,
          ),
        ),
      ),
    );
  }
}

void _showDialog(BuildContext context, String name) {
  showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("국가명"),
          content: Text("이 국기는 $name의 국기입니다."),
          actions: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('종료'),
            )
          ],
        );
      });
}
