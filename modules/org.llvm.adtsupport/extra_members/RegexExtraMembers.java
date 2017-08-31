public Regex() {
  this.RegExpString = null;
}

@Override
public Regex clone() {
  return new Regex(this);
}

@Override
public boolean $eq(Regex other) {
  return other != null && other.RegExpString.equals(this.RegExpString);
}
