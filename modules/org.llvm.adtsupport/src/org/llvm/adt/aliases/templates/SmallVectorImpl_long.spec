PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplLong
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = long
BOXED_TYPE = Long
ARRAY_TYPE = long
NEW_ZERO_ARRAY = new$long(0)
NEW_CAPACITY_ARRAY = new$long(capacity)
POINTER_TYPE = long$ptr
POINTER_FACTORY_MTD = create_long$ptr
REFERENCE_TYPE = long$ref
REFERENCE_FACTORY_MTD = create_long$ref
ITERATOR_TYPE = long$ptr
GENERIC_ITERATOR = long$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorLong
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DESTROY_IMPL = // No need to destroy primitive types
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
FINAL_DESTROY=final
NATIVE_CONTAINER = NativeContainerLong
JAVA_ITERATOR = JavaIteratorLong
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=