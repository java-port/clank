FILE_NAME = ASTVector
CLASS_SUFFIX = </*typename*/ T>
CLASS_TYPE = ASTVector<T>
VALUE_TYPE = T
BOXED_TYPE = T
VALUE_CLASS = Object.class
PTR_TYPE = type$ptr<T>
ITER_TYPE = type$iterator<?, T>
GENERIC_ITER_TYPE = type$iterator<?, ? extends T>
REVERSE_ITER_TYPE = std.reverse_iterator<T>
CREATE_PTR = create_type$ptr
CREATE_NULL_PTR = create_type$null$ptr
CREATE_ARRAY = new$Object
JAVA_ITERATOR = JavaIterator
UC_TEMPLATE_PREFIX = </*typename*/ T, DestIter extends type$iterator<DestIter, ? super T>>
CONSTRUCT_RANGE_IMPL = for (; Native.$noteq_ptr(S, E); S.$preInc())  { S.$set($tryAssign(S.$star(), Elt, isDataPointerLike())); }
DESTROY_RANGE_IMPL =     \
    if (needsCleanup) {\
      while (Native.$noteq_ptr(S, E)) {\
        E.$preDec();\
        ((Destructors.ClassWithDestructor)E.$star()).$destroy();\
      }\
    }
IS_DATA_POINTER_LIKE_IMPL = return defaultValue == null;
DEFAULT_CTOR_DECL = // No default constructor
ASSIGN_MOVE_ASSERTION = assert this.defaultValue == null ? RHS.defaultValue == null : Native.$eq(this.defaultValue, RHS.defaultValue)
ELEM_TO_STRING=NativeTrace.getIdentityStr(elem)
