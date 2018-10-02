public boolean evenlySpaced(int a, int b, int c) {
  double ave = (a + b + c) / 3.0;
  return ave == a || ave == b || ave == c;
}
