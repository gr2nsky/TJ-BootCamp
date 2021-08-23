import 'package:flutter/material.dart';
import 'package:textfiled_login_ex_app/login.dart';
import 'package:textfiled_login_ex_app/loginSucc.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  String id = "root";


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) {
          return LogIn();
        },
        '/loginSuccess': (context) {
          return LoginSuccess(id: id);
        },
      },
    );
  }
}
