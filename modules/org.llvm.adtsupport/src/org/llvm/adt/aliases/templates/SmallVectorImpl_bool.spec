PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplBool
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = boolean
BOXED_TYPE = Boolean
ARRAY_TYPE = boolean
NEW_ZERO_ARRAY = new$bool(0)
NEW_CAPACITY_ARRAY = new$bool(capacity)
POINTER_TYPE = bool$ptr
POINTER_FACTORY_MTD = create_bool$ptr
REFERENCE_TYPE = bool$ref
REFERENCE_FACTORY_MTD = create_bool$ref
ITERATOR_TYPE = bool$ptr
GENERIC_ITERATOR = bool$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorBool
REV_ITERATOR_INTERFACE = bool$iterator<reverse_iterator>
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DESTROY_IMPL = // No need to destroy primitive types
DEFAULT_VALUE = false
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
FINAL_DESTROY=final
NATIVE_CONTAINER = NativeContainerBool
JAVA_ITERATOR = JavaIteratorBool
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=