@Override
public PrivateHelpersTy $assign(PrivateHelpersTy $Prm0) {
  this.Original = $Prm0.Original;
  this.PrivateCopy = $Prm0.PrivateCopy;
  this.PrivateElemInit = $Prm0.PrivateElemInit;
  return this;
}

@Override
public PrivateHelpersTy clone() {
  return new PrivateHelpersTy(this);
}

@Override
public PrivateHelpersTy move() {
  return new PrivateHelpersTy(JD$Move.INSTANCE, this);
}

public PrivateHelpersTy() {
  this.Original = null;
  this.PrivateCopy = null;
  this.PrivateElemInit = null;
}
