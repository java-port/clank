@Override
@SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
public KnownHeader clone() {
  return new KnownHeader(this);
}

public KnownHeader move() {
  return new KnownHeader(JD$Move.INSTANCE, this);
}

@Override
public boolean $noteq(KnownHeader other) {
  return $noteq_KnownHeader(this, other);
}

@Override
public boolean $eq(KnownHeader other) {
  return $eq_KnownHeader(this, other);
}
