@Override
public int compareTo(StringMapEntryBase RHS) {
  if (RHS == this) {
      return 0;
  }
  int LHSLen = this.getKeyLength();
  int RHSLen = RHS.getKeyLength();
  {
    // Check the prefix for a mismatch.
    int Res = std.memcmp(getKeyArray(), getKeyArrayIndex(), RHS.getKeyArray(), RHS.getKeyArrayIndex(), std.min(LHSLen, RHSLen));
    if ((Res != 0)) {
      return Res < 0 ? -1 : 1;
    }
  }

  // Otherwise the prefixes match, so we only need to check the lengths.
  if (LHSLen == RHSLen) {
    return 0;
  }
  return LHSLen < RHSLen ? -1 : 1;    
}
