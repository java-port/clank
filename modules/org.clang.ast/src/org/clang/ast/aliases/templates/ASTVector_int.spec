FILE_NAME = ASTVectorInt
CLASS_SUFFIX =
CLASS_TYPE = ASTVectorInt
VALUE_TYPE = int
BOXED_TYPE = Integer
VALUE_CLASS = int.class
PTR_TYPE = int$ptr
ITER_TYPE = int$iterator<?>
GENERIC_ITER_TYPE = int$iterator<?>
REVERSE_ITER_TYPE = std.reverse_iteratorInt
CREATE_PTR = create_int$ptr
CREATE_NULL_PTR = create_int$null$ptr
CREATE_ARRAY = new$int
JAVA_ITERATOR = JavaIteratorInt
UC_TEMPLATE_PREFIX = <DestIter extends int$iterator<DestIter>>
CONSTRUCT_RANGE_IMPL = for (; Native.$noteq_ptr(S, E); S.$preInc())  { S.$set(Elt); }
DESTROY_RANGE_IMPL = /* No need to destroy anything*/
IS_DATA_POINTER_LIKE_IMPL = return false;
DEFAULT_CTOR_DECL = @Converted(kind = Converted.Kind.MANUAL_ADDED) \
  public ASTVectorInt() { \
    this(0); \
  }
ASSIGN_MOVE_ASSERTION = // assert this.defaultValue == null ? RHS.defaultValue == null : Native.$eq(this.defaultValue, RHS.defaultValue)
ELEM_TO_STRING=elem
