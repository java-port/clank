public SynthesizeIvarChunk() {
}

SynthesizeIvarChunk(SynthesizeIvarChunk $Prm0) {
  this.Ivar = $Prm0.Ivar;
  this.Size = $Prm0.Size;
}

public @Override boolean $less(Object other) {
  return $less_SynthesizeIvarChunk$C(this, (SynthesizeIvarChunk) other);
}

@Override public SynthesizeIvarChunk clone() {
  return new SynthesizeIvarChunk(this);
}
