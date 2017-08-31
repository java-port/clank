private static final DenseMapInfoCanQual$Type INFO = new DenseMapInfoCanQual$Type();  

private DenseMapInfoCanQual$Type() {
  super(new CanQual<>(), new CanQual<>());
}

public static DenseMapInfoCanQual$Type $Info() {
  return INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}  
