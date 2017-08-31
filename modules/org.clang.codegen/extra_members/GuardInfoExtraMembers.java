@Override
public GuardInfo $assign(GuardInfo other) {
  this.BitIndex = other.BitIndex;
  this.Guard = other.Guard;
  return this;
}

@Override
public GuardInfo clone() {
  GuardInfo res = new GuardInfo();
  res.Guard = this.Guard;
  res.BitIndex = this.BitIndex;
  return res;
}
