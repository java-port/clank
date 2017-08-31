@Override public TimeRecord clone() {
  return new TimeRecord(this);
}

@Override public boolean $less(Object obj) {
  return this.$less((TimeRecord)obj);
}
