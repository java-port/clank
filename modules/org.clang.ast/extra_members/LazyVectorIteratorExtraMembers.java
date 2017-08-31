private type$ptr<T> $addr() {      
  if (isLoaded()) {
    return Self.Loaded.end().$add(this.I.$deref());
  }
  return Self.Local.begin().$add(this.I.$deref());
}

@Override public iterator<T, Source> clone() {
  return new iterator(this.Self, this.I.$deref());
}

@Override public boolean $eq(Object other) {
  if (other instanceof LazyVector.iterator) {
    LazyVector.iterator otherIt = (LazyVector.iterator) other;
    if (Self == otherIt.Self) {
      return this.I.$deref() == otherIt.I.$deref();
    }
  }
  return false;
}

@Override public type$ref<T> star$ref() {
  return $addr().star$ref();
}
