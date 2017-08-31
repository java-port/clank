void mapping(IO /*&*/io, T /*&*/fields);
default boolean $hasValidate() {return false;}
default StringRef validate(IO /*&*/io, T /*&*/fields){throw new UnsupportedOperationException();}
