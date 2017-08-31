@Override
public void push_back_T$RR(IntrusiveRefCntPtr<PathDiagnosticPiece> val) {
  // T$RR must move our input
  super.push_back_T$RR(val);
  assert !val.$bool() : "push_back above had to release input val " + val;
}

@Override
public void push_front_T$RR(IntrusiveRefCntPtr<PathDiagnosticPiece> val) {
  // T$RR must move our input
  super.push_front_T$RR(val);
  assert !val.$bool() : "push_front above had to release input val " + val;
}
