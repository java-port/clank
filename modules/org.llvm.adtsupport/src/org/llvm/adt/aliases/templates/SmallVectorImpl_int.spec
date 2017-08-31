PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplInt
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = int
BOXED_TYPE = Integer
ARRAY_TYPE = int
NEW_ZERO_ARRAY = new$int(0)
NEW_CAPACITY_ARRAY = new$int(capacity)
POINTER_TYPE = int$ptr
POINTER_FACTORY_MTD = create_int$ptr
REFERENCE_TYPE = int$ref
REFERENCE_FACTORY_MTD = create_int$ref
ITERATOR_TYPE = int$ptr
GENERIC_ITERATOR = int$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorInt
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
NATIVE_CONTAINER = NativeContainerInt
JAVA_ITERATOR = JavaIteratorInt
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=