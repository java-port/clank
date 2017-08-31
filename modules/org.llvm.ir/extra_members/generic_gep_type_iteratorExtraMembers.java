public generic_gep_type_iterator(generic_gep_type_iterator<T> other) {
  this.OpIt = $Clone(other.OpIt);
  this.CurTy = $Clone(other.CurTy);
  this.AddrSpace = other.AddrSpace;
}

@Override
public generic_gep_type_iterator<T> clone() {
  return new generic_gep_type_iterator<>(this);
}
