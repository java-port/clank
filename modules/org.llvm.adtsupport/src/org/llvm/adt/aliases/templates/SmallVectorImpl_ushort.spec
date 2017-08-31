PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplUShort
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = char
BOXED_TYPE = Character
ARRAY_TYPE = char
NEW_ZERO_ARRAY = new$ushort(0)
NEW_CAPACITY_ARRAY = new$ushort(capacity)
POINTER_TYPE = ushort$ptr
POINTER_FACTORY_MTD = create_ushort$ptr
REFERENCE_TYPE = ushort$ref
REFERENCE_FACTORY_MTD = create_ushort$ref
ITERATOR_TYPE = ushort$ptr
GENERIC_ITERATOR = ushort$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorUShort
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
NATIVE_CONTAINER = NativeContainerUShort
JAVA_ITERATOR = JavaIteratorUShort
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
