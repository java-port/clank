public ParamValue() {
}

@Override
public ParamValue clone() {
  return new ParamValue(this);
}

@Override
public ParamValue move() {
  return new ParamValue(JD$Move.INSTANCE, this);
}
