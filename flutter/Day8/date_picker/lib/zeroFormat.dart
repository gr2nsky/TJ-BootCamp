class ZeroFormat {
  String appendZero(int input) {
    return input < 10 ? "0$input" : "$input";
  }
}
