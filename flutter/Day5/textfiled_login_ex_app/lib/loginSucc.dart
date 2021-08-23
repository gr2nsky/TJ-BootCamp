import 'package:flutter/material.dart';

class LoginSuccess extends StatefulWidget {
  static const String secondPageRouteName = "/LoginSuccess";
  final String id; 
  
  const LoginSuccess({Key? key, required this.id}) : super(key: key);

  @override
  _LoginSuccessState createState() => _LoginSuccessState();
}

class _LoginSuccessState extends State<LoginSuccess> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text("$id님 환영합니다!"),
        backgroundColor: Colors.black,
      ),
      body: Center(
        child: ,
      ),
    );
  }
}
