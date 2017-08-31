PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplUInt
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = int
BOXED_TYPE = Integer
ARRAY_TYPE = int
NEW_ZERO_ARRAY = new$uint(0)
NEW_CAPACITY_ARRAY = new$uint(capacity)
POINTER_TYPE = uint$ptr
POINTER_FACTORY_MTD = create_uint$ptr
REFERENCE_TYPE = uint$ref
REFERENCE_FACTORY_MTD = create_uint$ref
ITERATOR_TYPE = uint$ptr
GENERIC_ITERATOR = uint$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorUInt
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
NATIVE_CONTAINER = NativeContainerUInt
JAVA_ITERATOR = JavaIteratorUInt
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
ADDITIONAL_APPEND_INSERT = \n\
\tpublic void insert_iterator$T_T(uint$ptr I, ulong$iterator<?> begin, ulong$iterator<?> end) {\n\
\t  insert_iterator$T$value_T(I, CollectionUtils.transform_ulong2uint$ptr(begin), CollectionUtils.transform_ulong2uint$ptr(end));\n\
\t}\n\