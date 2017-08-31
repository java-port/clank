@Override
public InputFile clone() {
  return new InputFile(this);
}

@Override
public InputFile move() {
  return new InputFile(JD$Move.INSTANCE, this);
}
