public CompareLineStatePointers() { }

@Override
public boolean compare(LineState a, LineState b) {
  return $call(a, b);
}
