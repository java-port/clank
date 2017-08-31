@Override
public ZeroState clone() {
  return new ZeroState(this);
}

@Override
public boolean $less(Object obj) {
  return $less((ZeroState) obj);
}
