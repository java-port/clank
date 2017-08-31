PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplUChar
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = byte
BOXED_TYPE = Byte
ARRAY_TYPE = byte
NEW_ZERO_ARRAY = new$uchar(0)
NEW_CAPACITY_ARRAY = new$uchar(capacity)
POINTER_TYPE = uchar$ptr
POINTER_FACTORY_MTD = create_uchar$ptr
REFERENCE_TYPE = uchar$ref
REFERENCE_FACTORY_MTD = create_uchar$ref
ITERATOR_TYPE = uchar$ptr
GENERIC_ITERATOR = uchar$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorUChar
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DESTROY_IMPL = // No need to destroy primitive types
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element == 0 ? "<EOF>" : (char)element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
FINAL_DESTROY=final
NATIVE_CONTAINER = NativeContainerUChar
JAVA_ITERATOR = JavaIteratorUChar
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
