@Override
public boolean $less(Object obj) {
  return $less((CharUnits) obj);
}

@Override
public boolean $greater(Object obj) {
  return $greater((CharUnits) obj);
}

@Override
public CharUnits clone() {
  return new CharUnits(this);
}

@Override
public CharUnits move() {
  return new CharUnits().$assignMove(this);
}
