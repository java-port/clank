@Override
public Boolean $op(Op k, Object obj) {
  // support this < obj
  if (k == Op.LESS) {
    if (obj instanceof Number) {
      return BasicClangGlobals.$less_LineEntry$C_uint(this, ((Number)obj).intValue());
    } else if (obj instanceof LineEntry) {
      return BasicClangGlobals.$less_LineEntry$C(this, (LineEntry)obj);
    }
  } else if (k == Op.GREATER) {
    if (obj instanceof Number) {
      return BasicClangGlobals.$less_uint_LineEntry$C(((Number) obj).intValue(), this);
    }
    assert !(obj instanceof LineEntry) : "it's strange to see call for GREATER, shouldn't be used LESS?";
  }
  return null;
}

@Override
public LineEntry clone() {
  return new LineEntry(this);
}
