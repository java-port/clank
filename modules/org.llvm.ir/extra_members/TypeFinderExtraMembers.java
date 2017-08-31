@Override
public java.util.Iterator<StructType /*P*/> iterator() {
  return new JavaIterator<>(begin(), end());
}

public type$ref<StructType /*P*/ /*&*/> re$at(/*uint*/int Idx) {
  return StructTypes.ref$at(Idx);
} 
