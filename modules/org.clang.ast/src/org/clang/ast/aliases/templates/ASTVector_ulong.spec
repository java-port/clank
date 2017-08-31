FILE_NAME = ASTVectorULong
CLASS_SUFFIX =
CLASS_TYPE = ASTVectorULong
VALUE_TYPE = long
BOXED_TYPE = Long
VALUE_CLASS = long.class
PTR_TYPE = ulong$ptr
ITER_TYPE = ulong$iterator<?>
GENERIC_ITER_TYPE = ulong$iterator<?>
REVERSE_ITER_TYPE = std.reverse_iteratorULong
CREATE_PTR = create_ulong$ptr
CREATE_NULL_PTR = create_ulong$null$ptr
CREATE_ARRAY = new$ulong
JAVA_ITERATOR = JavaIteratorULong
UC_TEMPLATE_PREFIX = <DestIter extends ulong$iterator<DestIter>>
CONSTRUCT_RANGE_IMPL = for (; Native.$noteq_ptr(S, E); S.$preInc())  { S.$set(Elt); }
DESTROY_RANGE_IMPL = /* No need to destroy anything*/
IS_DATA_POINTER_LIKE_IMPL = return false;
DEFAULT_CTOR_DECL = @Converted(kind = Converted.Kind.MANUAL_ADDED) \
  public ASTVectorULong() { \
    this(0); \
  }
ASSIGN_MOVE_ASSERTION = // assert this.defaultValue == null ? RHS.defaultValue == null : Native.$eq(this.defaultValue, RHS.defaultValue)
ELEM_TO_STRING=elem