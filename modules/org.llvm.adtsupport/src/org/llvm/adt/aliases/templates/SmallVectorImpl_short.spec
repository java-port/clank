PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplShort
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = short
BOXED_TYPE = Short
ARRAY_TYPE = short
NEW_ZERO_ARRAY = new$short(0)
NEW_CAPACITY_ARRAY = new$short(capacity)
POINTER_TYPE = short$ptr
POINTER_FACTORY_MTD = create_short$ptr
REFERENCE_TYPE = short$ref
REFERENCE_FACTORY_MTD = create_short$ref
ITERATOR_TYPE = short$ptr
GENERIC_ITERATOR = short$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorShort
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
NATIVE_CONTAINER = NativeContainerShort
JAVA_ITERATOR = JavaIteratorShort
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=