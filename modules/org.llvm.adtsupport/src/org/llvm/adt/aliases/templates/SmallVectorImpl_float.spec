PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplFloat
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = float
BOXED_TYPE = Float
ARRAY_TYPE = float
NEW_ZERO_ARRAY = new$float(0)
NEW_CAPACITY_ARRAY = new$float(capacity)
POINTER_TYPE = float$ptr
POINTER_FACTORY_MTD = create_float$ptr
REFERENCE_TYPE = float$ref
REFERENCE_FACTORY_MTD = create_float$ref
ITERATOR_TYPE = float$ptr
GENERIC_ITERATOR = float$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorFloat
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
NATIVE_CONTAINER = NativeContainerFloat
JAVA_ITERATOR = JavaIteratorFloat
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=