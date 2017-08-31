@Override public boolean $less(Object obj) {
  return Unsigned.$less_uint(value, ((LLVMConstants)obj).value);
}

@Override public boolean $lesseq(Object obj) {
  return Unsigned.$lesseq_uint(value, ((LLVMConstants)obj).value);
}
