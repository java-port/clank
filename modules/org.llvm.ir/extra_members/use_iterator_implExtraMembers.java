public type$ptr<UseT> getPtr() {
  return (type$ptr<UseT>)U.$This$Ptr();
}

@Override
public use_iterator_impl<UseT> clone() {
  return new use_iterator_impl<UseT>(this.U);
}

int $sub(type$ptr<UseT> other) {
  return getPtr().$sub(other);
}

@Override
public boolean $eq(Object other) {
  return $eq((use_iterator_impl<UseT>)other);
}
