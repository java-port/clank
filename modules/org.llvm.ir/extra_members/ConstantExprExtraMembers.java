public static Constant /*P*/ getCompare(/*uint*/int Predicate, Constant /*P*/ C1, 
          Constant /*P*/ C2) {
  return getCompare(Predicate, C1, 
          C2, false);
}
public static Constant /*P*/ getCompare(/*uint*/int Predicate, Constant /*P*/ C1, 
          Constant /*P*/ C2, boolean OnlyIfReduced/*= false*/) {
  return getCompare($uint2ushort(Predicate), C1, 
          C2, OnlyIfReduced);
}
