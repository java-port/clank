public FieldEncoding() {
  this.HasName = false;
  this.Enc = std.string.EMPTY;
}
@Override
public boolean $less(Object obj) {
  return $less((FieldEncoding) obj);
}