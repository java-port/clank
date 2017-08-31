private final GraphTraits<GraphT> GT;

private /*inline*/ df_iterator(df_iterator</*class*/ GraphT> other) {
  this.GT = other.GT;
  this.VisitStack = new std.vector(other.VisitStack);
}

@Override
public df_iterator clone() {
  return new df_iterator(this);
}
