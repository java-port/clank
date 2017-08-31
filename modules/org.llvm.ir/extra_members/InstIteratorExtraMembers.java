public  InstIterator(InstIterator</*class*/ BB_t, /*class*/ BB_i_t, /*class*/ BI_t, /*class*/ II_t> other) {
  throw new UnsupportedOperationException("EmptyBody");
}

@Override
public InstIterator</*class*/ BB_t, /*class*/ BB_i_t, /*class*/ BI_t, /*class*/ II_t>  clone() {
  return new InstIterator(this);
}
