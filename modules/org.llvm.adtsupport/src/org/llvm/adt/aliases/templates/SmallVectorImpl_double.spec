PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplDouble
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = double
BOXED_TYPE = Double
ARRAY_TYPE = double
NEW_ZERO_ARRAY = new$double(0)
NEW_CAPACITY_ARRAY = new$double(capacity)
POINTER_TYPE = double$ptr
POINTER_FACTORY_MTD = create_double$ptr
REFERENCE_TYPE = double$ref
REFERENCE_FACTORY_MTD = create_double$ref
ITERATOR_TYPE = double$ptr
GENERIC_ITERATOR = double$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorDouble
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
NATIVE_CONTAINER = NativeContainerDouble
JAVA_ITERATOR = JavaIteratorDouble
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
