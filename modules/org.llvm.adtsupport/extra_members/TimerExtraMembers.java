public /*explicit*/ Timer(char$ptr N) {
  this(new StringRef(N));
}

public /*explicit*/ Timer(char$ptr N, TimerGroup /*&*/ tg) {
  this(new StringRef(N), tg);
}
