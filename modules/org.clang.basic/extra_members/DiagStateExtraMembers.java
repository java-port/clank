@Override public DiagState clone() { return new DiagState(this); }

@Override
public Iterator<std.pairUIntType<DiagnosticMapping>> iterator() {
  return new JavaIterator(begin(), end());
}
