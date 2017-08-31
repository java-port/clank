public /*inline*/ SourceLocation /*&*/ $assignMove(int /*&&*/$Prm0) {
  this.ID = $Prm0;
  return /*Deref*/this;
}

@Override
public String toString() {
  return toString(ID);
} 

public static String toString(/*SourceLocation*/int Loc) {
  if (isInvalid(Loc)) {
    return "INVALID";
  }
  return (isMacroID(Loc) ? "[M:":"[F:") + getOffset(Loc) + "]";
}

@Override
public SourceLocation clone() {
  return new SourceLocation(this);
}

@Override
public boolean $noteq(SourceLocation other) {
  return BasicClangGlobals.$noteq_SourceLocation$C(this, other);
 }

@Override
public boolean $eq(SourceLocation other) {
  return BasicClangGlobals.$eq_SourceLocation$C(this, other);
}

@Override
public int $sizeof() {
  return $sizeof_SourceLocation();
}

public static int $sizeof_SourceLocation() {
  return NativeType.BYTES_IN_JAVA_OBJECT_HEADER +
         NativeType.BYTES_IN_INT;
}

//////////////////////////////////////////////////////////////////////////////
// Performance Statistics
private static long instances = 0;
private static void trackInstance() {
  if (NativeTrace.STATISTICS) instances++;
}

public static void clearStatistics() {
  instances = 0;
}
// JAVA: pass OS and return some integral value
public static long PrintStats(raw_ostream out) {
  out.$out(String.format("%22s created:\t", SourceLocation.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
  NativeTrace.dumpStatisticValue(SourceLocation.class.getSimpleName(), instances);
  return instances;
}  

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override public void swap(NativeSwappable RHS) {
  SourceLocation other = (SourceLocation) RHS;
  int tmp = this.ID;
  this.ID = other.ID;
  other.ID = tmp;
}

public static final SourceLocation DEFAULT = new SourceLocation();

public static final Comparator<SourceLocation> COMPARATOR = new Comparator<SourceLocation>() {
  @Override
  public int compare(SourceLocation lhs, SourceLocation rhs) {
    return $compare_uint(lhs.ID, rhs.ID);
  }
};
