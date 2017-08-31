@Override
public KeyStatus $assign(KeyStatus value) {
  this.Required = value.Required;
  this.Seen = value.Seen;
  return this;
}

@Override
public KeyStatus clone() {
  return new KeyStatus(this);
}
