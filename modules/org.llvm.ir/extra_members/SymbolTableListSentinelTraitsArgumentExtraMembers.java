private final Argument $sentinelField = new Argument();

@Override
public Argument $SentinelField() {
  return $sentinelField;
}

@Override
public Class<Argument> $getValueSubClass() {
  return Argument.class;
}