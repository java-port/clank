public basic_collection_iterator(basic_collection_iterator</*class*/ BaseT, /*class*/ ValueT> /*P*/ B) {
  this.Base = /*ParenListExpr*/B.Base;
}

@Override
public basic_collection_iterator clone() {
  return new basic_collection_iterator(this);
}
