public VecDesc() {
  this.ScalarFnName = create_char$null$ptr();
  this.VectorFnName = create_char$null$ptr();
  this.VectorizationFactor = 0;
}

/** It's a caller responsibility to clone pointers if they are not constant */
public VecDesc(char$ptr ScalarFnName, char$ptr VectorFnName, int VectorizationFactor) {
  this.ScalarFnName = ScalarFnName;
  this.VectorFnName = VectorFnName;
  this.VectorizationFactor = VectorizationFactor;
}

public VecDesc(VecDesc other) {
  this.ScalarFnName = other.ScalarFnName;
  // in C++ it's const char * - I don't think we need to clone
  this.VectorFnName = other.VectorFnName;
  this.VectorizationFactor = other.VectorizationFactor;
}

@Override
public VecDesc clone() {
  return new VecDesc(this);
}